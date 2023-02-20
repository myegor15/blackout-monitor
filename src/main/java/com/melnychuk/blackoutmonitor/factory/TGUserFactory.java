package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.TGUserDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.TGUserMapper;
import com.melnychuk.blackoutmonitor.model.TGUser;
import com.melnychuk.util.jdbc.rs.RSGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TGUserFactory extends BaseEntityFactory<TGUser, TGUserDTO> {

    @Getter private final TGUserMapper mapper;

    @Override
    public TGUser mapRow(RSGetter rsGetter) {
        return new TGUser(
                rsGetter.getLong("id"),
                rsGetter.getLong("ref_id"),
                rsGetter.getInstant("create_date")
        );
    }
}
