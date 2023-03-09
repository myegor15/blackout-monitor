package xyz.melnychuk.blackoutmonitor.mapper;

import xyz.melnychuk.blackoutmonitor.dto.DeviceEventDTO;
import xyz.melnychuk.blackoutmonitor.model.DeviceEvent;
import xyz.melnychuk.spring.jdbc.rs.RSGetter;
import org.mapstruct.Mapper;

@Mapper
public abstract class DeviceEventMapper implements EntityMapper<DeviceEvent, DeviceEventDTO> {

    @Override
    public DeviceEvent mapRow(RSGetter rsGetter) {
        return new DeviceEvent();
    }
}
