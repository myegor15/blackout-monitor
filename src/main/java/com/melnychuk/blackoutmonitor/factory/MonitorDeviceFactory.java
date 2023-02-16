package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.MonitorDeviceDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.EntityMapper;
import com.melnychuk.blackoutmonitor.model.MonitorDevice;
import com.melnychuk.blackoutmonitor.model.enums.MonitorDeviceStatus;
import com.melnychuk.util.jdbc.rs.RSGetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MonitorDeviceFactory implements EntityFactory<MonitorDevice, MonitorDeviceDTO> {

    private final EntityMapper mapper;

    @Override
    public MonitorDevice mapRow(RSGetter rsGetter) {
        return new MonitorDevice(
                rsGetter.getLong("id"),
                rsGetter.getString("serial_number"),
                rsGetter.getString("firmware_version"),
                rsGetter.getEnum("status", MonitorDeviceStatus.values()),
                rsGetter.getInstant("create_date")
        );
    }

    @Override
    public MonitorDevice createVO(MonitorDeviceDTO deviceDTO) {
        return null;
    }

    @Override
    public MonitorDeviceDTO createDTO(MonitorDevice device) {
        return null;
    }
}
