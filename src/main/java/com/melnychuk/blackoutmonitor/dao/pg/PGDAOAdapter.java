package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.exception.AppDAOException;
import com.melnychuk.blackoutmonitor.dao.BaseDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PGDAOAdapter<M> extends PGBaseDAO implements BaseDAO<M> {

    protected final RowMapper<M> mapper;

    public PGDAOAdapter(JdbcTemplate jdbcTemplate, RowMapper<M> mapper) {
        super(jdbcTemplate);
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public M add(M device) {
        throw getNotImplementedException();
    }

    @Override
    @Transactional
    public void update(M device) {
        throw getNotImplementedException();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        throw getNotImplementedException();
    }

    @Override
    @Transactional(readOnly = true)
    public M getById(Long id) {
        throw getNotImplementedException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<M> getList() {
        throw getNotImplementedException();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Long, M> getMapByIds(Collections ids) {
        throw getNotImplementedException();
    }

    protected AppDAOException getNotImplementedException() {
        return new AppDAOException("Method does not implemented.");
    }
}
