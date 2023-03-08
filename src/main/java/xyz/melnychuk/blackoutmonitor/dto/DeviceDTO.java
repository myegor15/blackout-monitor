package xyz.melnychuk.blackoutmonitor.dto;

import xyz.melnychuk.blackoutmonitor.model.Device;
import xyz.melnychuk.blackoutmonitor.model.enums.DeviceStatus;
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
