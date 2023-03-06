package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.TGChatDAO;
import com.melnychuk.blackoutmonitor.mapper.TGChatMapper;
import com.melnychuk.blackoutmonitor.model.TGChat;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PGTGChatDAO extends PGBaseDAO<TGChat> implements TGChatDAO {

    @Autowired
    public PGTGChatDAO(JdbcTemplateWrapper jdbcTemplateWrapper, TGChatMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }
}
