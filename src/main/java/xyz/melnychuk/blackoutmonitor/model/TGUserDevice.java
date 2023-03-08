package xyz.melnychuk.blackoutmonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGUserDevice {
    private Long id;
    private Long tgUserId;
    private Long deviceId;
    private String name;
    private Instant createDate;
}
