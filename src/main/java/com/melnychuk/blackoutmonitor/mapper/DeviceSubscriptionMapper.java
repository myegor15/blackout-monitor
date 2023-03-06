package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.blackoutmonitor.dto.DeviceSubscriptionDTO;
import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.mapstruct.Mapper;

@Mapper
public abstract class DeviceSubscriptionMapper implements EntityMapper<DeviceSubscription, DeviceSubscriptionDTO> {

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
