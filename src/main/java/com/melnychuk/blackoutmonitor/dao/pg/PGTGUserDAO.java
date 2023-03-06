package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.TGUserDAO;
import com.melnychuk.blackoutmonitor.mapper.TGUserMapper;
import com.melnychuk.blackoutmonitor.model.TGUser;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGUserDAO extends PGBaseDAO<TGUser> implements TGUserDAO {

    @Autowired
    public PGTGUserDAO(JdbcTemplateWrapper jdbcTemplateWrapper, TGUserMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }
}
