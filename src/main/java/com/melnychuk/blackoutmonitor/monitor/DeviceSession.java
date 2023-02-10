package com.melnychuk.blackoutmonitor.monitor;

import com.melnychuk.blackoutmonitor.model.MonitorDevice;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.springframework.web.socket.WebSocketSession;

import java.time.Instant;
import java.util.Set;

@Getter
@Builder
public class DeviceSession {

    private final WebSocketSession webSocketSession;
    private final MonitorDevice monitorDevice;

    private final Instant connectDate;

    @Setter
    private Instant lastResponseDate;

    @Setter
    private Instant disconnectDate;

    @Singular
    private final Set<Long> recipientTgChatIds;
}
