package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.blackoutmonitor.dto.TGChatDTO;
import com.melnychuk.blackoutmonitor.model.TGChat;
import com.melnychuk.util.jdbc.rs.RSGetter;
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
