package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.TGUserDeviceDTO;
import com.melnychuk.blackoutmonitor.factory.mapper.TGUserDeviceMapper;
import com.melnychuk.blackoutmonitor.model.TGUserDevice;
import com.melnychuk.util.jdbc.rs.RSGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TGUserDeviceFactory extends BaseEntityFactory<TGUserDevice, TGUserDeviceDTO> {

    @Getter private final TGUserDeviceMapper mapper;

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
