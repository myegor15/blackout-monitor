package com.melnychuk.blackoutmonitor.model;

import com.melnychuk.blackoutmonitor.model.enums.MonitorDeviceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitorDevice {
    private Long id;
    private String serialNumber;
    private String firmwareVersion;
    private MonitorDeviceStatus status;
    private Instant createDate;
}
