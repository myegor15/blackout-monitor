package xyz.melnychuk.blackoutmonitor.monitor;

import xyz.melnychuk.blackoutmonitor.dto.DeviceDTO;
import xyz.melnychuk.blackoutmonitor.exception.AppServiceException;
import xyz.melnychuk.blackoutmonitor.monitor.listener.ConnectListener;
import xyz.melnychuk.blackoutmonitor.monitor.listener.DisconnectListener;
import xyz.melnychuk.blackoutmonitor.service.DeviceService;
import xyz.melnychuk.blackoutmonitor.service.DeviceSubscriptionService;
import xyz.melnychuk.blackoutmonitor.service.TGChatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceSessionManager {

    private final TGChatService tgChatService;
    private final DeviceService deviceService;
    private final DeviceSubscriptionService deviceSubscriptionService;

    private final List<ConnectListener> connectListeners;
    private final List<DisconnectListener> disconnectListeners;

    private final Map<String, DeviceSession> agentSessionMap = new ConcurrentHashMap<>();

    public void connect(String serialNumber, WebSocketSession wsSession) {
        Objects.requireNonNull(serialNumber, "serialNumber cannot be null");
        DeviceDTO device = Optional.ofNullable(deviceService.getBySerialNumber(serialNumber))
                .orElseThrow(() -> new AppServiceException("Device does not exist: serialNumber=" + serialNumber));
        Set<Long> tgChatIds = deviceSubscriptionService.getTGChatIdsByDeviceId(device.getId());
        Set<Long> chatRefIds = tgChatService.getRefIdsByIds(tgChatIds);
        DeviceSession deviceSession = DeviceSession.builder()
                .webSocketSession(wsSession)
                .device(device)
                .connectDate(Instant.now())
                .lastResponseDate(Instant.now())
                .recipientTgChatIds(chatRefIds)
                .build();
        agentSessionMap.put(wsSession.getId(), deviceSession);
        connectListeners.forEach(l -> l.handle(deviceSession));
    }

    public void heartbeat(String sessionId) {
        DeviceSession session = agentSessionMap.get(sessionId);
        if (session != null) {
            session.setLastResponseDate(Instant.now());
        }
    }

    public void disconnect(String sessionId) {
        DeviceSession session = agentSessionMap.remove(sessionId);
        if (session != null) {
            session.setDisconnectDate(Instant.now());
            disconnectListeners.forEach(l -> l.handle(session));
        }
    }

    public void addTgChatToRecipients(Long deviceId, Long tgChatRefId) {
        Objects.requireNonNull(deviceId, "deviceId cannot be null");
        Objects.requireNonNull(tgChatRefId, "tgChatRefId cannot be null");
        getDeviceSession(deviceId)
                .ifPresent(ds -> ds.getRecipientTgChatIds().add(tgChatRefId));
    }

    public void addTgChatFromRecipients(Long deviceId, Long tgChatRefId) {
        Objects.requireNonNull(deviceId, "deviceId cannot be null");
        Objects.requireNonNull(tgChatRefId, "tgChatRefId cannot be null");
        getDeviceSession(deviceId)
                .ifPresent(ds -> ds.getRecipientTgChatIds().add(tgChatRefId));
    }

    private Optional<DeviceSession> getDeviceSession(Long deviceId) {
        return this.agentSessionMap.values()
                .stream()
                .filter(ds -> ds.getDevice().getId().equals(deviceId))
                .findFirst();
    }

}
