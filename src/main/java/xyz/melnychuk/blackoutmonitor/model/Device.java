package xyz.melnychuk.blackoutmonitor.model;

import xyz.melnychuk.blackoutmonitor.model.enums.DeviceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private Long id;
    private String serialNumber;
    private String firmwareVersion;
    private DeviceStatus status;
    private Instant createDate;
}
