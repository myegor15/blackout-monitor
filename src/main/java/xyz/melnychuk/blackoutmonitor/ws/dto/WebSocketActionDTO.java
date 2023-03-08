package xyz.melnychuk.blackoutmonitor.ws.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = WebSocketActionDTODeserializer.class)
public record WebSocketActionDTO<T> (WebSocketAction action,
                                     T payload) {
}
