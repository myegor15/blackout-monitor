package com.melnychuk.blackoutmonitor.factory.mapper;

import com.melnychuk.blackoutmonitor.dto.DeviceDTO;
import com.melnychuk.blackoutmonitor.model.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper extends EntityMapper<Device, DeviceDTO> {
}
