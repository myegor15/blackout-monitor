package xyz.melnychuk.blackoutmonitor.dao;

import xyz.melnychuk.blackoutmonitor.exception.AppDAOException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BaseDAO<M> {
    M add(M device) throws AppDAOException;
    void update(M device) throws AppDAOException;
    void delete(Long id) throws AppDAOException;
    M getById(Long id) throws AppDAOException;
    List<M> getList() throws AppDAOException;
    Map<Long, M> getMapByIds(Collection<Long> ids) throws AppDAOException;
}
