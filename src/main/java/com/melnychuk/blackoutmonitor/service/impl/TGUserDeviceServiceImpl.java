package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.pg.PGTGUserDeviceDAO;
import com.melnychuk.blackoutmonitor.dto.TGUserDeviceDTO;
import com.melnychuk.blackoutmonitor.mapper.TGUserDeviceMapper;
import com.melnychuk.blackoutmonitor.model.TGUserDevice;
import com.melnychuk.blackoutmonitor.service.TGUserDeviceService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class TGUserDeviceServiceImpl extends BaseServiceImpl<TGUserDevice, TGUserDeviceDTO> implements TGUserDeviceService {

    @Getter private final PGTGUserDeviceDAO dao;
    @Getter private final TGUserDeviceMapper mapper;
}
