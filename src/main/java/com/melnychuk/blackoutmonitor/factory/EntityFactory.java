package com.melnychuk.blackoutmonitor.factory;

import com.melnychuk.util.jdbc.rs.RSRowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface EntityFactory<VO, DTO> extends RSRowMapper<VO> {

    VO createVO(DTO dto);
    DTO createDTO(VO vo);

    default List<DTO> createDTOList(List<VO> voList) {
        return Optional
                .ofNullable(voList)
                .orElseGet(ArrayList::new)
                .stream()
                .map(this::createDTO)
                .collect(Collectors.toList());
    }

    default List<VO> createVOList(List<DTO> dtoList) {
        return Optional
                .ofNullable(dtoList)
                .orElseGet(ArrayList::new)
                .stream()
                .map(this::createVO)
                .collect(Collectors.toList());
    }
}
