package xyz.melnychuk.blackoutmonitor.dao.pg;

import xyz.melnychuk.blackoutmonitor.dao.DeviceDAO;
import xyz.melnychuk.blackoutmonitor.mapper.DeviceMapper;
import xyz.melnychuk.blackoutmonitor.model.Device;
import xyz.melnychuk.spring.jdbc.JdbcTemplateWrapper;
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
