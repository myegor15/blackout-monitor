package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.DeviceEventDAO;
import com.melnychuk.blackoutmonitor.mapper.DeviceEventMapper;
import com.melnychuk.blackoutmonitor.model.DeviceEvent;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGDeviceEventDAO extends PGBaseDAO<DeviceEvent> implements DeviceEventDAO {

    @Autowired
    public PGDeviceEventDAO(JdbcTemplateWrapper jdbcTemplateWrapper, DeviceEventMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }
}
