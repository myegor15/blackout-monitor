package com.melnychuk.blackoutmonitor.factory.mapper;

import com.melnychuk.blackoutmonitor.dto.TGUserDTO;
import com.melnychuk.blackoutmonitor.model.TGUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TGUserMapper extends EntityMapper<TGUser, TGUserDTO> {
}
