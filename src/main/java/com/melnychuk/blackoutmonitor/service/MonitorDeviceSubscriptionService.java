package com.melnychuk.blackoutmonitor.service;

import java.util.Set;

public interface MonitorDeviceSubscriptionService {
    Set<Long> getTGChatIdSetByDeviceId(Long deviceId);
}
