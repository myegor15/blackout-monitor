package com.melnychuk.blackoutmonitor.monitor.listener;

import com.melnychuk.blackoutmonitor.monitor.DeviceSession;

public interface ConnectListener {
    void handle(DeviceSession deviceSession);
}
