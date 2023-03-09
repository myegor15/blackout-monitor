package xyz.melnychuk.blackoutmonitor.dao.pg;

import xyz.melnychuk.blackoutmonitor.dao.DeviceEventDAO;
import xyz.melnychuk.blackoutmonitor.mapper.DeviceEventMapper;
import xyz.melnychuk.blackoutmonitor.model.DeviceEvent;
import xyz.melnychuk.spring.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGDeviceEventDAO extends PGBaseDAO<DeviceEvent> implements DeviceEventDAO {

    @Autowired
    public PGDeviceEventDAO(JdbcTemplateWrapper jdbcTemplateWrapper, DeviceEventMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }
}
