package com.melnychuk.blackoutmonitor.model.enums;

import com.melnychuk.util.jdbc.PersistentValue;

public enum DeviceStatus implements PersistentValue {

    ONLINE("online"),
    OFFLINE("offline");

    private final String persistenceValue;

    DeviceStatus(String persistenceValue) {
        this.persistenceValue = persistenceValue;
    }

    @Override
    public String getPersistenceValue() {
        return this.persistenceValue;
    }

}
