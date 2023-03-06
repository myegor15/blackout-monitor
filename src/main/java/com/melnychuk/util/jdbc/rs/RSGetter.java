package com.melnychuk.util.jdbc.rs;

import com.melnychuk.util.jdbc.PersistenceValue;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;

public class RSGetter {

    private final ResultSet rs;

    public RSGetter(ResultSet rs) {
        this.rs = rs;
    }

    public String getString(String key) {
        try {
            String result = this.rs.getString(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return result;
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public Long getLong(String key) {
        try {
            Long result = this.rs.getLong(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return result;
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public Integer getInteger(String key) {
        try {
            Integer result = this.rs.getInt(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return result;
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public Boolean getBoolean(String key) {
        try {
            boolean result = this.rs.getBoolean(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return result;
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public Instant getInstant(String key) {
        try {
            Timestamp timestamp = this.rs.getTimestamp(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return timestamp.toInstant();
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public BigDecimal getBigDecimal(String key) {
        try {
            BigDecimal result = this.rs.getBigDecimal(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return result;
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public Double getDouble(String key) {
        try {
            Double result = this.rs.getDouble(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return result;
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public Character getCharacter(String key) {
        try {
            String result = this.rs.getString(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                return result.charAt(0);
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

    public <T extends Enum<T> & PersistenceValue> T getEnumValue(String key, T[] values) {
        try {
            String result = this.rs.getString(key);
            if (this.rs.wasNull()) {
                return null;
            } else {
                for (T t : values) {
                    if (t.getPersistenceValue().equals(result)) {
                        return t;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            throw new RSException(e);
        }
    }

}
