package xyz.melnychuk.blackoutmonitor.service.impl;

import xyz.melnychuk.blackoutmonitor.dao.TGChatDAO;
import xyz.melnychuk.blackoutmonitor.dto.TGChatDTO;
import xyz.melnychuk.blackoutmonitor.exception.AppServiceException;
import xyz.melnychuk.blackoutmonitor.mapper.TGChatMapper;
import xyz.melnychuk.blackoutmonitor.model.TGChat;
import xyz.melnychuk.blackoutmonitor.service.TGChatService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class TGChatServiceImpl extends BaseServiceImpl<TGChat, TGChatDTO> implements TGChatService {

    @Getter private final TGChatDAO dao;
    @Getter private final TGChatMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Set<Long> getRefIdsByIds(Set<Long> chatIdSet) {
        if (CollectionUtils.isEmpty(chatIdSet)) {
            return new HashSet<>();
        }

        try {
            return dao.getRefIdsByIds(chatIdSet);
        } catch (Exception e) {
            log.error("Exception in getRefIdsByIds()", e);
            throw new AppServiceException(e);
        }
    }
}
