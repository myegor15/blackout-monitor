package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.util.jdbc.rs.RSMapper;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface EntityMapper<VO, DTO> extends RSMapper<VO> {

    VO toVO(DTO dto);
    DTO toDTO(VO vo);

    void updateDTO(VO vo, @MappingTarget DTO dto);

    List<DTO> toDTOList(List<VO> voList);
    List<VO> toVOList(List<DTO> dtoList);

}
