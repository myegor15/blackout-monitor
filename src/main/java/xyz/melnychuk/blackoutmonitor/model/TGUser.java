package xyz.melnychuk.blackoutmonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGUser {
    private Long id;
    private Long refId;

    // TODO: some fields

    private Instant createDate;
}
