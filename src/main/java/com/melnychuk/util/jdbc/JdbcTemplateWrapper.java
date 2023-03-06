package com.melnychuk.util.jdbc;

import com.melnychuk.util.jdbc.ps.PSSetterExecutor;
import com.melnychuk.util.jdbc.rs.RSMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.melnychuk.util.jdbc.rs.extractor.RSExtractors.*;

public class JdbcTemplateWrapper {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateWrapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String sql) {
        this.insert(sql, (PSSetterExecutor) null);
    }

    public void insert(String sql, PSSetterExecutor psSetterExecutor) {
        try {
            this.jdbcTemplate.update(sql, psSetterExecutor);
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public <T> T insert(String sql, RSMapper<T> mapper) {
        return this.insert(sql, null, mapper);
    }

    public <T> T insert(String sql, PSSetterExecutor psSetterExecutor, RSMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, objectExtractor(mapper));
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public void update(String sql) {
        this.update(sql, null);
    }

    public void update(String sql, PSSetterExecutor psSetterExecutor) {
        try {
            this.jdbcTemplate.update(sql, psSetterExecutor);
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public void delete(String sql) {
        this.delete(sql, null);
    }

    public void delete(String sql, PSSetterExecutor psSetterExecutor) {
        try {
            this.jdbcTemplate.update(sql, psSetterExecutor);
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public <T> T selectOne(String sql, RSMapper<T> mapper) {
        return this.selectOne(sql, null, mapper);
    }

    public <T> T selectOne(String sql, PSSetterExecutor psSetterExecutor, RSMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, objectExtractor(mapper));
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public <T> List<T> selectList(String sql, RSMapper<T> mapper) {
        return this.selectList(sql, null, mapper);
    }

    public <T> List<T> selectList(String sql, PSSetterExecutor psSetterExecutor, RSMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, listExtractor(mapper));
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public <T> Set<T> selectSet(String sql, RSMapper<T> mapper) {
        return this.selectSet(sql, null, mapper);
    }

    public <T> Set<T> selectSet(String sql, PSSetterExecutor psSetterExecutor, RSMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, setExtractor(mapper));
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public <K, T> Map<K, T> selectMap(String sql, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        return this.selectMap(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, T> selectMap(String sql, PSSetterExecutor psSetterExecutor, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, mapExtractor(keyMapper, valueMapper));
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public <K, T> Map<K, List<T>> selectMapOfLists(String sql, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        return this.selectMapOfLists(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, List<T>> selectMapOfLists(String sql, PSSetterExecutor psSetterExecutor, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, mapOfListsExtractor(keyMapper, valueMapper));
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

    public <K, T> Map<K, Set<T>> selectMapOfSets(String sql, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        return this.selectMapOfSets(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, Set<T>> selectMapOfSets(String sql, PSSetterExecutor psSetterExecutor, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, mapOfSetsExtractor(keyMapper, valueMapper));
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

}
