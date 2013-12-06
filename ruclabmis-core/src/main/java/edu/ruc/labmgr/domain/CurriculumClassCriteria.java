package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class CurriculumClassCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurriculumClassCriteria() {
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
            addCriterion("cc.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("cc.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("cc.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("cc.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("cc.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cc.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("cc.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("cc.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("cc.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("cc.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("cc.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cc.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNull() {
            addCriterion("cc.curriculum_id is null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNotNull() {
            addCriterion("cc.curriculum_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdEqualTo(Integer value) {
            addCriterion("cc.curriculum_id =", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotEqualTo(Integer value) {
            addCriterion("cc.curriculum_id <>", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThan(Integer value) {
            addCriterion("cc.curriculum_id >", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cc.curriculum_id >=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThan(Integer value) {
            addCriterion("cc.curriculum_id <", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThanOrEqualTo(Integer value) {
            addCriterion("cc.curriculum_id <=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIn(List<Integer> values) {
            addCriterion("cc.curriculum_id in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotIn(List<Integer> values) {
            addCriterion("cc.curriculum_id not in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdBetween(Integer value1, Integer value2) {
            addCriterion("cc.curriculum_id between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cc.curriculum_id not between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("cc.class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("cc.class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("cc.class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("cc.class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("cc.class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("cc.class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("cc.class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("cc.class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("cc.class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("cc.class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("cc.class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("cc.class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("cc.class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("cc.class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassSnIsNull() {
            addCriterion("cc.class_sn is null");
            return (Criteria) this;
        }

        public Criteria andClassSnIsNotNull() {
            addCriterion("cc.class_sn is not null");
            return (Criteria) this;
        }

        public Criteria andClassSnEqualTo(String value) {
            addCriterion("cc.class_sn =", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotEqualTo(String value) {
            addCriterion("cc.class_sn <>", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnGreaterThan(String value) {
            addCriterion("cc.class_sn >", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnGreaterThanOrEqualTo(String value) {
            addCriterion("cc.class_sn >=", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnLessThan(String value) {
            addCriterion("cc.class_sn <", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnLessThanOrEqualTo(String value) {
            addCriterion("cc.class_sn <=", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnLike(String value) {
            addCriterion("cc.class_sn like", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotLike(String value) {
            addCriterion("cc.class_sn not like", value, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnIn(List<String> values) {
            addCriterion("cc.class_sn in", values, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotIn(List<String> values) {
            addCriterion("cc.class_sn not in", values, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnBetween(String value1, String value2) {
            addCriterion("cc.class_sn between", value1, value2, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassSnNotBetween(String value1, String value2) {
            addCriterion("cc.class_sn not between", value1, value2, "classSn");
            return (Criteria) this;
        }

        public Criteria andClassYearIsNull() {
            addCriterion("cc.class_year is null");
            return (Criteria) this;
        }

        public Criteria andClassYearIsNotNull() {
            addCriterion("cc.class_year is not null");
            return (Criteria) this;
        }

        public Criteria andClassYearEqualTo(Byte value) {
            addCriterion("cc.class_year =", value, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearNotEqualTo(Byte value) {
            addCriterion("cc.class_year <>", value, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearGreaterThan(Byte value) {
            addCriterion("cc.class_year >", value, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearGreaterThanOrEqualTo(Byte value) {
            addCriterion("cc.class_year >=", value, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearLessThan(Byte value) {
            addCriterion("cc.class_year <", value, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearLessThanOrEqualTo(Byte value) {
            addCriterion("cc.class_year <=", value, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearIn(List<Byte> values) {
            addCriterion("cc.class_year in", values, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearNotIn(List<Byte> values) {
            addCriterion("cc.class_year not in", values, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearBetween(Byte value1, Byte value2) {
            addCriterion("cc.class_year between", value1, value2, "classYear");
            return (Criteria) this;
        }

        public Criteria andClassYearNotBetween(Byte value1, Byte value2) {
            addCriterion("cc.class_year not between", value1, value2, "classYear");
            return (Criteria) this;
        }

	    public Criteria andUserIdEqual(int tid){
			addCriterion("u.id =", tid, "id");
			return (Criteria) this;
		}
		public Criteria andStudentIdEqual(int tid){
			addCriterion("cs.student_id=", tid, "id");
			return (Criteria) this;
		}
        //以下为连表查询
        public Criteria andJoinCurriculum() {
            addCriterion("cc.curriculum_id = c.id ");
            return (Criteria) this;
        }

        public Criteria andJoinUser() {
            addCriterion("c.teacher_id = u.id ");
            return (Criteria) this;
	}
		public Criteria andJoinClassStudent(){
			addCriterion("cc.id = cs.class_id");
			return (Criteria) this;
		}
		public Criteria andJoinCsUser() {
			addCriterion("cs.student_id = u.id ");
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