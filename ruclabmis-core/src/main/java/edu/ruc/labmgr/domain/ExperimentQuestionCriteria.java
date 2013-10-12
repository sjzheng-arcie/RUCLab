package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class ExperimentQuestionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExperimentQuestionCriteria() {
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

        public Criteria andExperimentInstructionsIdIsNull() {
            addCriterion("experiment_instructions_id is null");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdIsNotNull() {
            addCriterion("experiment_instructions_id is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdEqualTo(Integer value) {
            addCriterion("experiment_instructions_id =", value, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdNotEqualTo(Integer value) {
            addCriterion("experiment_instructions_id <>", value, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdGreaterThan(Integer value) {
            addCriterion("experiment_instructions_id >", value, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("experiment_instructions_id >=", value, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdLessThan(Integer value) {
            addCriterion("experiment_instructions_id <", value, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdLessThanOrEqualTo(Integer value) {
            addCriterion("experiment_instructions_id <=", value, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdIn(List<Integer> values) {
            addCriterion("experiment_instructions_id in", values, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdNotIn(List<Integer> values) {
            addCriterion("experiment_instructions_id not in", values, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdBetween(Integer value1, Integer value2) {
            addCriterion("experiment_instructions_id between", value1, value2, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andExperimentInstructionsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("experiment_instructions_id not between", value1, value2, "experimentInstructionsId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andReportFormIsNull() {
            addCriterion("report_form is null");
            return (Criteria) this;
        }

        public Criteria andReportFormIsNotNull() {
            addCriterion("report_form is not null");
            return (Criteria) this;
        }

        public Criteria andReportFormEqualTo(Short value) {
            addCriterion("report_form =", value, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormNotEqualTo(Short value) {
            addCriterion("report_form <>", value, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormGreaterThan(Short value) {
            addCriterion("report_form >", value, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormGreaterThanOrEqualTo(Short value) {
            addCriterion("report_form >=", value, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormLessThan(Short value) {
            addCriterion("report_form <", value, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormLessThanOrEqualTo(Short value) {
            addCriterion("report_form <=", value, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormIn(List<Short> values) {
            addCriterion("report_form in", values, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormNotIn(List<Short> values) {
            addCriterion("report_form not in", values, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormBetween(Short value1, Short value2) {
            addCriterion("report_form between", value1, value2, "reportForm");
            return (Criteria) this;
        }

        public Criteria andReportFormNotBetween(Short value1, Short value2) {
            addCriterion("report_form not between", value1, value2, "reportForm");
            return (Criteria) this;
        }

        public Criteria andSubstanceIsNull() {
            addCriterion("substance is null");
            return (Criteria) this;
        }

        public Criteria andSubstanceIsNotNull() {
            addCriterion("substance is not null");
            return (Criteria) this;
        }

        public Criteria andSubstanceEqualTo(String value) {
            addCriterion("substance =", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceNotEqualTo(String value) {
            addCriterion("substance <>", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceGreaterThan(String value) {
            addCriterion("substance >", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceGreaterThanOrEqualTo(String value) {
            addCriterion("substance >=", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceLessThan(String value) {
            addCriterion("substance <", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceLessThanOrEqualTo(String value) {
            addCriterion("substance <=", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceLike(String value) {
            addCriterion("substance like", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceNotLike(String value) {
            addCriterion("substance not like", value, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceIn(List<String> values) {
            addCriterion("substance in", values, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceNotIn(List<String> values) {
            addCriterion("substance not in", values, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceBetween(String value1, String value2) {
            addCriterion("substance between", value1, value2, "substance");
            return (Criteria) this;
        }

        public Criteria andSubstanceNotBetween(String value1, String value2) {
            addCriterion("substance not between", value1, value2, "substance");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
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