package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.Device;
import com.melnychuk.blackoutmonitor.model.enums.DeviceStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeviceDTO extends Device {

    public DeviceDTO(Long id, String serialNumber, String firmwareVersion, DeviceStatus status, Instant createDate) {
        super(id, serialNumber, firmwareVersion, status, createDate);
    }
}
