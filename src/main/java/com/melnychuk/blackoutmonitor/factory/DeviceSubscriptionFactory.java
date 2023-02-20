package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.DeviceSubscriptionDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.DeviceSubscriptionMapper;
import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import com.melnychuk.util.jdbc.rs.RSGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeviceSubscriptionFactory extends BaseEntityFactory<DeviceSubscription, DeviceSubscriptionDTO> {

    @Getter private final DeviceSubscriptionMapper mapper;

    @Override
    public DeviceSubscription mapRow(RSGetter rsGetter) {
        return new DeviceSubscription(
                rsGetter.getLong("id"),
                rsGetter.getLong("device_id"),
                rsGetter.getLong("tg_chat_id"),
                rsGetter.getInstant("create_date")
        );
    }
}
