package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.TGChatDAO;
import com.melnychuk.blackoutmonitor.factory.TGChatFactory;
import com.melnychuk.blackoutmonitor.model.TGChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGChatDAO extends PGBaseDAO<TGChat> implements TGChatDAO {

    @Autowired
    public PGTGChatDAO(JdbcTemplate jdbcTemplate, TGChatFactory factory) {
        super(jdbcTemplate, factory);
    }
}
