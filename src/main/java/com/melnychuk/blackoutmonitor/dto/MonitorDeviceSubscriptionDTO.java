package com.melnychuk.blackoutmonitor.dto;

import com.melnychuk.blackoutmonitor.model.MonitorDeviceSubscription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MonitorDeviceSubscriptionDTO extends MonitorDeviceSubscription {
}
