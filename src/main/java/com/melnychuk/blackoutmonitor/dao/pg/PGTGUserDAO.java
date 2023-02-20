package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.TGUserDAO;
import com.melnychuk.blackoutmonitor.factory.TGUserFactory;
import com.melnychuk.blackoutmonitor.model.TGUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGUserDAO extends PGBaseDAO<TGUser> implements TGUserDAO {

    @Autowired
    public PGTGUserDAO(JdbcTemplate jdbcTemplate, TGUserFactory factory) {
        super(jdbcTemplate, factory);
    }
}
