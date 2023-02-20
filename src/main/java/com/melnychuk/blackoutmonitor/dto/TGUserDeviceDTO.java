package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.TGUserDevice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TGUserDeviceDTO extends TGUserDevice {
}
