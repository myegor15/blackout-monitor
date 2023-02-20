package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeviceSubscriptionDTO extends DeviceSubscription {
}
