package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.dao.BaseDAO;
import com.melnychuk.blackoutmonitor.exception.AppDAOException;
import com.melnychuk.util.jdbc.JdbcTemplateWrapper;
import com.melnychuk.util.jdbc.rs.RSRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PGBaseDAO<M> implements BaseDAO<M> {

    protected final JdbcTemplateWrapper jdbcTemplateWrapper;
    protected final RSRowMapper<M> mapper;

    public PGBaseDAO(JdbcTemplate jdbcTemplate, RSRowMapper<M> mapper) {
        this.jdbcTemplateWrapper = new JdbcTemplateWrapper(jdbcTemplate);
        this.mapper = mapper;
    }

    @Override
    public M add(M device) {
        throw getNotImplementedException();
    }

    @Override
    public void update(M device) {
        throw getNotImplementedException();
    }

    @Override
    public void delete(Long id) {
        throw getNotImplementedException();
    }

    @Override
    public M getById(Long id) {
        throw getNotImplementedException();
    }

    @Override
    public List<M> getList() {
        throw getNotImplementedException();
    }

    @Override
    public Map<Long, M> getMapByIds(Collection<Long> ids) {
        throw getNotImplementedException();
    }

    protected AppDAOException getNotImplementedException() {
        return new AppDAOException("Method does not implemented.");
    }
}
