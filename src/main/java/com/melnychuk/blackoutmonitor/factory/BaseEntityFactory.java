package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.blackoutmonitor.factory.mapper.EntityMapper;

public abstract class BaseEntityFactory<VO, DTO> implements EntityFactory<VO, DTO> {

    @Override
    public VO createVO(DTO dto) {
        return this.getMapper().toVO(dto);
    }

    @Override
    public DTO createDTO(VO vo) {
        return this.getMapper().toDTO(vo);
    }

    protected abstract EntityMapper<VO, DTO> getMapper();
}
