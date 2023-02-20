package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.TGUserDeviceDAO;
import com.melnychuk.blackoutmonitor.factory.TGUserDeviceFactory;
import com.melnychuk.blackoutmonitor.model.TGUserDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGUserDeviceDAO extends PGBaseDAO<TGUserDevice> implements TGUserDeviceDAO {

    @Autowired
    public PGTGUserDeviceDAO(JdbcTemplate jdbcTemplate, TGUserDeviceFactory factory) {
        super(jdbcTemplate, factory);
    }
}
