package xyz.melnychuk.blackoutmonitor.dao;

import xyz.melnychuk.blackoutmonitor.model.DeviceSubscription;

import java.util.Set;

public interface DeviceSubscriptionDAO extends BaseDAO<DeviceSubscription> {
    Set<Long> getTGChatIdsByDeviceId(Long deviceId);
}
