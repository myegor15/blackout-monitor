package com.melnychuk.blackoutmonitor.ws.dto;

public enum WebSocketAction {
    CONNECT(ConnectDTO.class);

    private final Class<?> dtoClass;

    WebSocketAction(Class<?> dtoClass) {
        this.dtoClass = dtoClass;
    }

    Class<?> getDTOClass() {
        return this.dtoClass;
    }
    
}
