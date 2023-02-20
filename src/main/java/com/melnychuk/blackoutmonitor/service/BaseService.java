package com.melnychuk.blackoutmonitor.service;

import com.melnychuk.blackoutmonitor.exception.AppServiceException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BaseService<DTO> {
    DTO add(DTO entity) throws AppServiceException;
    List<DTO> add(List<DTO> entityList) throws AppServiceException;
    void update(DTO entity) throws AppServiceException;
    void update(List<DTO> entityList) throws AppServiceException;
    void delete(Long id) throws AppServiceException;
    void delete(Collection<Long> ids) throws AppServiceException;
    DTO getById(Long id) throws AppServiceException;
    List<DTO> getList() throws AppServiceException;
    Map<Long, DTO> getMapByIds(Collection<Long> ids) throws AppServiceException;
}
