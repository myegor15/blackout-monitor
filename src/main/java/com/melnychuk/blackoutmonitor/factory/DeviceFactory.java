package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.DeviceDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.DeviceMapper;
import com.melnychuk.blackoutmonitor.model.Device;
import com.melnychuk.blackoutmonitor.model.enums.DeviceStatus;
import com.melnychuk.util.jdbc.rs.RSGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeviceFactory extends BaseEntityFactory<Device, DeviceDTO> {

    @Getter private final DeviceMapper mapper;

    @Override
    public Device mapRow(RSGetter rsGetter) {
        return new Device(
                rsGetter.getLong("id"),
                rsGetter.getString("serial_number"),
                rsGetter.getString("firmware_version"),
                rsGetter.getEnum("status", DeviceStatus.values()),
                rsGetter.getInstant("create_date")
        );
    }

}
