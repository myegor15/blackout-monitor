package com.melnychuk.blackoutmonitor.service;

import java.util.Set;

public interface TGChatService {
    Set<Long> getRefIdSetByTGChatIdSet(Set<Long> chatIdSet);
}
