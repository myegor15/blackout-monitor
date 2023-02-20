package com.melnychuk.blackoutmonitor.dao;

import com.melnychuk.blackoutmonitor.exception.AppDAOException;
import com.melnychuk.blackoutmonitor.model.Device;

public interface DeviceDAO extends BaseDAO<Device> {
    Device getBySerialNumber(String serialNumber) throws AppDAOException;
}
