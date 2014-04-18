package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurriculumScheduleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurriculumScheduleCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherId is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherId =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherId <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherId >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherId >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherId <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherId <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherId in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherId not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherId between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherId not between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNull() {
            addCriterion("curriculum_id is null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNotNull() {
            addCriterion("curriculum_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdEqualTo(Integer value) {
            addCriterion("curriculum_id =", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotEqualTo(Integer value) {
            addCriterion("curriculum_id <>", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThan(Integer value) {
            addCriterion("curriculum_id >", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id >=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThan(Integer value) {
            addCriterion("curriculum_id <", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id <=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIn(List<Integer> values) {
            addCriterion("curriculum_id in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotIn(List<Integer> values) {
            addCriterion("curriculum_id not in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id not between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andTermYearidIsNull() {
            addCriterion("term_yearId is null");
            return (Criteria) this;
        }

        public Criteria andTermYearidIsNotNull() {
            addCriterion("term_yearId is not null");
            return (Criteria) this;
        }

        public Criteria andTermYearidEqualTo(Integer value) {
            addCriterion("term_yearId =", value, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidNotEqualTo(Integer value) {
            addCriterion("term_yearId <>", value, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidGreaterThan(Integer value) {
            addCriterion("term_yearId >", value, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidGreaterThanOrEqualTo(Integer value) {
            addCriterion("term_yearId >=", value, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidLessThan(Integer value) {
            addCriterion("term_yearId <", value, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidLessThanOrEqualTo(Integer value) {
            addCriterion("term_yearId <=", value, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidIn(List<Integer> values) {
            addCriterion("term_yearId in", values, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidNotIn(List<Integer> values) {
            addCriterion("term_yearId not in", values, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidBetween(Integer value1, Integer value2) {
            addCriterion("term_yearId between", value1, value2, "termYearid");
            return (Criteria) this;
        }

        public Criteria andTermYearidNotBetween(Integer value1, Integer value2) {
            addCriterion("term_yearId not between", value1, value2, "termYearid");
            return (Criteria) this;
        }

        public Criteria andAmPmIsNull() {
            addCriterion("am_pm is null");
            return (Criteria) this;
        }

        public Criteria andAmPmIsNotNull() {
            addCriterion("am_pm is not null");
            return (Criteria) this;
        }

        public Criteria andAmPmEqualTo(Byte value) {
            addCriterion("am_pm =", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmNotEqualTo(Byte value) {
            addCriterion("am_pm <>", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmGreaterThan(Byte value) {
            addCriterion("am_pm >", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmGreaterThanOrEqualTo(Byte value) {
            addCriterion("am_pm >=", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmLessThan(Byte value) {
            addCriterion("am_pm <", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmLessThanOrEqualTo(Byte value) {
            addCriterion("am_pm <=", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmIn(List<Byte> values) {
            addCriterion("am_pm in", values, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmNotIn(List<Byte> values) {
            addCriterion("am_pm not in", values, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmBetween(Byte value1, Byte value2) {
            addCriterion("am_pm between", value1, value2, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmNotBetween(Byte value1, Byte value2) {
            addCriterion("am_pm not between", value1, value2, "amPm");
            return (Criteria) this;
        }

        public Criteria andWeeknumIsNull() {
            addCriterion("weekNum is null");
            return (Criteria) this;
        }

        public Criteria andWeeknumIsNotNull() {
            addCriterion("weekNum is not null");
            return (Criteria) this;
        }

        public Criteria andWeeknumEqualTo(Byte value) {
            addCriterion("weekNum =", value, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumNotEqualTo(Byte value) {
            addCriterion("weekNum <>", value, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumGreaterThan(Byte value) {
            addCriterion("weekNum >", value, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumGreaterThanOrEqualTo(Byte value) {
            addCriterion("weekNum >=", value, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumLessThan(Byte value) {
            addCriterion("weekNum <", value, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumLessThanOrEqualTo(Byte value) {
            addCriterion("weekNum <=", value, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumIn(List<Byte> values) {
            addCriterion("weekNum in", values, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumNotIn(List<Byte> values) {
            addCriterion("weekNum not in", values, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumBetween(Byte value1, Byte value2) {
            addCriterion("weekNum between", value1, value2, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeeknumNotBetween(Byte value1, Byte value2) {
            addCriterion("weekNum not between", value1, value2, "weeknum");
            return (Criteria) this;
        }

        public Criteria andWeekdaysIsNull() {
            addCriterion("weekdays is null");
            return (Criteria) this;
        }

        public Criteria andWeekdaysIsNotNull() {
            addCriterion("weekdays is not null");
            return (Criteria) this;
        }

        public Criteria andWeekdaysEqualTo(Byte value) {
            addCriterion("weekdays =", value, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysNotEqualTo(Byte value) {
            addCriterion("weekdays <>", value, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysGreaterThan(Byte value) {
            addCriterion("weekdays >", value, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysGreaterThanOrEqualTo(Byte value) {
            addCriterion("weekdays >=", value, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysLessThan(Byte value) {
            addCriterion("weekdays <", value, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysLessThanOrEqualTo(Byte value) {
            addCriterion("weekdays <=", value, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysIn(List<Byte> values) {
            addCriterion("weekdays in", values, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysNotIn(List<Byte> values) {
            addCriterion("weekdays not in", values, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysBetween(Byte value1, Byte value2) {
            addCriterion("weekdays between", value1, value2, "weekdays");
            return (Criteria) this;
        }

        public Criteria andWeekdaysNotBetween(Byte value1, Byte value2) {
            addCriterion("weekdays not between", value1, value2, "weekdays");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeIsNull() {
            addCriterion("meet_stime is null");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeIsNotNull() {
            addCriterion("meet_stime is not null");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeEqualTo(Date value) {
            addCriterion("meet_stime =", value, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeNotEqualTo(Date value) {
            addCriterion("meet_stime <>", value, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeGreaterThan(Date value) {
            addCriterion("meet_stime >", value, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meet_stime >=", value, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeLessThan(Date value) {
            addCriterion("meet_stime <", value, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeLessThanOrEqualTo(Date value) {
            addCriterion("meet_stime <=", value, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeIn(List<Date> values) {
            addCriterion("meet_stime in", values, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeNotIn(List<Date> values) {
            addCriterion("meet_stime not in", values, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeBetween(Date value1, Date value2) {
            addCriterion("meet_stime between", value1, value2, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetSTimeNotBetween(Date value1, Date value2) {
            addCriterion("meet_stime not between", value1, value2, "meetSTime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeIsNull() {
            addCriterion("meet_etime is null");
            return (Criteria) this;
        }

        public Criteria andMeetETimeIsNotNull() {
            addCriterion("meet_etime is not null");
            return (Criteria) this;
        }

        public Criteria andMeetETimeEqualTo(Date value) {
            addCriterion("meet_etime =", value, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeNotEqualTo(Date value) {
            addCriterion("meet_etime <>", value, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeGreaterThan(Date value) {
            addCriterion("meet_etime >", value, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meet_etime >=", value, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeLessThan(Date value) {
            addCriterion("meet_etime <", value, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeLessThanOrEqualTo(Date value) {
            addCriterion("meet_etime <=", value, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeIn(List<Date> values) {
            addCriterion("meet_etime in", values, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeNotIn(List<Date> values) {
            addCriterion("meet_etime not in", values, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeBetween(Date value1, Date value2) {
            addCriterion("meet_etime between", value1, value2, "meetETime");
            return (Criteria) this;
        }

        public Criteria andMeetETimeNotBetween(Date value1, Date value2) {
            addCriterion("meet_etime not between", value1, value2, "meetETime");
            return (Criteria) this;
        }


    }

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