package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.Device;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeviceDTO extends Device {
}
