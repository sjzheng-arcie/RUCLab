package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class ArrangementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArrangementCriteria() {
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andApprovalIdIsNull() {
            addCriterion("approval_id is null");
            return (Criteria) this;
        }

        public Criteria andApprovalIdIsNotNull() {
            addCriterion("approval_id is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalIdEqualTo(Integer value) {
            addCriterion("approval_id =", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdNotEqualTo(Integer value) {
            addCriterion("approval_id <>", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdGreaterThan(Integer value) {
            addCriterion("approval_id >", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("approval_id >=", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdLessThan(Integer value) {
            addCriterion("approval_id <", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdLessThanOrEqualTo(Integer value) {
            addCriterion("approval_id <=", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdIn(List<Integer> values) {
            addCriterion("approval_id in", values, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdNotIn(List<Integer> values) {
            addCriterion("approval_id not in", values, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdBetween(Integer value1, Integer value2) {
            addCriterion("approval_id between", value1, value2, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("approval_id not between", value1, value2, "approvalId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNull() {
            addCriterion("approval_opinion is null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNotNull() {
            addCriterion("approval_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionEqualTo(String value) {
            addCriterion("approval_opinion =", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotEqualTo(String value) {
            addCriterion("approval_opinion <>", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThan(String value) {
            addCriterion("approval_opinion >", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("approval_opinion >=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThan(String value) {
            addCriterion("approval_opinion <", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThanOrEqualTo(String value) {
            addCriterion("approval_opinion <=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLike(String value) {
            addCriterion("approval_opinion like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotLike(String value) {
            addCriterion("approval_opinion not like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIn(List<String> values) {
            addCriterion("approval_opinion in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotIn(List<String> values) {
            addCriterion("approval_opinion not in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionBetween(String value1, String value2) {
            addCriterion("approval_opinion between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotBetween(String value1, String value2) {
            addCriterion("approval_opinion not between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andTermYearIsNull() {
            addCriterion("term_year is null");
            return (Criteria) this;
        }

        public Criteria andTermYearIsNotNull() {
            addCriterion("term_year is not null");
            return (Criteria) this;
        }

        public Criteria andTermYearEqualTo(Integer value) {
            addCriterion("term_year =", value, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearNotEqualTo(Integer value) {
            addCriterion("term_year <>", value, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearGreaterThan(Integer value) {
            addCriterion("term_year >", value, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("term_year >=", value, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearLessThan(Integer value) {
            addCriterion("term_year <", value, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearLessThanOrEqualTo(Integer value) {
            addCriterion("term_year <=", value, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearIn(List<Integer> values) {
            addCriterion("term_year in", values, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearNotIn(List<Integer> values) {
            addCriterion("term_year not in", values, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearBetween(Integer value1, Integer value2) {
            addCriterion("term_year between", value1, value2, "termYear");
            return (Criteria) this;
        }

        public Criteria andTermYearNotBetween(Integer value1, Integer value2) {
            addCriterion("term_year not between", value1, value2, "termYear");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(Integer value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(Integer value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(Integer value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(Integer value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(Integer value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<Integer> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<Integer> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(Integer value1, Integer value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWdayIsNull() {
            addCriterion("wDay is null");
            return (Criteria) this;
        }

        public Criteria andWdayIsNotNull() {
            addCriterion("wDay is not null");
            return (Criteria) this;
        }

        public Criteria andWdayEqualTo(Integer value) {
            addCriterion("wDay =", value, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayNotEqualTo(Integer value) {
            addCriterion("wDay <>", value, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayGreaterThan(Integer value) {
            addCriterion("wDay >", value, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("wDay >=", value, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayLessThan(Integer value) {
            addCriterion("wDay <", value, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayLessThanOrEqualTo(Integer value) {
            addCriterion("wDay <=", value, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayIn(List<Integer> values) {
            addCriterion("wDay in", values, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayNotIn(List<Integer> values) {
            addCriterion("wDay not in", values, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayBetween(Integer value1, Integer value2) {
            addCriterion("wDay between", value1, value2, "wday");
            return (Criteria) this;
        }

        public Criteria andWdayNotBetween(Integer value1, Integer value2) {
            addCriterion("wDay not between", value1, value2, "wday");
            return (Criteria) this;
        }

        public Criteria andSectionIsNull() {
            addCriterion("section is null");
            return (Criteria) this;
        }

        public Criteria andSectionIsNotNull() {
            addCriterion("section is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEqualTo(Integer value) {
            addCriterion("section =", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotEqualTo(Integer value) {
            addCriterion("section <>", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThan(Integer value) {
            addCriterion("section >", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("section >=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThan(Integer value) {
            addCriterion("section <", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThanOrEqualTo(Integer value) {
            addCriterion("section <=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionIn(List<Integer> values) {
            addCriterion("section in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotIn(List<Integer> values) {
            addCriterion("section not in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionBetween(Integer value1, Integer value2) {
            addCriterion("section between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotBetween(Integer value1, Integer value2) {
            addCriterion("section not between", value1, value2, "section");
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