package xyz.melnychuk.blackoutmonitor.service.impl;

import xyz.melnychuk.blackoutmonitor.dao.DeviceSubscriptionDAO;
import xyz.melnychuk.blackoutmonitor.dto.DeviceSubscriptionDTO;
import xyz.melnychuk.blackoutmonitor.exception.AppServiceException;
import xyz.melnychuk.blackoutmonitor.mapper.DeviceSubscriptionMapper;
import xyz.melnychuk.blackoutmonitor.model.DeviceSubscription;
import xyz.melnychuk.blackoutmonitor.service.DeviceSubscriptionService;
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
    @Getter private final DeviceSubscriptionMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Set<Long> getTGChatIdsByDeviceId(Long deviceId) {
        try {
            return dao.getTGChatIdsByDeviceId(deviceId);
        } catch (Exception e) {
            log.error("Exception in getTGChatIdsByDeviceId()", e);
            throw new AppServiceException(e);
        }
    }

}
