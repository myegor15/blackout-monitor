package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.blackoutmonitor.dto.TGUserDTO;
import com.melnychuk.blackoutmonitor.model.TGUser;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.mapstruct.Mapper;

@Mapper
public abstract class TGUserMapper implements EntityMapper<TGUser, TGUserDTO> {

    @Override
    public TGUser mapRow(RSGetter rsGetter) {
        return new TGUser(
                rsGetter.getLong("id"),
                rsGetter.getLong("ref_id"),
                rsGetter.getInstant("create_date")
        );
    }
}
