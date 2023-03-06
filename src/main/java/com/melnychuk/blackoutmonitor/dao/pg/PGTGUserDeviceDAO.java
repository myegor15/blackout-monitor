package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.TGUserDeviceDAO;
import com.melnychuk.blackoutmonitor.mapper.TGUserDeviceMapper;
import com.melnychuk.blackoutmonitor.model.TGUserDevice;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGUserDeviceDAO extends PGBaseDAO<TGUserDevice> implements TGUserDeviceDAO {

    @Autowired
    public PGTGUserDeviceDAO(JdbcTemplateWrapper jdbcTemplateWrapper, TGUserDeviceMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }
}
