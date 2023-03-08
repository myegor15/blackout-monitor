package xyz.melnychuk.blackoutmonitor.dao.pg;

import xyz.melnychuk.blackoutmonitor.dao.TGUserDAO;
import xyz.melnychuk.blackoutmonitor.mapper.TGUserMapper;
import xyz.melnychuk.blackoutmonitor.model.TGUser;
import xyz.melnychuk.spring.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGUserDAO extends PGBaseDAO<TGUser> implements TGUserDAO {

    @Autowired
    public PGTGUserDAO(JdbcTemplateWrapper jdbcTemplateWrapper, TGUserMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }
}
