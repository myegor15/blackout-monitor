package xyz.melnychuk.blackoutmonitor.monitor.listener;

import xyz.melnychuk.blackoutmonitor.monitor.DeviceSession;

public interface ConnectListener {
    void handle(DeviceSession deviceSession);
}
