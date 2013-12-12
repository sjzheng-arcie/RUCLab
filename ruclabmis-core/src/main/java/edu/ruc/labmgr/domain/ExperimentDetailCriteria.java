package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class ExperimentDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExperimentDetailCriteria() {
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

        public Criteria andExperimentIdIsNull() {
            addCriterion("experiment_id is null");
            return (Criteria) this;
        }

        public Criteria andExperimentIdIsNotNull() {
            addCriterion("experiment_id is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentIdEqualTo(Integer value) {
            addCriterion("experiment_id =", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotEqualTo(Integer value) {
            addCriterion("experiment_id <>", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdGreaterThan(Integer value) {
            addCriterion("experiment_id >", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("experiment_id >=", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdLessThan(Integer value) {
            addCriterion("experiment_id <", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdLessThanOrEqualTo(Integer value) {
            addCriterion("experiment_id <=", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdIn(List<Integer> values) {
            addCriterion("experiment_id in", values, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotIn(List<Integer> values) {
            addCriterion("experiment_id not in", values, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdBetween(Integer value1, Integer value2) {
            addCriterion("experiment_id between", value1, value2, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("experiment_id not between", value1, value2, "experimentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdIsNull() {
            addCriterion("class_student_id is null");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdIsNotNull() {
            addCriterion("class_student_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdEqualTo(Integer value) {
            addCriterion("class_student_id =", value, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdNotEqualTo(Integer value) {
            addCriterion("class_student_id <>", value, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdGreaterThan(Integer value) {
            addCriterion("class_student_id >", value, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_student_id >=", value, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdLessThan(Integer value) {
            addCriterion("class_student_id <", value, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_student_id <=", value, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdIn(List<Integer> values) {
            addCriterion("class_student_id in", values, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdNotIn(List<Integer> values) {
            addCriterion("class_student_id not in", values, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("class_student_id between", value1, value2, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andClassStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_student_id not between", value1, value2, "classStudentId");
            return (Criteria) this;
        }

        public Criteria andReportPathIsNull() {
            addCriterion("report_path is null");
            return (Criteria) this;
        }

        public Criteria andReportPathIsNotNull() {
            addCriterion("report_path is not null");
            return (Criteria) this;
        }

        public Criteria andReportPathEqualTo(String value) {
            addCriterion("report_path =", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotEqualTo(String value) {
            addCriterion("report_path <>", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathGreaterThan(String value) {
            addCriterion("report_path >", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathGreaterThanOrEqualTo(String value) {
            addCriterion("report_path >=", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLessThan(String value) {
            addCriterion("report_path <", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLessThanOrEqualTo(String value) {
            addCriterion("report_path <=", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathLike(String value) {
            addCriterion("report_path like", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotLike(String value) {
            addCriterion("report_path not like", value, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathIn(List<String> values) {
            addCriterion("report_path in", values, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotIn(List<String> values) {
            addCriterion("report_path not in", values, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathBetween(String value1, String value2) {
            addCriterion("report_path between", value1, value2, "reportPath");
            return (Criteria) this;
        }

        public Criteria andReportPathNotBetween(String value1, String value2) {
            addCriterion("report_path not between", value1, value2, "reportPath");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Short value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Short value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Short value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Short value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Short value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Short> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Short> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Short value1, Short value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Short value1, Short value2) {
            addCriterion("score not between", value1, value2, "score");
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