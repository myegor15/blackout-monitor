package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.DeviceEventDAO;
import com.melnychuk.blackoutmonitor.factory.DeviceEventFactory;
import com.melnychuk.blackoutmonitor.model.DeviceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PGDeviceEventDAO extends PGBaseDAO<DeviceEvent> implements DeviceEventDAO {

    @Autowired
    public PGDeviceEventDAO(JdbcTemplate jdbcTemplate, DeviceEventFactory factory) {
        super(jdbcTemplate, factory);
    }
}
