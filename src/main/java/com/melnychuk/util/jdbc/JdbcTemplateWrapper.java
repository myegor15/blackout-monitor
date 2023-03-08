package com.melnychuk.util.jdbc;

import com.melnychuk.util.jdbc.ps.PSSetterExecutor;
import com.melnychuk.util.jdbc.rs.RSMapper;
import com.melnychuk.util.jdbc.rs.extractor.RSCollectionExtractor;
import com.melnychuk.util.jdbc.rs.extractor.RSMapExtractor;
import com.melnychuk.util.jdbc.rs.extractor.RSMapOfCollectionsExtractor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.melnychuk.util.jdbc.rs.extractor.RSExtractors.*;

public class JdbcTemplateWrapper {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateWrapper(JdbcTemplate jdbcTemplate) {
        Assert.notNull(jdbcTemplate, "jdbcTemplate cannot be null");
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
        return selectList(sql, psSetterExecutor, listExtractor(mapper));
    }

    public <T> List<T> selectList(String sql, PSSetterExecutor psSetterExecutor, RSCollectionExtractor<T, List<T>> extractor) {
        return selectCollection(sql, psSetterExecutor, extractor);
    }

    public <T> Set<T> selectSet(String sql, RSMapper<T> mapper) {
        return this.selectSet(sql, null, mapper);
    }

    public <T> Set<T> selectSet(String sql, PSSetterExecutor psSetterExecutor, RSMapper<T> mapper) {
        return selectSet(sql, psSetterExecutor, setExtractor(mapper));
    }

    public <T> Set<T> selectSet(String sql, PSSetterExecutor psSetterExecutor, RSCollectionExtractor<T, Set<T>> extractor) {
        return selectCollection(sql, psSetterExecutor, extractor);
    }

    public <T, C extends Collection<T>> C selectCollection(String sql, PSSetterExecutor psSetterExecutor, RSCollectionExtractor<T, C> extractor) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, extractor);
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
        return selectMap(sql, psSetterExecutor, mapExtractor(keyMapper, valueMapper));
    }

    public <K, T> Map<K, T> selectMap(String sql, PSSetterExecutor psSetterExecutor, RSMapExtractor<K, T> extractor) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, extractor);
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
        return selectMapOfLists(sql, psSetterExecutor, mapOfListsExtractor(keyMapper, valueMapper));
    }

    public <K, T> Map<K, List<T>> selectMapOfLists(String sql, PSSetterExecutor psSetterExecutor, RSMapOfCollectionsExtractor<K, T, List<T>> extractor) {
        return selectMapOfCollections(sql, psSetterExecutor, extractor);
    }

    public <K, T> Map<K, Set<T>> selectMapOfSets(String sql, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        return this.selectMapOfSets(sql, null, keyMapper, valueMapper);
    }

    public <K, T> Map<K, Set<T>> selectMapOfSets(String sql, PSSetterExecutor psSetterExecutor, RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        return selectMapOfSets(sql, psSetterExecutor, mapOfSetsExtractor(keyMapper, valueMapper));
    }

    public <K, T> Map<K, Set<T>> selectMapOfSets(String sql, PSSetterExecutor psSetterExecutor, RSMapOfCollectionsExtractor<K, T, Set<T>> extractor) {
        return selectMapOfCollections(sql, psSetterExecutor, extractor);
    }

    public <K, T, V extends Collection<T>> Map<K, V> selectMapOfCollections(String sql, PSSetterExecutor psSetterExecutor, RSMapOfCollectionsExtractor<K, T, V> extractor) {
        try {
            return this.jdbcTemplate.query(sql, psSetterExecutor, extractor);
        } catch (JDBCException e) {
            throw e;
        } catch (Exception e) {
            throw new JDBCException(e);
        }
    }

}
