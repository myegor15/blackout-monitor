package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.MonitorDeviceDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.EntityMapper;
import com.melnychuk.blackoutmonitor.model.MonitorDevice;
import com.melnychuk.blackoutmonitor.model.enums.MonitorDeviceStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class MonitorDeviceFactory implements EntityFactory<MonitorDevice, MonitorDeviceDTO> {

    private final EntityMapper mapper;

    @Override
    public MonitorDevice mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MonitorDevice(
                rs.getLong("id"),
                rs.getString("serial_number"),
                rs.getString("firmware_version"),
                MonitorDeviceStatus.valueOf(rs.getString("status")), //TODO
                rs.getDate("create_date").toInstant() //TODO
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
