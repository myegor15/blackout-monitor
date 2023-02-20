package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.DeviceSubscriptionDTO;
import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.springframework.stereotype.Component;

@Component
public class DeviceSubscriptionFactory implements EntityFactory<DeviceSubscription, DeviceSubscriptionDTO> {

    @Override
    public DeviceSubscription createVO(DeviceSubscriptionDTO deviceSubscriptionDTO) {
        return null;
    }

    @Override
    public DeviceSubscriptionDTO createDTO(DeviceSubscription deviceSubscription) {
        return null;
    }

    @Override
    public DeviceSubscription mapRow(RSGetter rsGetter) {
        return null;
    }
}
