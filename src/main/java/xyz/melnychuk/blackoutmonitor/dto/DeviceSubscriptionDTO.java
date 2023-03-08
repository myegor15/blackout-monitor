package xyz.melnychuk.blackoutmonitor.dto;

import xyz.melnychuk.blackoutmonitor.model.DeviceSubscription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeviceSubscriptionDTO extends DeviceSubscription {

    public DeviceSubscriptionDTO(Long id, Long deviceId, Long tgChatId, Instant createDate) {
        super(id, deviceId, tgChatId, createDate);
    }
}
