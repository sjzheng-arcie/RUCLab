package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BbsTopicCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BbsTopicCriteria() {
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

        public Criteria andSessionidIsNull() {
            addCriterion("sessionId is null");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNotNull() {
            addCriterion("sessionId is not null");
            return (Criteria) this;
        }

        public Criteria andSessionidEqualTo(Integer value) {
            addCriterion("sessionId =", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotEqualTo(Integer value) {
            addCriterion("sessionId <>", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThan(Integer value) {
            addCriterion("sessionId >", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sessionId >=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThan(Integer value) {
            addCriterion("sessionId <", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThanOrEqualTo(Integer value) {
            addCriterion("sessionId <=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidIn(List<Integer> values) {
            addCriterion("sessionId in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotIn(List<Integer> values) {
            addCriterion("sessionId not in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidBetween(Integer value1, Integer value2) {
            addCriterion("sessionId between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotBetween(Integer value1, Integer value2) {
            addCriterion("sessionId not between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andClickcountIsNull() {
            addCriterion("clickCount is null");
            return (Criteria) this;
        }

        public Criteria andClickcountIsNotNull() {
            addCriterion("clickCount is not null");
            return (Criteria) this;
        }

        public Criteria andClickcountEqualTo(Integer value) {
            addCriterion("clickCount =", value, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountNotEqualTo(Integer value) {
            addCriterion("clickCount <>", value, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountGreaterThan(Integer value) {
            addCriterion("clickCount >", value, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickCount >=", value, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountLessThan(Integer value) {
            addCriterion("clickCount <", value, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountLessThanOrEqualTo(Integer value) {
            addCriterion("clickCount <=", value, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountIn(List<Integer> values) {
            addCriterion("clickCount in", values, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountNotIn(List<Integer> values) {
            addCriterion("clickCount not in", values, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountBetween(Integer value1, Integer value2) {
            addCriterion("clickCount between", value1, value2, "clickcount");
            return (Criteria) this;
        }

        public Criteria andClickcountNotBetween(Integer value1, Integer value2) {
            addCriterion("clickCount not between", value1, value2, "clickcount");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andReplycountIsNull() {
            addCriterion("replycount is null");
            return (Criteria) this;
        }

        public Criteria andReplycountIsNotNull() {
            addCriterion("replycount is not null");
            return (Criteria) this;
        }

        public Criteria andReplycountEqualTo(Integer value) {
            addCriterion("replycount =", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotEqualTo(Integer value) {
            addCriterion("replycount <>", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountGreaterThan(Integer value) {
            addCriterion("replycount >", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountGreaterThanOrEqualTo(Integer value) {
            addCriterion("replycount >=", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountLessThan(Integer value) {
            addCriterion("replycount <", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountLessThanOrEqualTo(Integer value) {
            addCriterion("replycount <=", value, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountIn(List<Integer> values) {
            addCriterion("replycount in", values, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotIn(List<Integer> values) {
            addCriterion("replycount not in", values, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountBetween(Integer value1, Integer value2) {
            addCriterion("replycount between", value1, value2, "replycount");
            return (Criteria) this;
        }

        public Criteria andReplycountNotBetween(Integer value1, Integer value2) {
            addCriterion("replycount not between", value1, value2, "replycount");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(Integer value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(Integer value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(Integer value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(Integer value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(Integer value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(Integer value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<Integer> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<Integer> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(Integer value1, Integer value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(Integer value1, Integer value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentsIsNull() {
            addCriterion("contents is null");
            return (Criteria) this;
        }

        public Criteria andContentsIsNotNull() {
            addCriterion("contents is not null");
            return (Criteria) this;
        }

        public Criteria andContentsEqualTo(Integer value) {
            addCriterion("contents =", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsNotEqualTo(Integer value) {
            addCriterion("contents <>", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsGreaterThan(Integer value) {
            addCriterion("contents >", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsGreaterThanOrEqualTo(Integer value) {
            addCriterion("contents >=", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsLessThan(Integer value) {
            addCriterion("contents <", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsLessThanOrEqualTo(Integer value) {
            addCriterion("contents <=", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsIn(List<Integer> values) {
            addCriterion("contents in", values, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsNotIn(List<Integer> values) {
            addCriterion("contents not in", values, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsBetween(Integer value1, Integer value2) {
            addCriterion("contents between", value1, value2, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsNotBetween(Integer value1, Integer value2) {
            addCriterion("contents not between", value1, value2, "contents");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTime not between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserIsNull() {
            addCriterion("lastRepliedUser is null");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserIsNotNull() {
            addCriterion("lastRepliedUser is not null");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserEqualTo(Integer value) {
            addCriterion("lastRepliedUser =", value, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserNotEqualTo(Integer value) {
            addCriterion("lastRepliedUser <>", value, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserGreaterThan(Integer value) {
            addCriterion("lastRepliedUser >", value, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastRepliedUser >=", value, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserLessThan(Integer value) {
            addCriterion("lastRepliedUser <", value, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserLessThanOrEqualTo(Integer value) {
            addCriterion("lastRepliedUser <=", value, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserIn(List<Integer> values) {
            addCriterion("lastRepliedUser in", values, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserNotIn(List<Integer> values) {
            addCriterion("lastRepliedUser not in", values, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserBetween(Integer value1, Integer value2) {
            addCriterion("lastRepliedUser between", value1, value2, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastreplieduserNotBetween(Integer value1, Integer value2) {
            addCriterion("lastRepliedUser not between", value1, value2, "lastreplieduser");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeIsNull() {
            addCriterion("lastRepliedTime is null");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeIsNotNull() {
            addCriterion("lastRepliedTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeEqualTo(Date value) {
            addCriterion("lastRepliedTime =", value, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeNotEqualTo(Date value) {
            addCriterion("lastRepliedTime <>", value, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeGreaterThan(Date value) {
            addCriterion("lastRepliedTime >", value, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastRepliedTime >=", value, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeLessThan(Date value) {
            addCriterion("lastRepliedTime <", value, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeLessThanOrEqualTo(Date value) {
            addCriterion("lastRepliedTime <=", value, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeIn(List<Date> values) {
            addCriterion("lastRepliedTime in", values, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeNotIn(List<Date> values) {
            addCriterion("lastRepliedTime not in", values, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeBetween(Date value1, Date value2) {
            addCriterion("lastRepliedTime between", value1, value2, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andLastrepliedtimeNotBetween(Date value1, Date value2) {
            addCriterion("lastRepliedTime not between", value1, value2, "lastrepliedtime");
            return (Criteria) this;
        }

        public Criteria andIstopIsNull() {
            addCriterion("isTop is null");
            return (Criteria) this;
        }

        public Criteria andIstopIsNotNull() {
            addCriterion("isTop is not null");
            return (Criteria) this;
        }

        public Criteria andIstopEqualTo(Boolean value) {
            addCriterion("isTop =", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotEqualTo(Boolean value) {
            addCriterion("isTop <>", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThan(Boolean value) {
            addCriterion("isTop >", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isTop >=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThan(Boolean value) {
            addCriterion("isTop <", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThanOrEqualTo(Boolean value) {
            addCriterion("isTop <=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopIn(List<Boolean> values) {
            addCriterion("isTop in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotIn(List<Boolean> values) {
            addCriterion("isTop not in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopBetween(Boolean value1, Boolean value2) {
            addCriterion("isTop between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isTop not between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIsclosedIsNull() {
            addCriterion("isClosed is null");
            return (Criteria) this;
        }

        public Criteria andIsclosedIsNotNull() {
            addCriterion("isClosed is not null");
            return (Criteria) this;
        }

        public Criteria andIsclosedEqualTo(Boolean value) {
            addCriterion("isClosed =", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedNotEqualTo(Boolean value) {
            addCriterion("isClosed <>", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedGreaterThan(Boolean value) {
            addCriterion("isClosed >", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isClosed >=", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedLessThan(Boolean value) {
            addCriterion("isClosed <", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedLessThanOrEqualTo(Boolean value) {
            addCriterion("isClosed <=", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedIn(List<Boolean> values) {
            addCriterion("isClosed in", values, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedNotIn(List<Boolean> values) {
            addCriterion("isClosed not in", values, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedBetween(Boolean value1, Boolean value2) {
            addCriterion("isClosed between", value1, value2, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isClosed not between", value1, value2, "isclosed");
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