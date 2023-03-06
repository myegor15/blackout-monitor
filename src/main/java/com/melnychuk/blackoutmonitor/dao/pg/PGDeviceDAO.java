package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.DeviceDAO;
import com.melnychuk.blackoutmonitor.mapper.DeviceMapper;
import com.melnychuk.blackoutmonitor.model.Device;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGDeviceDAO extends PGBaseDAO<Device> implements DeviceDAO {

    @Autowired
    public PGDeviceDAO(JdbcTemplateWrapper jdbcTemplateWrapper, DeviceMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }

    @Override
    public Device getBySerialNumber(String serialNumber) {
        throw getNotImplementedException();
    }
}
