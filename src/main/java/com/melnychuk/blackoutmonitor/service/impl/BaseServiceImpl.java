package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.BaseDAO;
import com.melnychuk.blackoutmonitor.exception.AppServiceException;
import com.melnychuk.blackoutmonitor.factory.EntityFactory;
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
public abstract class BaseServiceImpl<VO, DTO> implements BaseService<DTO> {

    @Override
    @Transactional
    public DTO add(DTO dto) throws AppServiceException {
        try {
            VO vo = this.getFactory().createVO(dto);
            vo = this.getDao().add(vo);
            return this.getFactory().createDTO(vo); //TODO
        } catch (Exception e) {
            log.error("Exception in add()", e);
            throw new AppServiceException(e);
        }
    }

    @Override
    @Transactional
    public List<DTO> add(List<DTO> dtoList) throws AppServiceException {
        return dtoList.stream()
                .map(this::add)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void update(DTO dto) throws AppServiceException {
        try {
            VO vo = this.getFactory().createVO(dto);
            this.getDao().update(vo);
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
            VO vo = this.getDao().getById(id);
            return this.getFactory().createDTO(vo);
        } catch (Exception e) {
            log.error("Exception in getById()", e);
            throw new AppServiceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> getList() throws AppServiceException {
        try {
            List<VO> voList = this.getDao().getList();
            return this.getFactory().createDTOList(voList);
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
            Map<Long, VO> map = this.getDao().getMapByIds(ids);
            return map.entrySet()
                    .stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> this.getFactory().createDTO(e.getValue())
                    ));
        } catch (Exception e) {
            log.error("Exception in getMapByIds()", e);
            throw new AppServiceException(e);
        }
    }
    
    protected abstract BaseDAO<VO> getDao();
    protected abstract EntityFactory<VO, DTO> getFactory();
}
