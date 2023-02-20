package com.melnychuk.blackoutmonitor.factory.mapper;

import com.melnychuk.blackoutmonitor.dto.DeviceEventDTO;
import com.melnychuk.blackoutmonitor.model.DeviceEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceEventMapper extends EntityMapper<DeviceEvent, DeviceEventDTO> {
}
