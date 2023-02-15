package com.melnychuk.blackoutmonitor.factory;

import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface EntityFactory<VO, DTO> extends RowMapper<VO> {

    VO createVO(DTO dto);
    DTO createDTO(VO vo);

    default List<DTO> createDTOList(List<VO> voList) {
        return Optional.ofNullable(voList).stream()
                .flatMap(Collection::stream)
                .map(this::createDTO)
                .collect(Collectors.toList());
    }

    default List<VO> createVOList(List<DTO> dtoList) {
        return Optional.ofNullable(dtoList).stream()
                .flatMap(Collection::stream)
                .map(this::createVO)
                .collect(Collectors.toList());
    }
}
