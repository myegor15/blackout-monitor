package com.melnychuk.blackoutmonitor.factory.mapper;

import com.melnychuk.blackoutmonitor.dto.TGChatDTO;
import com.melnychuk.blackoutmonitor.model.TGChat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TGChatMapper extends EntityMapper<TGChat, TGChatDTO> {
}
