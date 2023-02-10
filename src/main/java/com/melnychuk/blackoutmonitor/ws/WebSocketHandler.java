package com.melnychuk.blackoutmonitor.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melnychuk.blackoutmonitor.monitor.DeviceSessionManager;
import com.melnychuk.blackoutmonitor.ws.dto.ConnectDTO;
import com.melnychuk.blackoutmonitor.ws.dto.WebSocketActionDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@AllArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper mapper;
    private final DeviceSessionManager sessionManager;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        WebSocketActionDTO<?> dto = mapper.readValue(message.getPayload(), WebSocketActionDTO.class);
        if (dto == null) {
            throw new RuntimeException();
        }

        switch (dto.action()) {
            case CONNECT -> {
                ConnectDTO connectDTO = (ConnectDTO) dto.payload();
                sessionManager.connect(connectDTO.serialNumber(), session);
            }
            default -> throw new RuntimeException("Unknown action: " + dto.action());
        }
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        sessionManager.heartbeat(session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionManager.disconnect(session.getId());
    }
}
