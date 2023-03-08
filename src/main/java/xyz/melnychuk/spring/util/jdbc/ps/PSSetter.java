package xyz.melnychuk.spring.util.jdbc.ps;

import xyz.melnychuk.spring.util.jdbc.PersistentValue;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.util.Collection;
import java.util.function.Consumer;

public class PSSetter {

    private int i = 1;
    private final PreparedStatement ps;

    public PSSetter(PreparedStatement ps) {
        this.ps = ps;
    }

    public PSSetter setLong(Long value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.BIGINT);
            } else {
                this.ps.setLong(this.i, value);
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setString(String value) {
        try {
            if (value == null) {
                ps.setNull(this.i, Types.VARCHAR);
            } else {
                this.ps.setString(this.i, value);
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setTimestamp(Instant value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.TIMESTAMP);
            } else {
                Timestamp timestamp = new Timestamp(value.toEpochMilli());
                this.ps.setTimestamp(this.i, timestamp);
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setCharacter(Character value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.CHAR);
            } else {
                this.ps.setString(this.i, String.valueOf(value));
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setInteger(Integer value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.INTEGER);
            } else {
                this.ps.setInt(this.i, value);
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setBigDecimal(BigDecimal value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.NUMERIC);
            } else {
                this.ps.setBigDecimal(this.i, value);
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setDouble(Double value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.NUMERIC);
            } else {
                this.ps.setDouble(this.i, value);
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setBoolean(Boolean value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.BOOLEAN);
            } else {
                this.ps.setBoolean(this.i, value);
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public <T extends Enum<T> & PersistentValue> PSSetter setEnumValue(T value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.VARCHAR);
            } else {
                this.ps.setString(this.i, value.getPersistenceValue());
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new PSException(e);
        }
    }

    public PSSetter setLongCollection(Collection<Long> values) {
        return setCollection(values, this::setLong);
    }

    public PSSetter setIntegerCollection(Collection<Integer> values) {
        return setCollection(values, this::setInteger);
    }

    public PSSetter setStringCollection(Collection<String> values) {
        return setCollection(values, this::setString);
    }

    public <T> PSSetter setCollection(Collection<T> values, Consumer<T> setConsumer) {
        if (CollectionUtils.isEmpty(values)) {
            throw new PSException("Collection cannot be null or empty.");
        }

        values.forEach(setConsumer);
        return this;
    }
}
