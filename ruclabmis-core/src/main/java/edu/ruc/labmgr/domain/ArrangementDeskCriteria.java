package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class ArrangementDeskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArrangementDeskCriteria() {
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

        public Criteria andArrangementIdIsNull() {
            addCriterion("arrangement_id is null");
            return (Criteria) this;
        }

        public Criteria andArrangementIdIsNotNull() {
            addCriterion("arrangement_id is not null");
            return (Criteria) this;
        }

        public Criteria andArrangementIdEqualTo(Integer value) {
            addCriterion("arrangement_id =", value, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdNotEqualTo(Integer value) {
            addCriterion("arrangement_id <>", value, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdGreaterThan(Integer value) {
            addCriterion("arrangement_id >", value, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("arrangement_id >=", value, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdLessThan(Integer value) {
            addCriterion("arrangement_id <", value, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdLessThanOrEqualTo(Integer value) {
            addCriterion("arrangement_id <=", value, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdIn(List<Integer> values) {
            addCriterion("arrangement_id in", values, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdNotIn(List<Integer> values) {
            addCriterion("arrangement_id not in", values, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdBetween(Integer value1, Integer value2) {
            addCriterion("arrangement_id between", value1, value2, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andArrangementIdNotBetween(Integer value1, Integer value2) {
            addCriterion("arrangement_id not between", value1, value2, "arrangementId");
            return (Criteria) this;
        }

        public Criteria andDeskIdIsNull() {
            addCriterion("desk_id is null");
            return (Criteria) this;
        }

        public Criteria andDeskIdIsNotNull() {
            addCriterion("desk_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeskIdEqualTo(Integer value) {
            addCriterion("desk_id =", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdNotEqualTo(Integer value) {
            addCriterion("desk_id <>", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdGreaterThan(Integer value) {
            addCriterion("desk_id >", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("desk_id >=", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdLessThan(Integer value) {
            addCriterion("desk_id <", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdLessThanOrEqualTo(Integer value) {
            addCriterion("desk_id <=", value, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdIn(List<Integer> values) {
            addCriterion("desk_id in", values, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdNotIn(List<Integer> values) {
            addCriterion("desk_id not in", values, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdBetween(Integer value1, Integer value2) {
            addCriterion("desk_id between", value1, value2, "deskId");
            return (Criteria) this;
        }

        public Criteria andDeskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("desk_id not between", value1, value2, "deskId");
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