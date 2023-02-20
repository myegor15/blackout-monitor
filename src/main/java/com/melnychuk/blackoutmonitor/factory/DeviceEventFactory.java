package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.DeviceEventDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.DeviceEventMapper;
import com.melnychuk.blackoutmonitor.model.DeviceEvent;
import com.melnychuk.util.jdbc.rs.RSGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeviceEventFactory extends BaseEntityFactory<DeviceEvent, DeviceEventDTO> {

    @Getter private final DeviceEventMapper mapper;

    @Override
    public DeviceEvent mapRow(RSGetter rsGetter) {
        return new DeviceEvent();
    }
}
