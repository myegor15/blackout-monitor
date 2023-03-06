package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.DeviceDAO;
import com.melnychuk.blackoutmonitor.dto.DeviceDTO;
import com.melnychuk.blackoutmonitor.exception.AppServiceException;
import com.melnychuk.blackoutmonitor.mapper.DeviceMapper;
import com.melnychuk.blackoutmonitor.model.Device;
import com.melnychuk.blackoutmonitor.service.DeviceService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceServiceImpl extends BaseServiceImpl<Device, DeviceDTO> implements DeviceService {

    @Getter private final DeviceDAO dao;
    @Getter private final DeviceMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public DeviceDTO getBySerialNumber(String serialNumber) {
        try {
            Device md = dao.getBySerialNumber(serialNumber);
            return mapper.toDTO(md);
        } catch (Exception e) {
            log.error("Exception in getBySerialNumber()", e);
            throw new AppServiceException(e);
        }
    }

}
