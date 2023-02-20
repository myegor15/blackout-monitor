package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.DeviceEventDTO;
import com.melnychuk.blackoutmonitor.model.DeviceEvent;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.springframework.stereotype.Component;

@Component
public class DeviceEventFactory implements EntityFactory<DeviceEvent, DeviceEventDTO> {

    @Override
    public DeviceEvent createVO(DeviceEventDTO deviceEventDTO) {
        return null;
    }

    @Override
    public DeviceEventDTO createDTO(DeviceEvent deviceEvent) {
        return null;
    }

    @Override
    public DeviceEvent mapRow(RSGetter rsGetter) {
        return null;
    }
}
