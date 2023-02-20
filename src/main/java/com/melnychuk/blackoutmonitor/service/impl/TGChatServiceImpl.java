package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.TGChatDAO;
import com.melnychuk.blackoutmonitor.dto.TGChatDTO;
import com.melnychuk.blackoutmonitor.factory.TGChatFactory;
import com.melnychuk.blackoutmonitor.model.TGChat;
import com.melnychuk.blackoutmonitor.service.TGChatService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class TGChatServiceImpl extends BaseServiceImpl<TGChat, TGChatDTO> implements TGChatService {

    @Getter private final TGChatDAO dao;
    @Getter private final TGChatFactory factory;

    @Override
    @Transactional(readOnly = true)
    public Set<Long> getRefIdSetByTGChatIdSet(Set<Long> chatIdSet) {
        return null;
    }
}
