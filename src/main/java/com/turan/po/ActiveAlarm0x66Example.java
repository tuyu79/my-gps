package com.turan.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActiveAlarm0x66Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public ActiveAlarm0x66Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAlarmNoIsNull() {
            addCriterion("alarm_no is null");
            return (Criteria) this;
        }

        public Criteria andAlarmNoIsNotNull() {
            addCriterion("alarm_no is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmNoEqualTo(Long value) {
            addCriterion("alarm_no =", value, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoNotEqualTo(Long value) {
            addCriterion("alarm_no <>", value, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoGreaterThan(Long value) {
            addCriterion("alarm_no >", value, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoGreaterThanOrEqualTo(Long value) {
            addCriterion("alarm_no >=", value, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoLessThan(Long value) {
            addCriterion("alarm_no <", value, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoLessThanOrEqualTo(Long value) {
            addCriterion("alarm_no <=", value, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoIn(List<Long> values) {
            addCriterion("alarm_no in", values, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoNotIn(List<Long> values) {
            addCriterion("alarm_no not in", values, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoBetween(Long value1, Long value2) {
            addCriterion("alarm_no between", value1, value2, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andAlarmNoNotBetween(Long value1, Long value2) {
            addCriterion("alarm_no not between", value1, value2, "alarmNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIsNull() {
            addCriterion("vehicle_no is null");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIsNotNull() {
            addCriterion("vehicle_no is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleNoEqualTo(Long value) {
            addCriterion("vehicle_no =", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotEqualTo(Long value) {
            addCriterion("vehicle_no <>", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoGreaterThan(Long value) {
            addCriterion("vehicle_no >", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoGreaterThanOrEqualTo(Long value) {
            addCriterion("vehicle_no >=", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLessThan(Long value) {
            addCriterion("vehicle_no <", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLessThanOrEqualTo(Long value) {
            addCriterion("vehicle_no <=", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIn(List<Long> values) {
            addCriterion("vehicle_no in", values, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotIn(List<Long> values) {
            addCriterion("vehicle_no not in", values, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoBetween(Long value1, Long value2) {
            addCriterion("vehicle_no between", value1, value2, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotBetween(Long value1, Long value2) {
            addCriterion("vehicle_no not between", value1, value2, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIsNull() {
            addCriterion("alarm_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIsNotNull() {
            addCriterion("alarm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdEqualTo(Integer value) {
            addCriterion("alarm_id =", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotEqualTo(Integer value) {
            addCriterion("alarm_id <>", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThan(Integer value) {
            addCriterion("alarm_id >", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_id >=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThan(Integer value) {
            addCriterion("alarm_id <", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_id <=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIn(List<Integer> values) {
            addCriterion("alarm_id in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotIn(List<Integer> values) {
            addCriterion("alarm_id not in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_id between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_id not between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andMarkStatusIsNull() {
            addCriterion("mark_status is null");
            return (Criteria) this;
        }

        public Criteria andMarkStatusIsNotNull() {
            addCriterion("mark_status is not null");
            return (Criteria) this;
        }

        public Criteria andMarkStatusEqualTo(Integer value) {
            addCriterion("mark_status =", value, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusNotEqualTo(Integer value) {
            addCriterion("mark_status <>", value, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusGreaterThan(Integer value) {
            addCriterion("mark_status >", value, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_status >=", value, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusLessThan(Integer value) {
            addCriterion("mark_status <", value, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("mark_status <=", value, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusIn(List<Integer> values) {
            addCriterion("mark_status in", values, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusNotIn(List<Integer> values) {
            addCriterion("mark_status not in", values, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusBetween(Integer value1, Integer value2) {
            addCriterion("mark_status between", value1, value2, "markStatus");
            return (Criteria) this;
        }

        public Criteria andMarkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_status not between", value1, value2, "markStatus");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(Integer value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(Integer value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(Integer value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(Integer value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<Integer> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<Integer> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(Integer value1, Integer value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Integer value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Integer value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Integer value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Integer value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Integer value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Integer> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Integer> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Integer value1, Integer value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Integer value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Integer value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Integer value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Integer value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Integer value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Integer> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Integer> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Integer value1, Integer value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("`time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("`time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("`time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("`time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("`time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("`time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("`time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("`time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("`time` not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andStatusBitIsNull() {
            addCriterion("status_bit is null");
            return (Criteria) this;
        }

        public Criteria andStatusBitIsNotNull() {
            addCriterion("status_bit is not null");
            return (Criteria) this;
        }

        public Criteria andStatusBitEqualTo(Integer value) {
            addCriterion("status_bit =", value, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitNotEqualTo(Integer value) {
            addCriterion("status_bit <>", value, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitGreaterThan(Integer value) {
            addCriterion("status_bit >", value, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_bit >=", value, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitLessThan(Integer value) {
            addCriterion("status_bit <", value, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitLessThanOrEqualTo(Integer value) {
            addCriterion("status_bit <=", value, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitIn(List<Integer> values) {
            addCriterion("status_bit in", values, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitNotIn(List<Integer> values) {
            addCriterion("status_bit not in", values, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitBetween(Integer value1, Integer value2) {
            addCriterion("status_bit between", value1, value2, "statusBit");
            return (Criteria) this;
        }

        public Criteria andStatusBitNotBetween(Integer value1, Integer value2) {
            addCriterion("status_bit not between", value1, value2, "statusBit");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNull() {
            addCriterion("dev_id is null");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNotNull() {
            addCriterion("dev_id is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdEqualTo(String value) {
            addCriterion("dev_id =", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotEqualTo(String value) {
            addCriterion("dev_id <>", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThan(String value) {
            addCriterion("dev_id >", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThanOrEqualTo(String value) {
            addCriterion("dev_id >=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThan(String value) {
            addCriterion("dev_id <", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThanOrEqualTo(String value) {
            addCriterion("dev_id <=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLike(String value) {
            addCriterion("dev_id like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotLike(String value) {
            addCriterion("dev_id not like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdIn(List<String> values) {
            addCriterion("dev_id in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotIn(List<String> values) {
            addCriterion("dev_id not in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdBetween(String value1, String value2) {
            addCriterion("dev_id between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotBetween(String value1, String value2) {
            addCriterion("dev_id not between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andMarkTimeIsNull() {
            addCriterion("mark_time is null");
            return (Criteria) this;
        }

        public Criteria andMarkTimeIsNotNull() {
            addCriterion("mark_time is not null");
            return (Criteria) this;
        }

        public Criteria andMarkTimeEqualTo(Date value) {
            addCriterion("mark_time =", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeNotEqualTo(Date value) {
            addCriterion("mark_time <>", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeGreaterThan(Date value) {
            addCriterion("mark_time >", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mark_time >=", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeLessThan(Date value) {
            addCriterion("mark_time <", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeLessThanOrEqualTo(Date value) {
            addCriterion("mark_time <=", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeIn(List<Date> values) {
            addCriterion("mark_time in", values, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeNotIn(List<Date> values) {
            addCriterion("mark_time not in", values, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeBetween(Date value1, Date value2) {
            addCriterion("mark_time between", value1, value2, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeNotBetween(Date value1, Date value2) {
            addCriterion("mark_time not between", value1, value2, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceIsNull() {
            addCriterion("mark_sequence is null");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceIsNotNull() {
            addCriterion("mark_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceEqualTo(Integer value) {
            addCriterion("mark_sequence =", value, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceNotEqualTo(Integer value) {
            addCriterion("mark_sequence <>", value, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceGreaterThan(Integer value) {
            addCriterion("mark_sequence >", value, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_sequence >=", value, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceLessThan(Integer value) {
            addCriterion("mark_sequence <", value, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("mark_sequence <=", value, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceIn(List<Integer> values) {
            addCriterion("mark_sequence in", values, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceNotIn(List<Integer> values) {
            addCriterion("mark_sequence not in", values, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceBetween(Integer value1, Integer value2) {
            addCriterion("mark_sequence between", value1, value2, "markSequence");
            return (Criteria) this;
        }

        public Criteria andMarkSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_sequence not between", value1, value2, "markSequence");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumIsNull() {
            addCriterion("attachment_num is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumIsNotNull() {
            addCriterion("attachment_num is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumEqualTo(Integer value) {
            addCriterion("attachment_num =", value, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumNotEqualTo(Integer value) {
            addCriterion("attachment_num <>", value, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumGreaterThan(Integer value) {
            addCriterion("attachment_num >", value, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("attachment_num >=", value, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumLessThan(Integer value) {
            addCriterion("attachment_num <", value, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumLessThanOrEqualTo(Integer value) {
            addCriterion("attachment_num <=", value, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumIn(List<Integer> values) {
            addCriterion("attachment_num in", values, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumNotIn(List<Integer> values) {
            addCriterion("attachment_num not in", values, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumBetween(Integer value1, Integer value2) {
            addCriterion("attachment_num between", value1, value2, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andAttachmentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("attachment_num not between", value1, value2, "attachmentNum");
            return (Criteria) this;
        }

        public Criteria andReserveIsNull() {
            addCriterion("reserve is null");
            return (Criteria) this;
        }

        public Criteria andReserveIsNotNull() {
            addCriterion("reserve is not null");
            return (Criteria) this;
        }

        public Criteria andReserveEqualTo(Integer value) {
            addCriterion("reserve =", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotEqualTo(Integer value) {
            addCriterion("reserve <>", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThan(Integer value) {
            addCriterion("reserve >", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve >=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThan(Integer value) {
            addCriterion("reserve <", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThanOrEqualTo(Integer value) {
            addCriterion("reserve <=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveIn(List<Integer> values) {
            addCriterion("reserve in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotIn(List<Integer> values) {
            addCriterion("reserve not in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveBetween(Integer value1, Integer value2) {
            addCriterion("reserve between", value1, value2, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve not between", value1, value2, "reserve");
            return (Criteria) this;
        }

        public Criteria andEventNumIsNull() {
            addCriterion("event_num is null");
            return (Criteria) this;
        }

        public Criteria andEventNumIsNotNull() {
            addCriterion("event_num is not null");
            return (Criteria) this;
        }

        public Criteria andEventNumEqualTo(Integer value) {
            addCriterion("event_num =", value, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumNotEqualTo(Integer value) {
            addCriterion("event_num <>", value, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumGreaterThan(Integer value) {
            addCriterion("event_num >", value, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_num >=", value, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumLessThan(Integer value) {
            addCriterion("event_num <", value, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumLessThanOrEqualTo(Integer value) {
            addCriterion("event_num <=", value, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumIn(List<Integer> values) {
            addCriterion("event_num in", values, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumNotIn(List<Integer> values) {
            addCriterion("event_num not in", values, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumBetween(Integer value1, Integer value2) {
            addCriterion("event_num between", value1, value2, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventNumNotBetween(Integer value1, Integer value2) {
            addCriterion("event_num not between", value1, value2, "eventNum");
            return (Criteria) this;
        }

        public Criteria andEventListIsNull() {
            addCriterion("event_list is null");
            return (Criteria) this;
        }

        public Criteria andEventListIsNotNull() {
            addCriterion("event_list is not null");
            return (Criteria) this;
        }

        public Criteria andEventListEqualTo(String value) {
            addCriterion("event_list =", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListNotEqualTo(String value) {
            addCriterion("event_list <>", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListGreaterThan(String value) {
            addCriterion("event_list >", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListGreaterThanOrEqualTo(String value) {
            addCriterion("event_list >=", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListLessThan(String value) {
            addCriterion("event_list <", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListLessThanOrEqualTo(String value) {
            addCriterion("event_list <=", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListLike(String value) {
            addCriterion("event_list like", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListNotLike(String value) {
            addCriterion("event_list not like", value, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListIn(List<String> values) {
            addCriterion("event_list in", values, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListNotIn(List<String> values) {
            addCriterion("event_list not in", values, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListBetween(String value1, String value2) {
            addCriterion("event_list between", value1, value2, "eventList");
            return (Criteria) this;
        }

        public Criteria andEventListNotBetween(String value1, String value2) {
            addCriterion("event_list not between", value1, value2, "eventList");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}