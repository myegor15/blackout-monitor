package com.melnychuk.blackoutmonitor.mapper;

import com.melnychuk.util.jdbc.rs.RSMapper;
import org.mapstruct.IterableMapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

public interface EntityMapper<M, DTO> extends RSMapper<M> {

    M toModel(DTO dto);
    DTO toDTO(M model);

    void updateDTO(M model, @MappingTarget DTO dto);

    @IterableMapping(nullValueMappingStrategy = RETURN_DEFAULT)
    List<M> toModelList(List<DTO> dtoList);

    @IterableMapping(nullValueMappingStrategy = RETURN_DEFAULT)
    List<DTO> toDTOList(List<M> modelList);

}
