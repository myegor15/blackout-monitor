package xyz.melnychuk.blackoutmonitor.service.impl;

import xyz.melnychuk.blackoutmonitor.dao.TGUserDAO;
import xyz.melnychuk.blackoutmonitor.dto.TGUserDTO;
import xyz.melnychuk.blackoutmonitor.mapper.TGUserMapper;
import xyz.melnychuk.blackoutmonitor.model.TGUser;
import xyz.melnychuk.blackoutmonitor.service.TGUserService;
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
