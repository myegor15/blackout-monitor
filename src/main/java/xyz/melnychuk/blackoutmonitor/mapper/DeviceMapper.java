package xyz.melnychuk.blackoutmonitor.mapper;

import xyz.melnychuk.blackoutmonitor.dto.DeviceDTO;
import xyz.melnychuk.blackoutmonitor.model.Device;
import xyz.melnychuk.blackoutmonitor.model.enums.DeviceStatus;
import xyz.melnychuk.spring.util.jdbc.rs.RSGetter;
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
