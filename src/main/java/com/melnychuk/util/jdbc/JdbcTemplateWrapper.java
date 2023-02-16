package com.melnychuk.util.jdbc;

import com.melnychuk.blackoutmonitor.exception.AppDAOException;
import com.melnychuk.util.jdbc.ps.PSSetterConsumer;
import com.melnychuk.util.jdbc.rs.RSRowMapper;
import com.melnychuk.util.jdbc.rs.extractor.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public <T> T insert(String sql, RSRowMapper<T> mapper) {
        return this.insert(sql, null, mapper);
    }

    public <T> T insert(String sql, PSSetterConsumer psSetterConsumer, RSRowMapper<T> mapper) {
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

    public <T> T selectOne(String sql, RSRowMapper<T> mapper) {
        return this.selectOne(sql, null, mapper);
    }

    public <T> T selectOne(String sql, PSSetterConsumer psSetterConsumer, RSRowMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new ObjectRSExtractor<>(mapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> List<T> selectList(String sql, RSRowMapper<T> mapper) {
        return this.selectList(sql, null, mapper);
    }

    public <T> List<T> selectList(String sql, PSSetterConsumer psSetterConsumer, RSRowMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new ListRSExtractor<>(mapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> Set<T> selectSet(String sql, RSRowMapper<T> mapper) {
        return this.selectSet(sql, null, mapper);
    }

    public <T> Set<T> selectSet(String sql, PSSetterConsumer psSetterConsumer, RSRowMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new SetRSExtractor<>(mapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <K, T> Map<K, T> selectMap(String sql, RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        return this.selectMap(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, T> selectMap(String sql, PSSetterConsumer psSetterConsumer, RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new MapRSExtractor<>(keyMapper, valueMapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <K, T> Map<K, List<T>> selectMapOfLists(String sql, RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        return this.selectMapOfLists(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, List<T>> selectMapOfLists(String sql, PSSetterConsumer psSetterConsumer, RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new MapOfListsRSExtractor<>(keyMapper, valueMapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <K, T> Map<K, Set<T>> selectMapOfSets(String sql, RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        return this.selectMapOfSets(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, Set<T>> selectMapOfSets(String sql, PSSetterConsumer psSetterConsumer, RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterConsumer, new MapOfSetRSExtractor<>(keyMapper, valueMapper));
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

}
