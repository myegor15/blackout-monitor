package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.DeviceEventDAO;
import com.melnychuk.blackoutmonitor.dto.DeviceEventDTO;
import com.melnychuk.blackoutmonitor.mapper.DeviceEventMapper;
import com.melnychuk.blackoutmonitor.model.DeviceEvent;
import com.melnychuk.blackoutmonitor.service.DeviceEventService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceEventServiceImpl extends BaseServiceImpl<DeviceEvent, DeviceEventDTO> implements DeviceEventService {

    @Getter private final DeviceEventDAO dao;
    @Getter private final DeviceEventMapper mapper;

}
