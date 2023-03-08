package xyz.melnychuk.blackoutmonitor.service;

import xyz.melnychuk.blackoutmonitor.dto.DeviceDTO;

public interface DeviceService {
    DeviceDTO getBySerialNumber(String serialNumber);
}
