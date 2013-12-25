package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskscoreCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskscoreCriteria() {
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

        public Criteria andTaskidIsNull() {
            addCriterion("taskId is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskId is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(Integer value) {
            addCriterion("taskId =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(Integer value) {
            addCriterion("taskId <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(Integer value) {
            addCriterion("taskId >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskId >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(Integer value) {
            addCriterion("taskId <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(Integer value) {
            addCriterion("taskId <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<Integer> values) {
            addCriterion("taskId in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<Integer> values) {
            addCriterion("taskId not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(Integer value1, Integer value2) {
            addCriterion("taskId between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(Integer value1, Integer value2) {
            addCriterion("taskId not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andMarkeridIsNull() {
            addCriterion("markerId is null");
            return (Criteria) this;
        }

        public Criteria andMarkeridIsNotNull() {
            addCriterion("markerId is not null");
            return (Criteria) this;
        }

        public Criteria andMarkeridEqualTo(Integer value) {
            addCriterion("markerId =", value, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridNotEqualTo(Integer value) {
            addCriterion("markerId <>", value, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridGreaterThan(Integer value) {
            addCriterion("markerId >", value, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("markerId >=", value, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridLessThan(Integer value) {
            addCriterion("markerId <", value, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridLessThanOrEqualTo(Integer value) {
            addCriterion("markerId <=", value, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridIn(List<Integer> values) {
            addCriterion("markerId in", values, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridNotIn(List<Integer> values) {
            addCriterion("markerId not in", values, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridBetween(Integer value1, Integer value2) {
            addCriterion("markerId between", value1, value2, "markerid");
            return (Criteria) this;
        }

        public Criteria andMarkeridNotBetween(Integer value1, Integer value2) {
            addCriterion("markerId not between", value1, value2, "markerid");
            return (Criteria) this;
        }

        public Criteria andOverallscoreIsNull() {
            addCriterion("overallscore is null");
            return (Criteria) this;
        }

        public Criteria andOverallscoreIsNotNull() {
            addCriterion("overallscore is not null");
            return (Criteria) this;
        }

        public Criteria andOverallscoreEqualTo(Integer value) {
            addCriterion("overallscore =", value, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreNotEqualTo(Integer value) {
            addCriterion("overallscore <>", value, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreGreaterThan(Integer value) {
            addCriterion("overallscore >", value, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("overallscore >=", value, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreLessThan(Integer value) {
            addCriterion("overallscore <", value, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreLessThanOrEqualTo(Integer value) {
            addCriterion("overallscore <=", value, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreIn(List<Integer> values) {
            addCriterion("overallscore in", values, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreNotIn(List<Integer> values) {
            addCriterion("overallscore not in", values, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreBetween(Integer value1, Integer value2) {
            addCriterion("overallscore between", value1, value2, "overallscore");
            return (Criteria) this;
        }

        public Criteria andOverallscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("overallscore not between", value1, value2, "overallscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreIsNull() {
            addCriterion("completelyscore is null");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreIsNotNull() {
            addCriterion("completelyscore is not null");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreEqualTo(Integer value) {
            addCriterion("completelyscore =", value, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreNotEqualTo(Integer value) {
            addCriterion("completelyscore <>", value, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreGreaterThan(Integer value) {
            addCriterion("completelyscore >", value, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("completelyscore >=", value, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreLessThan(Integer value) {
            addCriterion("completelyscore <", value, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreLessThanOrEqualTo(Integer value) {
            addCriterion("completelyscore <=", value, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreIn(List<Integer> values) {
            addCriterion("completelyscore in", values, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreNotIn(List<Integer> values) {
            addCriterion("completelyscore not in", values, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreBetween(Integer value1, Integer value2) {
            addCriterion("completelyscore between", value1, value2, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andCompletelyscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("completelyscore not between", value1, value2, "completelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreIsNull() {
            addCriterion("timelyscore is null");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreIsNotNull() {
            addCriterion("timelyscore is not null");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreEqualTo(Integer value) {
            addCriterion("timelyscore =", value, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreNotEqualTo(Integer value) {
            addCriterion("timelyscore <>", value, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreGreaterThan(Integer value) {
            addCriterion("timelyscore >", value, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("timelyscore >=", value, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreLessThan(Integer value) {
            addCriterion("timelyscore <", value, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreLessThanOrEqualTo(Integer value) {
            addCriterion("timelyscore <=", value, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreIn(List<Integer> values) {
            addCriterion("timelyscore in", values, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreNotIn(List<Integer> values) {
            addCriterion("timelyscore not in", values, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreBetween(Integer value1, Integer value2) {
            addCriterion("timelyscore between", value1, value2, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andTimelyscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("timelyscore not between", value1, value2, "timelyscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreIsNull() {
            addCriterion("qualityscore is null");
            return (Criteria) this;
        }

        public Criteria andQualityscoreIsNotNull() {
            addCriterion("qualityscore is not null");
            return (Criteria) this;
        }

        public Criteria andQualityscoreEqualTo(Integer value) {
            addCriterion("qualityscore =", value, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreNotEqualTo(Integer value) {
            addCriterion("qualityscore <>", value, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreGreaterThan(Integer value) {
            addCriterion("qualityscore >", value, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("qualityscore >=", value, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreLessThan(Integer value) {
            addCriterion("qualityscore <", value, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreLessThanOrEqualTo(Integer value) {
            addCriterion("qualityscore <=", value, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreIn(List<Integer> values) {
            addCriterion("qualityscore in", values, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreNotIn(List<Integer> values) {
            addCriterion("qualityscore not in", values, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreBetween(Integer value1, Integer value2) {
            addCriterion("qualityscore between", value1, value2, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andQualityscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("qualityscore not between", value1, value2, "qualityscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreIsNull() {
            addCriterion("spentscore is null");
            return (Criteria) this;
        }

        public Criteria andSpentscoreIsNotNull() {
            addCriterion("spentscore is not null");
            return (Criteria) this;
        }

        public Criteria andSpentscoreEqualTo(Integer value) {
            addCriterion("spentscore =", value, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreNotEqualTo(Integer value) {
            addCriterion("spentscore <>", value, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreGreaterThan(Integer value) {
            addCriterion("spentscore >", value, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("spentscore >=", value, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreLessThan(Integer value) {
            addCriterion("spentscore <", value, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreLessThanOrEqualTo(Integer value) {
            addCriterion("spentscore <=", value, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreIn(List<Integer> values) {
            addCriterion("spentscore in", values, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreNotIn(List<Integer> values) {
            addCriterion("spentscore not in", values, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreBetween(Integer value1, Integer value2) {
            addCriterion("spentscore between", value1, value2, "spentscore");
            return (Criteria) this;
        }

        public Criteria andSpentscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("spentscore not between", value1, value2, "spentscore");
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