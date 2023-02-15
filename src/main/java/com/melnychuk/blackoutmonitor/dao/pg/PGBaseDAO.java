package com.melnychuk.blackoutmonitor.dao.pg;

import com.melnychuk.blackoutmonitor.exception.AppDAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.util.List;

public class PGBaseDAO {
    protected final JdbcTemplate jdbcTemplate;

    public PGBaseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String sql, PreparedStatementSetter psSetter) {
        try {
            this.jdbcTemplate.update(sql, psSetter);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> T insert(String sql, PreparedStatementSetter psSetter, RowMapper<T> mapper) {
        try {
            List<T> result = this.jdbcTemplate.query(sql, psSetter, mapper);
            return CollectionUtils.isEmpty(result) ? null : result.get(0);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public void update(String sql, PreparedStatementSetter psSetter) {
        try {
            this.jdbcTemplate.update(sql, psSetter);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public void delete(String sql, PreparedStatementSetter psSetter) {
        try {
            this.jdbcTemplate.update(sql, psSetter);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> T selectOne(String sql, PreparedStatementSetter psSetter, RowMapper<T> mapper) {
        try {
            List<T> result = this.jdbcTemplate.query(sql, psSetter, mapper);
            return CollectionUtils.isEmpty(result) ? null : result.get(0);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public <T> List<T> selectList(String sql, PreparedStatementSetter psSetter, RowMapper<T> mapper) {
        try {
            return this.jdbcTemplate.query(sql, psSetter, mapper);
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public int setLong(PreparedStatement ps, int i, Long value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.BIGINT);
            } else {
                ps.setLong(i, value);
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public int setString(PreparedStatement ps, int i, String value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.VARCHAR);
            } else {
                ps.setString(i, value);
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public int setTimestamp(PreparedStatement ps, int i, Instant value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.TIMESTAMP);
            } else {
                Timestamp timestamp = new Timestamp(value.toEpochMilli());
                ps.setTimestamp(i, timestamp);
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public int setCharacter(PreparedStatement ps, int i, Character value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.CHAR);
            } else {
                ps.setString(i, String.valueOf(value));
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

//    public void setDate(PreparedStatement ps, int i, LocalDate value) {
//        try {
//            if (value == null) {
//                ps.setNull(i, Types.DATE);
//            } else {
//                Timestamp t = new Timestamp(value.getTime());
//                ps.setTimestamp(i, t);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public int setInteger(PreparedStatement ps, int i, Integer value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.INTEGER);
            } else {
                ps.setInt(i, value);
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public int setBigDecimal(PreparedStatement ps, int i, BigDecimal value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.NUMERIC);
            } else {
                ps.setBigDecimal(i, value);
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public int setDouble(PreparedStatement ps, int i, Double value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.NUMERIC);
            } else {
                ps.setDouble(i, value);
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }

    public int setBoolean(PreparedStatement ps, int i, Boolean value) {
        try {
            if (value == null) {
                ps.setNull(i, Types.BOOLEAN);
            } else {
                ps.setBoolean(i, value);
            }
            return ++i;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }
}
