package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.DeviceSubscriptionDAO;
import com.melnychuk.blackoutmonitor.dto.DeviceSubscriptionDTO;
import com.melnychuk.blackoutmonitor.factory.DeviceSubscriptionFactory;
import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import com.melnychuk.blackoutmonitor.service.DeviceSubscriptionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceSubscriptionServiceImpl extends BaseServiceImpl<DeviceSubscription, DeviceSubscriptionDTO> implements DeviceSubscriptionService {

    @Getter private final DeviceSubscriptionDAO dao;
    @Getter private final DeviceSubscriptionFactory factory;

    @Override
    @Transactional(readOnly = true)
    public Set<Long> getTGChatIdSetByDeviceId(Long deviceId) {
        return null;
    }

}
