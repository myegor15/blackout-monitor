package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.DeviceSubscriptionDAO;
import com.melnychuk.blackoutmonitor.mapper.DeviceSubscriptionMapper;
import com.melnychuk.blackoutmonitor.model.DeviceSubscription;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class PGDeviceSubscriptionDAO extends PGBaseDAO<DeviceSubscription> implements DeviceSubscriptionDAO {

    @Autowired
    public PGDeviceSubscriptionDAO(JdbcTemplateWrapper jdbcTemplateWrapper, DeviceSubscriptionMapper factory) {
        super(jdbcTemplateWrapper, factory);
    }

    @Override
    public Set<Long> getTGChatIdsByDeviceId(Long deviceId) {
        return jdbcTemplateWrapper.selectSet(
                "SELECT tg_chat_id FROM device_subscription WHERE device_id = ?",
                psSetter -> psSetter.setLong(deviceId),
                rsGetter -> rsGetter.getLong("tg_chat_id")
        );
    }
}
