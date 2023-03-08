package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.util.jdbc.rs.RSMapper;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface EntityMapper<M, DTO> extends RSMapper<M> {

    M toModel(DTO dto);
    DTO toDTO(M model);

    void updateDTO(M model, @MappingTarget DTO dto);

    List<M> toModelList(List<DTO> dtoList);
    List<DTO> toDTOList(List<M> modelList);

}
