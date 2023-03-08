package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.util.jdbc.rs.RSMapper;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface EntityMapper<M, DTO> extends RSMapper<M> {

    M toVO(DTO dto);
    DTO toDTO(M m);

    void updateDTO(M m, @MappingTarget DTO dto);

    List<DTO> toDTOList(List<M> mList);
    List<M> toVOList(List<DTO> dtoList);

}
