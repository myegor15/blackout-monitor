package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.TGChatDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.TGChatMapper;
import com.melnychuk.blackoutmonitor.model.TGChat;
import com.melnychuk.util.jdbc.rs.RSGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TGChatFactory extends BaseEntityFactory<TGChat, TGChatDTO> {

    @Getter private final TGChatMapper mapper;

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
