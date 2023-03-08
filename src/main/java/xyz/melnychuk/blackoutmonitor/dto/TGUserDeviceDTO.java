package xyz.melnychuk.blackoutmonitor.dto;

import xyz.melnychuk.blackoutmonitor.model.TGUserDevice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TGUserDeviceDTO extends TGUserDevice {

    public TGUserDeviceDTO(Long id, Long tgUserId, Long deviceId, String name, Instant createDate) {
        super(id, tgUserId, deviceId, name, createDate);
    }
}
