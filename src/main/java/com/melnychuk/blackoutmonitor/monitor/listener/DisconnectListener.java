package com.melnychuk.blackoutmonitor.monitor.listener;

import com.melnychuk.blackoutmonitor.monitor.DeviceSession;

public interface DisconnectListener {
    void handle(DeviceSession session);
}
