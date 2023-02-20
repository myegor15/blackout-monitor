package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.dto.TGUserDeviceDTO;
import com.melnychuk.blackoutmonitor.model.TGUserDevice;
import com.melnychuk.util.jdbc.rs.RSGetter;
import org.springframework.stereotype.Component;

@Component
public class TGUserDeviceFactory implements EntityFactory<TGUserDevice, TGUserDeviceDTO> {
    @Override
    public TGUserDevice createVO(TGUserDeviceDTO tgUserDeviceDTO) {
        return null;
    }

    @Override
    public TGUserDeviceDTO createDTO(TGUserDevice tgUserDevice) {
        return null;
    }

    @Override
    public TGUserDevice mapRow(RSGetter rsGetter) {
        return null;
    }
}
