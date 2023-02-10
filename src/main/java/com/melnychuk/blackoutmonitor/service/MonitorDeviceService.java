package com.melnychuk.blackoutmonitor.service;

import com.melnychuk.blackoutmonitor.model.MonitorDevice;

import java.util.Optional;

public interface MonitorDeviceService {
    Optional<MonitorDevice> getBySerialNumber(String serialNumber);
}
