package com.melnychuk.blackoutmonitor.factory.mapper;

public interface EntityMapper<VO, DTO> {
    VO toVO(DTO dto);
    DTO toDTO (VO vo);
}
