package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskCriteria() {
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

        public Criteria andIfcompletedIsNull() {
            addCriterion("ifCompleted is null");
            return (Criteria) this;
        }

        public Criteria andIfcompletedIsNotNull() {
            addCriterion("ifCompleted is not null");
            return (Criteria) this;
        }

        public Criteria andIfcompletedEqualTo(Boolean value) {
            addCriterion("ifCompleted =", value, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedNotEqualTo(Boolean value) {
            addCriterion("ifCompleted <>", value, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedGreaterThan(Boolean value) {
            addCriterion("ifCompleted >", value, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ifCompleted >=", value, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedLessThan(Boolean value) {
            addCriterion("ifCompleted <", value, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedLessThanOrEqualTo(Boolean value) {
            addCriterion("ifCompleted <=", value, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedIn(List<Boolean> values) {
            addCriterion("ifCompleted in", values, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedNotIn(List<Boolean> values) {
            addCriterion("ifCompleted not in", values, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedBetween(Boolean value1, Boolean value2) {
            addCriterion("ifCompleted between", value1, value2, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andIfcompletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ifCompleted not between", value1, value2, "ifcompleted");
            return (Criteria) this;
        }

        public Criteria andAnnexnameIsNull() {
            addCriterion("annexName is null");
            return (Criteria) this;
        }

        public Criteria andAnnexnameIsNotNull() {
            addCriterion("annexName is not null");
            return (Criteria) this;
        }

        public Criteria andAnnexnameEqualTo(String value) {
            addCriterion("annexName =", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameNotEqualTo(String value) {
            addCriterion("annexName <>", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameGreaterThan(String value) {
            addCriterion("annexName >", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameGreaterThanOrEqualTo(String value) {
            addCriterion("annexName >=", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameLessThan(String value) {
            addCriterion("annexName <", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameLessThanOrEqualTo(String value) {
            addCriterion("annexName <=", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameLike(String value) {
            addCriterion("annexName like", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameNotLike(String value) {
            addCriterion("annexName not like", value, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameIn(List<String> values) {
            addCriterion("annexName in", values, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameNotIn(List<String> values) {
            addCriterion("annexName not in", values, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameBetween(String value1, String value2) {
            addCriterion("annexName between", value1, value2, "annexname");
            return (Criteria) this;
        }

        public Criteria andAnnexnameNotBetween(String value1, String value2) {
            addCriterion("annexName not between", value1, value2, "annexname");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andManageridIsNull() {
            addCriterion("managerId is null");
            return (Criteria) this;
        }

        public Criteria andManageridIsNotNull() {
            addCriterion("managerId is not null");
            return (Criteria) this;
        }

        public Criteria andManageridEqualTo(Integer value) {
            addCriterion("managerId =", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotEqualTo(Integer value) {
            addCriterion("managerId <>", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThan(Integer value) {
            addCriterion("managerId >", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerId >=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThan(Integer value) {
            addCriterion("managerId <", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThanOrEqualTo(Integer value) {
            addCriterion("managerId <=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridIn(List<Integer> values) {
            addCriterion("managerId in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotIn(List<Integer> values) {
            addCriterion("managerId not in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridBetween(Integer value1, Integer value2) {
            addCriterion("managerId between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotBetween(Integer value1, Integer value2) {
            addCriterion("managerId not between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andAnnexpathIsNull() {
            addCriterion("annexpath is null");
            return (Criteria) this;
        }

        public Criteria andAnnexpathIsNotNull() {
            addCriterion("annexpath is not null");
            return (Criteria) this;
        }

        public Criteria andAnnexpathEqualTo(String value) {
            addCriterion("annexpath =", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathNotEqualTo(String value) {
            addCriterion("annexpath <>", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathGreaterThan(String value) {
            addCriterion("annexpath >", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathGreaterThanOrEqualTo(String value) {
            addCriterion("annexpath >=", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathLessThan(String value) {
            addCriterion("annexpath <", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathLessThanOrEqualTo(String value) {
            addCriterion("annexpath <=", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathLike(String value) {
            addCriterion("annexpath like", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathNotLike(String value) {
            addCriterion("annexpath not like", value, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathIn(List<String> values) {
            addCriterion("annexpath in", values, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathNotIn(List<String> values) {
            addCriterion("annexpath not in", values, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathBetween(String value1, String value2) {
            addCriterion("annexpath between", value1, value2, "annexpath");
            return (Criteria) this;
        }

        public Criteria andAnnexpathNotBetween(String value1, String value2) {
            addCriterion("annexpath not between", value1, value2, "annexpath");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNull() {
            addCriterion("taskName is null");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNotNull() {
            addCriterion("taskName is not null");
            return (Criteria) this;
        }

        public Criteria andTasknameEqualTo(String value) {
            addCriterion("taskName =", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotEqualTo(String value) {
            addCriterion("taskName <>", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThan(String value) {
            addCriterion("taskName >", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThanOrEqualTo(String value) {
            addCriterion("taskName >=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThan(String value) {
            addCriterion("taskName <", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThanOrEqualTo(String value) {
            addCriterion("taskName <=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLike(String value) {
            addCriterion("taskName like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotLike(String value) {
            addCriterion("taskName not like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameIn(List<String> values) {
            addCriterion("taskName in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotIn(List<String> values) {
            addCriterion("taskName not in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameBetween(String value1, String value2) {
            addCriterion("taskName between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotBetween(String value1, String value2) {
            addCriterion("taskName not between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andFinishdateIsNull() {
            addCriterion("finishDate is null");
            return (Criteria) this;
        }

        public Criteria andFinishdateIsNotNull() {
            addCriterion("finishDate is not null");
            return (Criteria) this;
        }

        public Criteria andFinishdateEqualTo(Date value) {
            addCriterion("finishDate =", value, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateNotEqualTo(Date value) {
            addCriterion("finishDate <>", value, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateGreaterThan(Date value) {
            addCriterion("finishDate >", value, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateGreaterThanOrEqualTo(Date value) {
            addCriterion("finishDate >=", value, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateLessThan(Date value) {
            addCriterion("finishDate <", value, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateLessThanOrEqualTo(Date value) {
            addCriterion("finishDate <=", value, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateIn(List<Date> values) {
            addCriterion("finishDate in", values, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateNotIn(List<Date> values) {
            addCriterion("finishDate not in", values, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateBetween(Date value1, Date value2) {
            addCriterion("finishDate between", value1, value2, "finishdate");
            return (Criteria) this;
        }

        public Criteria andFinishdateNotBetween(Date value1, Date value2) {
            addCriterion("finishDate not between", value1, value2, "finishdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateIsNull() {
            addCriterion("limitDate is null");
            return (Criteria) this;
        }

        public Criteria andLimitdateIsNotNull() {
            addCriterion("limitDate is not null");
            return (Criteria) this;
        }

        public Criteria andLimitdateEqualTo(Date value) {
            addCriterion("limitDate =", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateNotEqualTo(Date value) {
            addCriterion("limitDate <>", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateGreaterThan(Date value) {
            addCriterion("limitDate >", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateGreaterThanOrEqualTo(Date value) {
            addCriterion("limitDate >=", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateLessThan(Date value) {
            addCriterion("limitDate <", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateLessThanOrEqualTo(Date value) {
            addCriterion("limitDate <=", value, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateIn(List<Date> values) {
            addCriterion("limitDate in", values, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateNotIn(List<Date> values) {
            addCriterion("limitDate not in", values, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateBetween(Date value1, Date value2) {
            addCriterion("limitDate between", value1, value2, "limitdate");
            return (Criteria) this;
        }

        public Criteria andLimitdateNotBetween(Date value1, Date value2) {
            addCriterion("limitDate not between", value1, value2, "limitdate");
            return (Criteria) this;
        }

        public Criteria andCompletionIsNull() {
            addCriterion("completion is null");
            return (Criteria) this;
        }

        public Criteria andCompletionIsNotNull() {
            addCriterion("completion is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionEqualTo(String value) {
            addCriterion("completion =", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotEqualTo(String value) {
            addCriterion("completion <>", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionGreaterThan(String value) {
            addCriterion("completion >", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionGreaterThanOrEqualTo(String value) {
            addCriterion("completion >=", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLessThan(String value) {
            addCriterion("completion <", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLessThanOrEqualTo(String value) {
            addCriterion("completion <=", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLike(String value) {
            addCriterion("completion like", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotLike(String value) {
            addCriterion("completion not like", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionIn(List<String> values) {
            addCriterion("completion in", values, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotIn(List<String> values) {
            addCriterion("completion not in", values, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionBetween(String value1, String value2) {
            addCriterion("completion between", value1, value2, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotBetween(String value1, String value2) {
            addCriterion("completion not between", value1, value2, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletelyIsNull() {
            addCriterion("completely is null");
            return (Criteria) this;
        }

        public Criteria andCompletelyIsNotNull() {
            addCriterion("completely is not null");
            return (Criteria) this;
        }

        public Criteria andCompletelyEqualTo(Integer value) {
            addCriterion("completely =", value, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyNotEqualTo(Integer value) {
            addCriterion("completely <>", value, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyGreaterThan(Integer value) {
            addCriterion("completely >", value, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyGreaterThanOrEqualTo(Integer value) {
            addCriterion("completely >=", value, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyLessThan(Integer value) {
            addCriterion("completely <", value, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyLessThanOrEqualTo(Integer value) {
            addCriterion("completely <=", value, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyIn(List<Integer> values) {
            addCriterion("completely in", values, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyNotIn(List<Integer> values) {
            addCriterion("completely not in", values, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyBetween(Integer value1, Integer value2) {
            addCriterion("completely between", value1, value2, "completely");
            return (Criteria) this;
        }

        public Criteria andCompletelyNotBetween(Integer value1, Integer value2) {
            addCriterion("completely not between", value1, value2, "completely");
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

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andIfscoredIsNull() {
            addCriterion("ifscored is null");
            return (Criteria) this;
        }

        public Criteria andIfscoredIsNotNull() {
            addCriterion("ifscored is not null");
            return (Criteria) this;
        }

        public Criteria andIfscoredEqualTo(Boolean value) {
            addCriterion("ifscored =", value, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredNotEqualTo(Boolean value) {
            addCriterion("ifscored <>", value, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredGreaterThan(Boolean value) {
            addCriterion("ifscored >", value, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ifscored >=", value, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredLessThan(Boolean value) {
            addCriterion("ifscored <", value, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredLessThanOrEqualTo(Boolean value) {
            addCriterion("ifscored <=", value, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredIn(List<Boolean> values) {
            addCriterion("ifscored in", values, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredNotIn(List<Boolean> values) {
            addCriterion("ifscored not in", values, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredBetween(Boolean value1, Boolean value2) {
            addCriterion("ifscored between", value1, value2, "ifscored");
            return (Criteria) this;
        }

        public Criteria andIfscoredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ifscored not between", value1, value2, "ifscored");
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