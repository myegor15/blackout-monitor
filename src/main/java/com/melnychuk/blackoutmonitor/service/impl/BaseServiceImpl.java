package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.BaseDAO;
import com.melnychuk.blackoutmonitor.exception.AppServiceException;
import com.melnychuk.blackoutmonitor.mapper.EntityMapper;
import com.melnychuk.blackoutmonitor.service.BaseService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor
public abstract class BaseServiceImpl<M, DTO> implements BaseService<DTO> {

    @Override
    @Transactional
    public DTO add(DTO dto) throws AppServiceException {
        try {
            M m = this.getMapper().toModel(dto);
            m = this.getDao().add(m);
            this.getMapper().updateDTO(m, dto);
            return dto;
        } catch (Exception e) {
            log.error("Exception in add()", e);
            throw new AppServiceException(e);
        }
    }

    @Override
    @Transactional
    public List<DTO> add(List<DTO> dtoList) throws AppServiceException {
        dtoList.forEach(this::add);
        return dtoList;
    }

    @Override
    @Transactional
    public void update(DTO dto) throws AppServiceException {
        try {
            M m = this.getMapper().toModel(dto);
            this.getDao().update(m);
        } catch (Exception e) {
            log.error("Exception in update()", e);
            throw new AppServiceException(e);
        }
    }

    @Override
    @Transactional
    public void update(List<DTO> dto) throws AppServiceException {
        dto.forEach(this::update);
    }

    @Override
    @Transactional
    public void delete(Long id) throws AppServiceException {
        try {
            this.getDao().getById(id);
        } catch (Exception e) {
            log.error("Exception in delete()", e);
            throw new AppServiceException(e);
        }
    }

    @Override
    public void delete(Collection<Long> ids) throws AppServiceException {
        if (CollectionUtils.isEmpty(ids)) return;
        ids.forEach(this::delete);
    }

    @Override
    @Transactional(readOnly = true)
    public DTO getById(Long id) throws AppServiceException {
        try {
            M m = this.getDao().getById(id);
            return this.getMapper().toDTO(m);
        } catch (Exception e) {
            log.error("Exception in getById()", e);
            throw new AppServiceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> getList() throws AppServiceException {
        try {
            List<M> mList = this.getDao().getList();
            return this.getMapper().toDTOList(mList);
        } catch (Exception e) {
            log.error("Exception in getList()", e);
            throw new AppServiceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Long, DTO> getMapByIds(Collection<Long> ids) throws AppServiceException {
        if (CollectionUtils.isEmpty(ids)) return Collections.emptyMap();
        try {
            Map<Long, M> map = this.getDao().getMapByIds(ids);
            return map.entrySet()
                    .stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> this.getMapper().toDTO(e.getValue())
                    ));
        } catch (Exception e) {
            log.error("Exception in getMapByIds()", e);
            throw new AppServiceException(e);
        }
    }
    
    protected abstract BaseDAO<M> getDao();
    protected abstract EntityMapper<M, DTO> getMapper();
}
