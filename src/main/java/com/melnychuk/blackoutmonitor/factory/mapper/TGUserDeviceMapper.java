package com.melnychuk.blackoutmonitor.factory.mapper;

import com.melnychuk.blackoutmonitor.dto.TGUserDeviceDTO;
import com.melnychuk.blackoutmonitor.model.TGUserDevice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TGUserDeviceMapper extends EntityMapper<TGUserDevice, TGUserDeviceDTO> {
}
