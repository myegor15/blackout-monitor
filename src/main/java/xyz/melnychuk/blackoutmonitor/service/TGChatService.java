package xyz.melnychuk.blackoutmonitor.service;

import java.util.Set;

public interface TGChatService {
    Set<Long> getRefIdsByIds(Set<Long> chatIdSet);
}
