package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryRoomCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LaboratoryRoomCriteria() {
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

        public Criteria andLaboratoryRoomIdIsNull() {
            addCriterion("laboratory_room_id is null");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdIsNotNull() {
            addCriterion("laboratory_room_id is not null");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdEqualTo(Integer value) {
            addCriterion("laboratory_room_id =", value, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdNotEqualTo(Integer value) {
            addCriterion("laboratory_room_id <>", value, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdGreaterThan(Integer value) {
            addCriterion("laboratory_room_id >", value, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("laboratory_room_id >=", value, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdLessThan(Integer value) {
            addCriterion("laboratory_room_id <", value, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("laboratory_room_id <=", value, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdIn(List<Integer> values) {
            addCriterion("laboratory_room_id in", values, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdNotIn(List<Integer> values) {
            addCriterion("laboratory_room_id not in", values, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("laboratory_room_id between", value1, value2, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("laboratory_room_id not between", value1, value2, "laboratoryRoomId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdIsNull() {
            addCriterion("laboratory_id is null");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdIsNotNull() {
            addCriterion("laboratory_id is not null");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdEqualTo(Integer value) {
            addCriterion("laboratory_id =", value, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdNotEqualTo(Integer value) {
            addCriterion("laboratory_id <>", value, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdGreaterThan(Integer value) {
            addCriterion("laboratory_id >", value, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("laboratory_id >=", value, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdLessThan(Integer value) {
            addCriterion("laboratory_id <", value, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("laboratory_id <=", value, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdIn(List<Integer> values) {
            addCriterion("laboratory_id in", values, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdNotIn(List<Integer> values) {
            addCriterion("laboratory_id not in", values, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdBetween(Integer value1, Integer value2) {
            addCriterion("laboratory_id between", value1, value2, "laboratoryId");
            return (Criteria) this;
        }

        public Criteria andLaboratoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("laboratory_id not between", value1, value2, "laboratoryId");
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