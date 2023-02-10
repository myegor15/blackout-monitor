package com.melnychuk.blackoutmonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitorDeviceSubscription {
    private Long id;
    private Long monitorDeviceId;
    private Long tgChatId;
    private Instant createDate;
}
