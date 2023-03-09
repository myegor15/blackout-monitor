package xyz.melnychuk.blackoutmonitor.dao.pg;

import xyz.melnychuk.blackoutmonitor.dao.TGUserDeviceDAO;
import xyz.melnychuk.blackoutmonitor.mapper.TGUserDeviceMapper;
import xyz.melnychuk.blackoutmonitor.model.TGUserDevice;
import xyz.melnychuk.spring.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGUserDeviceDAO extends PGBaseDAO<TGUserDevice> implements TGUserDeviceDAO {

    @Autowired
    public PGTGUserDeviceDAO(JdbcTemplateWrapper jdbcTemplateWrapper, TGUserDeviceMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }
}
