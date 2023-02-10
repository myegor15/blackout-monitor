package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.TGUserMonitorDevice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TGUserMonitorDeviceDTO extends TGUserMonitorDevice {
}
