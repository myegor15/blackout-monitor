package xyz.melnychuk.blackoutmonitor.mapper;

import xyz.melnychuk.blackoutmonitor.dto.TGUserDTO;
import xyz.melnychuk.blackoutmonitor.model.TGUser;
import xyz.melnychuk.spring.util.jdbc.rs.RSGetter;
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
