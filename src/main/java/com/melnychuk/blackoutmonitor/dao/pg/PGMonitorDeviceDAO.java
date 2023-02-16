package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.factory.MonitorDeviceFactory;
import com.melnychuk.blackoutmonitor.model.MonitorDevice;
import com.melnychuk.blackoutmonitor.dao.MonitorDeviceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PGMonitorDeviceDAO extends PGBaseDAO<MonitorDevice> implements MonitorDeviceDAO {

    @Autowired
    public PGMonitorDeviceDAO(JdbcTemplate jdbcTemplate, MonitorDeviceFactory factory) {
        super(jdbcTemplate, factory);
    }

    @Override
    public Optional<MonitorDevice> getBySerialNumber(String serialNumber) {
        throw getNotImplementedException();
    }
}
