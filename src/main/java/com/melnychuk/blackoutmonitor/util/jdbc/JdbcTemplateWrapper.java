package com.melnychuk.blackoutmonitor.util.jdbc;

import com.melnychuk.blackoutmonitor.exception.AppDAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

public class JdbcTemplateWrapper {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateWrapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String sql) {
        this.insert(sql, (PSSetterConsumer) null);
    }

    public void insert(String sql, PSSetterConsumer psSetterConsumer) {
        try {
            this.jdbcTemplate.update(sql, psSetterConsumer);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> T insert(String sql, RowMapper<T> mapper) {
        return this.insert(sql, null, mapper);
    }

    public <T> T insert(String sql, PSSetterConsumer psSetterConsumer, RowMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new ObjectRSExtractor<>(mapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public void update(String sql) {
        this.update(sql, null);
    }

    public void update(String sql, PSSetterConsumer psSetterConsumer) {
        try {
            this.jdbcTemplate.update(sql, psSetterConsumer);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public void delete(String sql) {
        this.delete(sql, null);
    }

    public void delete(String sql, PSSetterConsumer psSetterConsumer) {
        try {
            this.jdbcTemplate.update(sql, psSetterConsumer);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> T selectOne(String sql, RowMapper<T> mapper) {
        return this.selectOne(sql, null, mapper);
    }

    public <T> T selectOne(String sql, PSSetterConsumer psSetterConsumer, RowMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new ObjectRSExtractor<>(mapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> List<T> selectList(String sql, RowMapper<T> mapper) {
        return this.selectList(sql, null, mapper);
    }

    public <T> List<T> selectList(String sql, PSSetterConsumer psSetterConsumer, RowMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, mapper);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <K, T> Map<K, T> selectMap(String sql, RowMapper<K> keyMapper, RowMapper<T> valueMapper) {
        return this.selectMap(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, T> selectMap(String sql, PSSetterConsumer psSetterConsumer, RowMapper<K> keyMapper, RowMapper<T> valueMapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new MapRSExtractor<>(keyMapper, valueMapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

}
