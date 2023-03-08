package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.TGChatDAO;
import com.melnychuk.blackoutmonitor.mapper.TGChatMapper;
import com.melnychuk.blackoutmonitor.model.TGChat;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PGTGChatDAO extends PGBaseDAO<TGChat> implements TGChatDAO {

    @Autowired
    public PGTGChatDAO(JdbcTemplateWrapper jdbcTemplateWrapper, TGChatMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }

    @Override
    public Set<Long> getRefIdsByIds(Set<Long> chatIdSet) {
        String collect = Stream.generate(() -> "?").limit(chatIdSet.size()).collect(Collectors.joining("?"));
        return jdbcTemplateWrapper.selectSet(
                "SELECT ref_id FROM tg_chat WHERE tg_chat_id IN (" + collect + ")",
                psSetter -> chatIdSet.forEach(psSetter::setLong),
                rsGetter -> rsGetter.getLong("ref_id")
        );
    }
}
