package com.melnychuk.blackoutmonitor.monitor;

import com.melnychuk.blackoutmonitor.model.MonitorDevice;
import com.melnychuk.blackoutmonitor.monitor.listener.ConnectListener;
import com.melnychuk.blackoutmonitor.monitor.listener.DisconnectListener;
import com.melnychuk.blackoutmonitor.service.MonitorDeviceService;
import com.melnychuk.blackoutmonitor.service.MonitorDeviceSubscriptionService;
import com.melnychuk.blackoutmonitor.service.TGChatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
@AllArgsConstructor
public class DeviceSessionManager {

    private final TGChatService tgChatService;
    private final MonitorDeviceService monitorDeviceService;
    private final MonitorDeviceSubscriptionService monitorDeviceSubscriptionService;

    private final List<ConnectListener> connectListeners;
    private final List<DisconnectListener> disconnectListeners;

    private final Map<String, DeviceSession> agentSessionMap = new ConcurrentHashMap<>();

    public void connect(String serialNumber, WebSocketSession wsSession) {
        Objects.requireNonNull(serialNumber, "serialNumber cannot be null");
        MonitorDevice monitorDevice = monitorDeviceService.getBySerialNumber(serialNumber)
                .orElseThrow(RuntimeException::new);
        Set<Long> tgChatIds = monitorDeviceSubscriptionService.getTGChatIdSetByDeviceId(monitorDevice.getId());
        Set<Long> chatRefIds = tgChatService.getRefIdSetByTGChatIdSet(tgChatIds);
        DeviceSession deviceSession = DeviceSession.builder()
                .webSocketSession(wsSession)
                .monitorDevice(monitorDevice)
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
                .filter(ds -> ds.getMonitorDevice().getId().equals(deviceId))
                .findFirst();
    }

}
