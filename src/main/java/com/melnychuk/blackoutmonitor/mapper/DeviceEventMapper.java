package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.blackoutmonitor.dto.DeviceEventDTO;
import com.melnychuk.blackoutmonitor.model.DeviceEvent;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.mapstruct.Mapper;

@Mapper
public abstract class DeviceEventMapper implements EntityMapper<DeviceEvent, DeviceEventDTO> {

    @Override
    public DeviceEvent mapRow(RSGetter rsGetter) {
        return new DeviceEvent();
    }
}
