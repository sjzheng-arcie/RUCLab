package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ViewStoreCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewStoreCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Integer value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Integer value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Integer value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Integer value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Integer> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Integer> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationSnIsNull() {
            addCriterion("application_sn is null");
            return (Criteria) this;
        }

        public Criteria andApplicationSnIsNotNull() {
            addCriterion("application_sn is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationSnEqualTo(String value) {
            addCriterion("application_sn =", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnNotEqualTo(String value) {
            addCriterion("application_sn <>", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnGreaterThan(String value) {
            addCriterion("application_sn >", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnGreaterThanOrEqualTo(String value) {
            addCriterion("application_sn >=", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnLessThan(String value) {
            addCriterion("application_sn <", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnLessThanOrEqualTo(String value) {
            addCriterion("application_sn <=", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnLike(String value) {
            addCriterion("application_sn like", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnNotLike(String value) {
            addCriterion("application_sn not like", value, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnIn(List<String> values) {
            addCriterion("application_sn in", values, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnNotIn(List<String> values) {
            addCriterion("application_sn not in", values, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnBetween(String value1, String value2) {
            addCriterion("application_sn between", value1, value2, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicationSnNotBetween(String value1, String value2) {
            addCriterion("application_sn not between", value1, value2, "applicationSn");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIsNull() {
            addCriterion("applicant_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIsNotNull() {
            addCriterion("applicant_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantIdEqualTo(Integer value) {
            addCriterion("applicant_id =", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotEqualTo(Integer value) {
            addCriterion("applicant_id <>", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdGreaterThan(Integer value) {
            addCriterion("applicant_id >", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("applicant_id >=", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdLessThan(Integer value) {
            addCriterion("applicant_id <", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdLessThanOrEqualTo(Integer value) {
            addCriterion("applicant_id <=", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIn(List<Integer> values) {
            addCriterion("applicant_id in", values, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotIn(List<Integer> values) {
            addCriterion("applicant_id not in", values, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdBetween(Integer value1, Integer value2) {
            addCriterion("applicant_id between", value1, value2, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("applicant_id not between", value1, value2, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIsNull() {
            addCriterion("applicant_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIsNotNull() {
            addCriterion("applicant_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameEqualTo(String value) {
            addCriterion("applicant_name =", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotEqualTo(String value) {
            addCriterion("applicant_name <>", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThan(String value) {
            addCriterion("applicant_name >", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_name >=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThan(String value) {
            addCriterion("applicant_name <", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThanOrEqualTo(String value) {
            addCriterion("applicant_name <=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLike(String value) {
            addCriterion("applicant_name like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotLike(String value) {
            addCriterion("applicant_name not like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIn(List<String> values) {
            addCriterion("applicant_name in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotIn(List<String> values) {
            addCriterion("applicant_name not in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameBetween(String value1, String value2) {
            addCriterion("applicant_name between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotBetween(String value1, String value2) {
            addCriterion("applicant_name not between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdIsNull() {
            addCriterion("applicant_type_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdIsNotNull() {
            addCriterion("applicant_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdEqualTo(Integer value) {
            addCriterion("applicant_type_id =", value, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdNotEqualTo(Integer value) {
            addCriterion("applicant_type_id <>", value, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdGreaterThan(Integer value) {
            addCriterion("applicant_type_id >", value, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("applicant_type_id >=", value, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdLessThan(Integer value) {
            addCriterion("applicant_type_id <", value, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("applicant_type_id <=", value, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdIn(List<Integer> values) {
            addCriterion("applicant_type_id in", values, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdNotIn(List<Integer> values) {
            addCriterion("applicant_type_id not in", values, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("applicant_type_id between", value1, value2, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("applicant_type_id not between", value1, value2, "applicantTypeId");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIsNull() {
            addCriterion("applicant_type is null");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIsNotNull() {
            addCriterion("applicant_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeEqualTo(String value) {
            addCriterion("applicant_type =", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotEqualTo(String value) {
            addCriterion("applicant_type <>", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeGreaterThan(String value) {
            addCriterion("applicant_type >", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_type >=", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeLessThan(String value) {
            addCriterion("applicant_type <", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeLessThanOrEqualTo(String value) {
            addCriterion("applicant_type <=", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeLike(String value) {
            addCriterion("applicant_type like", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotLike(String value) {
            addCriterion("applicant_type not like", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIn(List<String> values) {
            addCriterion("applicant_type in", values, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotIn(List<String> values) {
            addCriterion("applicant_type not in", values, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeBetween(String value1, String value2) {
            addCriterion("applicant_type between", value1, value2, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotBetween(String value1, String value2) {
            addCriterion("applicant_type not between", value1, value2, "applicantType");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNull() {
            addCriterion("approver_id is null");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNotNull() {
            addCriterion("approver_id is not null");
            return (Criteria) this;
        }

        public Criteria andApproverIdEqualTo(Integer value) {
            addCriterion("approver_id =", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotEqualTo(Integer value) {
            addCriterion("approver_id <>", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThan(Integer value) {
            addCriterion("approver_id >", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("approver_id >=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThan(Integer value) {
            addCriterion("approver_id <", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThanOrEqualTo(Integer value) {
            addCriterion("approver_id <=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdIn(List<Integer> values) {
            addCriterion("approver_id in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotIn(List<Integer> values) {
            addCriterion("approver_id not in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdBetween(Integer value1, Integer value2) {
            addCriterion("approver_id between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("approver_id not between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverNameIsNull() {
            addCriterion("approver_name is null");
            return (Criteria) this;
        }

        public Criteria andApproverNameIsNotNull() {
            addCriterion("approver_name is not null");
            return (Criteria) this;
        }

        public Criteria andApproverNameEqualTo(String value) {
            addCriterion("approver_name =", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotEqualTo(String value) {
            addCriterion("approver_name <>", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameGreaterThan(String value) {
            addCriterion("approver_name >", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameGreaterThanOrEqualTo(String value) {
            addCriterion("approver_name >=", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLessThan(String value) {
            addCriterion("approver_name <", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLessThanOrEqualTo(String value) {
            addCriterion("approver_name <=", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLike(String value) {
            addCriterion("approver_name like", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotLike(String value) {
            addCriterion("approver_name not like", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameIn(List<String> values) {
            addCriterion("approver_name in", values, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotIn(List<String> values) {
            addCriterion("approver_name not in", values, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameBetween(String value1, String value2) {
            addCriterion("approver_name between", value1, value2, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotBetween(String value1, String value2) {
            addCriterion("approver_name not between", value1, value2, "approverName");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeIsNull() {
            addCriterion("process_time is null");
            return (Criteria) this;
        }

        public Criteria andProcessTimeIsNotNull() {
            addCriterion("process_time is not null");
            return (Criteria) this;
        }

        public Criteria andProcessTimeEqualTo(Date value) {
            addCriterion("process_time =", value, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeNotEqualTo(Date value) {
            addCriterion("process_time <>", value, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeGreaterThan(Date value) {
            addCriterion("process_time >", value, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("process_time >=", value, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeLessThan(Date value) {
            addCriterion("process_time <", value, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeLessThanOrEqualTo(Date value) {
            addCriterion("process_time <=", value, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeIn(List<Date> values) {
            addCriterion("process_time in", values, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeNotIn(List<Date> values) {
            addCriterion("process_time not in", values, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeBetween(Date value1, Date value2) {
            addCriterion("process_time between", value1, value2, "processTime");
            return (Criteria) this;
        }

        public Criteria andProcessTimeNotBetween(Date value1, Date value2) {
            addCriterion("process_time not between", value1, value2, "processTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdIsNull() {
            addCriterion("application_state_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdIsNotNull() {
            addCriterion("application_state_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdEqualTo(Integer value) {
            addCriterion("application_state_id =", value, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdNotEqualTo(Integer value) {
            addCriterion("application_state_id <>", value, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdGreaterThan(Integer value) {
            addCriterion("application_state_id >", value, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_state_id >=", value, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdLessThan(Integer value) {
            addCriterion("application_state_id <", value, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_state_id <=", value, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdIn(List<Integer> values) {
            addCriterion("application_state_id in", values, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdNotIn(List<Integer> values) {
            addCriterion("application_state_id not in", values, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdBetween(Integer value1, Integer value2) {
            addCriterion("application_state_id between", value1, value2, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_state_id not between", value1, value2, "applicationStateId");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameIsNull() {
            addCriterion("application_state_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameIsNotNull() {
            addCriterion("application_state_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameEqualTo(String value) {
            addCriterion("application_state_name =", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameNotEqualTo(String value) {
            addCriterion("application_state_name <>", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameGreaterThan(String value) {
            addCriterion("application_state_name >", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameGreaterThanOrEqualTo(String value) {
            addCriterion("application_state_name >=", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameLessThan(String value) {
            addCriterion("application_state_name <", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameLessThanOrEqualTo(String value) {
            addCriterion("application_state_name <=", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameLike(String value) {
            addCriterion("application_state_name like", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameNotLike(String value) {
            addCriterion("application_state_name not like", value, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameIn(List<String> values) {
            addCriterion("application_state_name in", values, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameNotIn(List<String> values) {
            addCriterion("application_state_name not in", values, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameBetween(String value1, String value2) {
            addCriterion("application_state_name between", value1, value2, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andApplicationStateNameNotBetween(String value1, String value2) {
            addCriterion("application_state_name not between", value1, value2, "applicationStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(Integer value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(Integer value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(Integer value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(Integer value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<Integer> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<Integer> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(Integer value1, Integer value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnIsNull() {
            addCriterion("equipment_sn is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnIsNotNull() {
            addCriterion("equipment_sn is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnEqualTo(String value) {
            addCriterion("equipment_sn =", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotEqualTo(String value) {
            addCriterion("equipment_sn <>", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnGreaterThan(String value) {
            addCriterion("equipment_sn >", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_sn >=", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnLessThan(String value) {
            addCriterion("equipment_sn <", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnLessThanOrEqualTo(String value) {
            addCriterion("equipment_sn <=", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnLike(String value) {
            addCriterion("equipment_sn like", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotLike(String value) {
            addCriterion("equipment_sn not like", value, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnIn(List<String> values) {
            addCriterion("equipment_sn in", values, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotIn(List<String> values) {
            addCriterion("equipment_sn not in", values, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnBetween(String value1, String value2) {
            addCriterion("equipment_sn between", value1, value2, "equipmentSn");
            return (Criteria) this;
        }

        public Criteria andEquipmentSnNotBetween(String value1, String value2) {
            addCriterion("equipment_sn not between", value1, value2, "equipmentSn");
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Short value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Short value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Short value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Short value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Short value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Short value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Short> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Short> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Short value1, Short value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Short value1, Short value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andModelNumberIsNull() {
            addCriterion("model_number is null");
            return (Criteria) this;
        }

        public Criteria andModelNumberIsNotNull() {
            addCriterion("model_number is not null");
            return (Criteria) this;
        }

        public Criteria andModelNumberEqualTo(String value) {
            addCriterion("model_number =", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberNotEqualTo(String value) {
            addCriterion("model_number <>", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberGreaterThan(String value) {
            addCriterion("model_number >", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberGreaterThanOrEqualTo(String value) {
            addCriterion("model_number >=", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberLessThan(String value) {
            addCriterion("model_number <", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberLessThanOrEqualTo(String value) {
            addCriterion("model_number <=", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberLike(String value) {
            addCriterion("model_number like", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberNotLike(String value) {
            addCriterion("model_number not like", value, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberIn(List<String> values) {
            addCriterion("model_number in", values, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberNotIn(List<String> values) {
            addCriterion("model_number not in", values, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberBetween(String value1, String value2) {
            addCriterion("model_number between", value1, value2, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andModelNumberNotBetween(String value1, String value2) {
            addCriterion("model_number not between", value1, value2, "modelNumber");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Float value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Float value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Float value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Float value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Float value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Float> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Float> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Float value1, Float value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Float value1, Float value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andVenderIsNull() {
            addCriterion("vender is null");
            return (Criteria) this;
        }

        public Criteria andVenderIsNotNull() {
            addCriterion("vender is not null");
            return (Criteria) this;
        }

        public Criteria andVenderEqualTo(String value) {
            addCriterion("vender =", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotEqualTo(String value) {
            addCriterion("vender <>", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderGreaterThan(String value) {
            addCriterion("vender >", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderGreaterThanOrEqualTo(String value) {
            addCriterion("vender >=", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderLessThan(String value) {
            addCriterion("vender <", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderLessThanOrEqualTo(String value) {
            addCriterion("vender <=", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderLike(String value) {
            addCriterion("vender like", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotLike(String value) {
            addCriterion("vender not like", value, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderIn(List<String> values) {
            addCriterion("vender in", values, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotIn(List<String> values) {
            addCriterion("vender not in", values, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderBetween(String value1, String value2) {
            addCriterion("vender between", value1, value2, "vender");
            return (Criteria) this;
        }

        public Criteria andVenderNotBetween(String value1, String value2) {
            addCriterion("vender not between", value1, value2, "vender");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberIsNull() {
            addCriterion("factory_number is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberIsNotNull() {
            addCriterion("factory_number is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberEqualTo(String value) {
            addCriterion("factory_number =", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotEqualTo(String value) {
            addCriterion("factory_number <>", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberGreaterThan(String value) {
            addCriterion("factory_number >", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberGreaterThanOrEqualTo(String value) {
            addCriterion("factory_number >=", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberLessThan(String value) {
            addCriterion("factory_number <", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberLessThanOrEqualTo(String value) {
            addCriterion("factory_number <=", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberLike(String value) {
            addCriterion("factory_number like", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotLike(String value) {
            addCriterion("factory_number not like", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberIn(List<String> values) {
            addCriterion("factory_number in", values, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotIn(List<String> values) {
            addCriterion("factory_number not in", values, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberBetween(String value1, String value2) {
            addCriterion("factory_number between", value1, value2, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotBetween(String value1, String value2) {
            addCriterion("factory_number not between", value1, value2, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNull() {
            addCriterion("manufacture_date is null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNotNull() {
            addCriterion("manufacture_date is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_date =", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_date <>", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThan(Date value) {
            addCriterionForJDBCDate("manufacture_date >", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_date >=", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThan(Date value) {
            addCriterionForJDBCDate("manufacture_date <", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_date <=", value, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIn(List<Date> values) {
            addCriterionForJDBCDate("manufacture_date in", values, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("manufacture_date not in", values, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("manufacture_date between", value1, value2, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("manufacture_date not between", value1, value2, "manufactureDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateIsNull() {
            addCriterion("acquisition_date is null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateIsNotNull() {
            addCriterion("acquisition_date is not null");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateEqualTo(Date value) {
            addCriterionForJDBCDate("acquisition_date =", value, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("acquisition_date <>", value, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("acquisition_date >", value, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("acquisition_date >=", value, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateLessThan(Date value) {
            addCriterionForJDBCDate("acquisition_date <", value, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("acquisition_date <=", value, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateIn(List<Date> values) {
            addCriterionForJDBCDate("acquisition_date in", values, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("acquisition_date not in", values, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("acquisition_date between", value1, value2, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andAcquisitionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("acquisition_date not between", value1, value2, "acquisitionDate");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdIsNull() {
            addCriterion("funding_subject_id is null");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdIsNotNull() {
            addCriterion("funding_subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdEqualTo(Integer value) {
            addCriterion("funding_subject_id =", value, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdNotEqualTo(Integer value) {
            addCriterion("funding_subject_id <>", value, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdGreaterThan(Integer value) {
            addCriterion("funding_subject_id >", value, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("funding_subject_id >=", value, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdLessThan(Integer value) {
            addCriterion("funding_subject_id <", value, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("funding_subject_id <=", value, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdIn(List<Integer> values) {
            addCriterion("funding_subject_id in", values, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdNotIn(List<Integer> values) {
            addCriterion("funding_subject_id not in", values, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("funding_subject_id between", value1, value2, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("funding_subject_id not between", value1, value2, "fundingSubjectId");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIsNull() {
            addCriterion("funding_subject is null");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIsNotNull() {
            addCriterion("funding_subject is not null");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectEqualTo(String value) {
            addCriterion("funding_subject =", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectNotEqualTo(String value) {
            addCriterion("funding_subject <>", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectGreaterThan(String value) {
            addCriterion("funding_subject >", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("funding_subject >=", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectLessThan(String value) {
            addCriterion("funding_subject <", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectLessThanOrEqualTo(String value) {
            addCriterion("funding_subject <=", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectLike(String value) {
            addCriterion("funding_subject like", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectNotLike(String value) {
            addCriterion("funding_subject not like", value, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectIn(List<String> values) {
            addCriterion("funding_subject in", values, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectNotIn(List<String> values) {
            addCriterion("funding_subject not in", values, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectBetween(String value1, String value2) {
            addCriterion("funding_subject between", value1, value2, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andFundingSubjectNotBetween(String value1, String value2) {
            addCriterion("funding_subject not between", value1, value2, "fundingSubject");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdIsNull() {
            addCriterion("use_direction_id is null");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdIsNotNull() {
            addCriterion("use_direction_id is not null");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdEqualTo(Integer value) {
            addCriterion("use_direction_id =", value, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdNotEqualTo(Integer value) {
            addCriterion("use_direction_id <>", value, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdGreaterThan(Integer value) {
            addCriterion("use_direction_id >", value, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_direction_id >=", value, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdLessThan(Integer value) {
            addCriterion("use_direction_id <", value, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("use_direction_id <=", value, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdIn(List<Integer> values) {
            addCriterion("use_direction_id in", values, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdNotIn(List<Integer> values) {
            addCriterion("use_direction_id not in", values, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdBetween(Integer value1, Integer value2) {
            addCriterion("use_direction_id between", value1, value2, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("use_direction_id not between", value1, value2, "useDirectionId");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIsNull() {
            addCriterion("use_direction is null");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIsNotNull() {
            addCriterion("use_direction is not null");
            return (Criteria) this;
        }

        public Criteria andUseDirectionEqualTo(String value) {
            addCriterion("use_direction =", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionNotEqualTo(String value) {
            addCriterion("use_direction <>", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionGreaterThan(String value) {
            addCriterion("use_direction >", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("use_direction >=", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionLessThan(String value) {
            addCriterion("use_direction <", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionLessThanOrEqualTo(String value) {
            addCriterion("use_direction <=", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionLike(String value) {
            addCriterion("use_direction like", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionNotLike(String value) {
            addCriterion("use_direction not like", value, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionIn(List<String> values) {
            addCriterion("use_direction in", values, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionNotIn(List<String> values) {
            addCriterion("use_direction not in", values, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionBetween(String value1, String value2) {
            addCriterion("use_direction between", value1, value2, "useDirection");
            return (Criteria) this;
        }

        public Criteria andUseDirectionNotBetween(String value1, String value2) {
            addCriterion("use_direction not between", value1, value2, "useDirection");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdIsNull() {
            addCriterion("equipment_state_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdIsNotNull() {
            addCriterion("equipment_state_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdEqualTo(Integer value) {
            addCriterion("equipment_state_id =", value, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdNotEqualTo(Integer value) {
            addCriterion("equipment_state_id <>", value, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdGreaterThan(Integer value) {
            addCriterion("equipment_state_id >", value, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("equipment_state_id >=", value, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdLessThan(Integer value) {
            addCriterion("equipment_state_id <", value, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdLessThanOrEqualTo(Integer value) {
            addCriterion("equipment_state_id <=", value, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdIn(List<Integer> values) {
            addCriterion("equipment_state_id in", values, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdNotIn(List<Integer> values) {
            addCriterion("equipment_state_id not in", values, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdBetween(Integer value1, Integer value2) {
            addCriterion("equipment_state_id between", value1, value2, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("equipment_state_id not between", value1, value2, "equipmentStateId");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameIsNull() {
            addCriterion("equipment_state_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameIsNotNull() {
            addCriterion("equipment_state_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameEqualTo(String value) {
            addCriterion("equipment_state_name =", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameNotEqualTo(String value) {
            addCriterion("equipment_state_name <>", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameGreaterThan(String value) {
            addCriterion("equipment_state_name >", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_state_name >=", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameLessThan(String value) {
            addCriterion("equipment_state_name <", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameLessThanOrEqualTo(String value) {
            addCriterion("equipment_state_name <=", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameLike(String value) {
            addCriterion("equipment_state_name like", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameNotLike(String value) {
            addCriterion("equipment_state_name not like", value, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameIn(List<String> values) {
            addCriterion("equipment_state_name in", values, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameNotIn(List<String> values) {
            addCriterion("equipment_state_name not in", values, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameBetween(String value1, String value2) {
            addCriterion("equipment_state_name between", value1, value2, "equipmentStateName");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNameNotBetween(String value1, String value2) {
            addCriterion("equipment_state_name not between", value1, value2, "equipmentStateName");
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