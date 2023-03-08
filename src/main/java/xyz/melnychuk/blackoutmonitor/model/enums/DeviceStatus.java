package xyz.melnychuk.blackoutmonitor.model.enums;

import xyz.melnychuk.spring.util.jdbc.PersistentValue;

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
