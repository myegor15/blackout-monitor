package xyz.melnychuk.blackoutmonitor.dao.pg;

import xyz.melnychuk.blackoutmonitor.dao.TGChatDAO;
import xyz.melnychuk.blackoutmonitor.mapper.TGChatMapper;
import xyz.melnychuk.blackoutmonitor.model.TGChat;
import xyz.melnychuk.spring.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class PGTGChatDAO extends PGBaseDAO<TGChat> implements TGChatDAO {

    @Autowired
    public PGTGChatDAO(JdbcTemplateWrapper jdbcTemplateWrapper, TGChatMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }

    @Override
    public Set<Long> getRefIdsByIds(Set<Long> chatIdSet) {
        return jdbcTemplateWrapper.selectSet(
                "SELECT ref_id FROM tg_chat WHERE tg_chat_id IN (" + generatePSMarks(chatIdSet.size()) + ")",
                psSetter -> psSetter.setLongCollection(chatIdSet),
                rsGetter -> rsGetter.getLong("ref_id")
        );
    }
}
