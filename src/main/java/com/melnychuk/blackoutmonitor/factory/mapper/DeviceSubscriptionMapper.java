package com.melnychuk.blackoutmonitor.factory.mapper;

import com.melnychuk.blackoutmonitor.dto.DeviceSubscriptionDTO;
import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceSubscriptionMapper extends EntityMapper<DeviceSubscription, DeviceSubscriptionDTO> {
}
