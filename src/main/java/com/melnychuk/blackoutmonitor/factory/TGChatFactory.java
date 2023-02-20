package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.TGChatDTO;
import com.melnychuk.blackoutmonitor.model.TGChat;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.springframework.stereotype.Component;

@Component
public class TGChatFactory implements EntityFactory<TGChat, TGChatDTO> {
    @Override
    public TGChat createVO(TGChatDTO tgChatDTO) {
        return null;
    }

    @Override
    public TGChatDTO createDTO(TGChat tgChat) {
        return null;
    }

    @Override
    public TGChat mapRow(RSGetter rsGetter) {
        return null;
    }
}
