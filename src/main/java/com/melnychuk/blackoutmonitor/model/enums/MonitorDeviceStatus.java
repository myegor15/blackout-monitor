package com.melnychuk.blackoutmonitor.model.enums;

import com.melnychuk.util.jdbc.PersistenceValue;

public enum MonitorDeviceStatus implements PersistenceValue {

    ONLINE("online"),
    OFFLINE("offline");

    private final String persistenceValue;

    MonitorDeviceStatus(String persistenceValue) {
        this.persistenceValue = persistenceValue;
    }

    @Override
    public String getPersistenceValue() {
        return this.persistenceValue;
    }

}
