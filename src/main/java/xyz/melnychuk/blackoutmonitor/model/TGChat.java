package xyz.melnychuk.blackoutmonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGChat {
    private Long id;
    private Long refId;
    private String refName;
    private Long tgUserId;
    private Instant createDate;
}
