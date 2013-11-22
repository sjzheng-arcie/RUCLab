package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class ClassStudentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassStudentCriteria() {
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
            addCriterion("cs.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("cs.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("cs.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("cs.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("cs.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("cs.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("cs.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("cs.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("cs.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("cs.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cs.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("cs.class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("cs.class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("cs.class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("cs.class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("cs.class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs.class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("cs.class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("cs.class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("cs.class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("cs.class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("cs.class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cs.class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("cs.student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("cs.student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("cs.student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("cs.student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("cs.student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs.student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("cs.student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("cs.student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("cs.student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("cs.student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("cs.student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cs.student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceIsNull() {
            addCriterion("cs.usual_performance is null");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceIsNotNull() {
            addCriterion("cs.usual_performance is not null");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceEqualTo(Short value) {
            addCriterion("cs.usual_performance =", value, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceNotEqualTo(Short value) {
            addCriterion("cs.usual_performance <>", value, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceGreaterThan(Short value) {
            addCriterion("cs.usual_performance >", value, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceGreaterThanOrEqualTo(Short value) {
            addCriterion("cs.usual_performance >=", value, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceLessThan(Short value) {
            addCriterion("cs.usual_performance <", value, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceLessThanOrEqualTo(Short value) {
            addCriterion("cs.usual_performance <=", value, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceIn(List<Short> values) {
            addCriterion("cs.usual_performance in", values, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceNotIn(List<Short> values) {
            addCriterion("cs.usual_performance not in", values, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceBetween(Short value1, Short value2) {
            addCriterion("cs.usual_performance between", value1, value2, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andUsualPerformanceNotBetween(Short value1, Short value2) {
            addCriterion("cs.usual_performance not between", value1, value2, "usualPerformance");
            return (Criteria) this;
        }

        public Criteria andFinalGradeIsNull() {
            addCriterion("cs.final_grade is null");
            return (Criteria) this;
        }

        public Criteria andFinalGradeIsNotNull() {
            addCriterion("cs.final_grade is not null");
            return (Criteria) this;
        }

        public Criteria andFinalGradeEqualTo(Short value) {
            addCriterion("cs.final_grade =", value, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeNotEqualTo(Short value) {
            addCriterion("cs.final_grade <>", value, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeGreaterThan(Short value) {
            addCriterion("cs.final_grade >", value, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeGreaterThanOrEqualTo(Short value) {
            addCriterion("cs.final_grade >=", value, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeLessThan(Short value) {
            addCriterion("cs.final_grade <", value, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeLessThanOrEqualTo(Short value) {
            addCriterion("cs.final_grade <=", value, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeIn(List<Short> values) {
            addCriterion("cs.final_grade in", values, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeNotIn(List<Short> values) {
            addCriterion("cs.final_grade not in", values, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeBetween(Short value1, Short value2) {
            addCriterion("cs.final_grade between", value1, value2, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andFinalGradeNotBetween(Short value1, Short value2) {
            addCriterion("cs.final_grade not between", value1, value2, "finalGrade");
            return (Criteria) this;
        }

        public Criteria andStudentSnEqualTo(String sn) {
            addCriterion("u.sn =", sn, "u.sn");
            return (Criteria) this;
        }

        public Criteria andStudentSnLike(String sn) {
            addCriterion("u.sn like", sn, "u.sn");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String name) {
            addCriterion("u.name =", name, "u.name");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String name) {
            addCriterion("u.name like", name, "u.name");
            return (Criteria) this;
        }

        public Criteria andStudentMajorEqualTo(String major) {
            addCriterion("m.name =", major, "m.name");
            return (Criteria) this;
        }

        public Criteria andStudentMajorLike(String major) {
            addCriterion("m.name like", major, "m.name");
            return (Criteria) this;
        }

        public Criteria andJoinUser() {
            addCriterion("cs.student_id = u.id");
            return (Criteria) this;
        }

        public Criteria andJoinStudent() {
            addCriterion("u.id = st.id");
            return (Criteria) this;
        }

        public Criteria andJoinMajor() {
            addCriterion("u.major_id = m.id");
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