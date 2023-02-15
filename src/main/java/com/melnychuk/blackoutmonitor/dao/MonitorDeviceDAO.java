package com.melnychuk.blackoutmonitor.dao;

import com.melnychuk.blackoutmonitor.model.MonitorDevice;

import java.util.Optional;

public interface MonitorDeviceDAO extends BaseDAO<MonitorDevice> {
    Optional<MonitorDevice> getBySerialNumber(String serialNumber);
}
