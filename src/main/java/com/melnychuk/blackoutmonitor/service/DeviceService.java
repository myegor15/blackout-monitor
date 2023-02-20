package com.melnychuk.blackoutmonitor.service;

import com.melnychuk.blackoutmonitor.dto.DeviceDTO;

public interface DeviceService {
    DeviceDTO getBySerialNumber(String serialNumber);
}
