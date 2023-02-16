package com.melnychuk.blackoutmonitor.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BaseDAO<M> {
    M add(M device);
    void update(M device);
    void delete(Long id);
    M getById(Long id);
    List<M> getList();
    Map<Long, M> getMapByIds(Collection<Long> ids);
}