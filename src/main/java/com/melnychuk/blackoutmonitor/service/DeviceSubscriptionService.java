package com.melnychuk.blackoutmonitor.service;

import java.util.Set;

public interface DeviceSubscriptionService {
    Set<Long> getTGChatIdSetByDeviceId(Long deviceId);
}
