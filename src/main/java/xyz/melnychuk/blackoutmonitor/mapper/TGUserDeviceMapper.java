package xyz.melnychuk.blackoutmonitor.mapper;

import xyz.melnychuk.blackoutmonitor.dto.TGUserDeviceDTO;
import xyz.melnychuk.blackoutmonitor.model.TGUserDevice;
import xyz.melnychuk.spring.util.jdbc.rs.RSGetter;
import org.mapstruct.Mapper;

@Mapper
public abstract class TGUserDeviceMapper implements EntityMapper<TGUserDevice, TGUserDeviceDTO> {

    @Override
    public TGUserDevice mapRow(RSGetter rsGetter) {
        return new TGUserDevice(
                rsGetter.getLong("id"),
                rsGetter.getLong("tg_user_id"),
                rsGetter.getLong("device_id"),
                rsGetter.getString("name"),
                rsGetter.getInstant("create_date")
        );
    }
}
