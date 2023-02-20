package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.DeviceSubscriptionDAO;
import com.melnychuk.blackoutmonitor.factory.DeviceSubscriptionFactory;
import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PGDeviceSubscriptionDAO extends PGBaseDAO<DeviceSubscription> implements DeviceSubscriptionDAO {

    @Autowired
    public PGDeviceSubscriptionDAO(JdbcTemplate jdbcTemplate, DeviceSubscriptionFactory factory) {
        super(jdbcTemplate, factory);
    }
}
