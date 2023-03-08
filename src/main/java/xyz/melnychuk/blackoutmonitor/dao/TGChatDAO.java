package xyz.melnychuk.blackoutmonitor.dao;

import xyz.melnychuk.blackoutmonitor.model.TGChat;

import java.util.Set;

public interface TGChatDAO extends BaseDAO<TGChat> {
    Set<Long> getRefIdsByIds(Set<Long> chatIdSet);
}
