package com.melnychuk.blackoutmonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGUserMonitorDevice {
    private Long id;
    private Long tgUserId;
    private Long monitorAgentId;
    private String name;
    private Instant createDate;
}
