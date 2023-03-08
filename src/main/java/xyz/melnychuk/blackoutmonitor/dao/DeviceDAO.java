package xyz.melnychuk.blackoutmonitor.dao;

import xyz.melnychuk.blackoutmonitor.exception.AppDAOException;
import xyz.melnychuk.blackoutmonitor.model.Device;

public interface DeviceDAO extends BaseDAO<Device> {
    Device getBySerialNumber(String serialNumber) throws AppDAOException;
}
