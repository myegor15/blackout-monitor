package xyz.melnychuk.blackoutmonitor.mapper;

import xyz.melnychuk.blackoutmonitor.dto.TGChatDTO;
import xyz.melnychuk.blackoutmonitor.model.TGChat;
import xyz.melnychuk.spring.jdbc.rs.RSGetter;
import org.mapstruct.Mapper;

@Mapper
public abstract class TGChatMapper implements EntityMapper<TGChat, TGChatDTO> {

    @Override
    public TGChat mapRow(RSGetter rsGetter) {
        return new TGChat(
                rsGetter.getLong("id"),
                rsGetter.getLong("ref_if"),
                rsGetter.getString("ref_name"),
                rsGetter.getLong("tg_user_id"),
                rsGetter.getInstant("create_date")
        );
    }
}
