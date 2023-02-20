package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.DeviceDAO;
import com.melnychuk.blackoutmonitor.factory.DeviceFactory;
import com.melnychuk.blackoutmonitor.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PGDeviceDAO extends PGBaseDAO<Device> implements DeviceDAO {

    @Autowired
    public PGDeviceDAO(JdbcTemplate jdbcTemplate, DeviceFactory factory) {
        super(jdbcTemplate, factory);
    }

    @Override
    public Device getBySerialNumber(String serialNumber) {
        throw getNotImplementedException();
    }
}
