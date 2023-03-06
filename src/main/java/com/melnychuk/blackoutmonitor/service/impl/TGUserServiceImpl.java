package com.melnychuk.blackoutmonitor.service.impl;

import com.melnychuk.blackoutmonitor.dao.TGUserDAO;
import com.melnychuk.blackoutmonitor.dto.TGUserDTO;
import com.melnychuk.blackoutmonitor.mapper.TGUserMapper;
import com.melnychuk.blackoutmonitor.model.TGUser;
import com.melnychuk.blackoutmonitor.service.TGUserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class TGUserServiceImpl extends BaseServiceImpl<TGUser, TGUserDTO> implements TGUserService {

    @Getter private final TGUserDAO dao;
    @Getter private final TGUserMapper mapper;
}
