package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.TGUserDTO;
import com.melnychuk.blackoutmonitor.model.TGUser;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.springframework.stereotype.Component;

@Component
public class TGUserFactory implements EntityFactory<TGUser, TGUserDTO> {
    @Override
    public TGUser createVO(TGUserDTO tgUserDTO) {
        return null;
    }

    @Override
    public TGUserDTO createDTO(TGUser tgUser) {
        return null;
    }

    @Override
    public TGUser mapRow(RSGetter rsGetter) {
        return null;
    }
}
