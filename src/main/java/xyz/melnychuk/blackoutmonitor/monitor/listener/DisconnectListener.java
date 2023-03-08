package xyz.melnychuk.blackoutmonitor.monitor.listener;

import xyz.melnychuk.blackoutmonitor.monitor.DeviceSession;

public interface DisconnectListener {
    void handle(DeviceSession session);
}
