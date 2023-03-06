package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.blackoutmonitor.dto.DeviceDTO;
import com.melnychuk.blackoutmonitor.model.Device;
import com.melnychuk.blackoutmonitor.model.enums.DeviceStatus;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.mapstruct.Mapper;

@Mapper
public abstract class DeviceMapper implements EntityMapper<Device, DeviceDTO> {

    @Override
    public Device mapRow(RSGetter rsGetter) {
        return new Device(
                rsGetter.getLong("id"),
                rsGetter.getString("serial_number"),
                rsGetter.getString("firmware_version"),
                rsGetter.getEnumValue("status", DeviceStatus.values()),
                rsGetter.getInstant("create_date")
        );
    }

}
