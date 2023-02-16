package com.melnychuk.util.jdbc.ps;

import com.melnychuk.blackoutmonitor.exception.AppDAOException;
import com.melnychuk.util.jdbc.PersistenceEnumValue;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;

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
            throw new AppDAOException(e);
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
            throw new AppDAOException(e);
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
            throw new AppDAOException(e);
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
            throw new AppDAOException(e);
        }
    }

//    public void setDate(LocalDate value) {
//        try {
//            if (value == null) {
//                this.ps.setNull(this.i, Types.DATE);
//            } else {
//                Timestamp t = new Timestamp(value.getTime());
//                this.ps.setTimestamp(this.i, t);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

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
            throw new AppDAOException(e);
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
            throw new AppDAOException(e);
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
            throw new AppDAOException(e);
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
            throw new AppDAOException(e);
        }
    }

    public PSSetter setEnum(PersistenceEnumValue value) {
        try {
            if (value == null) {
                this.ps.setNull(this.i, Types.VARCHAR);
            } else {
                this.ps.setString(this.i, value.getPersistenceValue());
            }
            this.i++;
            return this;
        } catch (Exception e) {
            throw new AppDAOException(e);
        }
    }
}