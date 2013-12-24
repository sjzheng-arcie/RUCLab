package edu.ruc.labmgr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RelatedResourcesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelatedResourcesCriteria() {
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

        public Criteria andCurriculumIdIsNull() {
            addCriterion("curriculum_id is null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNotNull() {
            addCriterion("curriculum_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdEqualTo(Integer value) {
            addCriterion("curriculum_id =", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotEqualTo(Integer value) {
            addCriterion("curriculum_id <>", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThan(Integer value) {
            addCriterion("curriculum_id >", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id >=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThan(Integer value) {
            addCriterion("curriculum_id <", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id <=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIn(List<Integer> values) {
            addCriterion("curriculum_id in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotIn(List<Integer> values) {
            addCriterion("curriculum_id not in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id not between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("resource_type is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(Integer value) {
            addCriterion("resource_type =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(Integer value) {
            addCriterion("resource_type <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(Integer value) {
            addCriterion("resource_type >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_type >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(Integer value) {
            addCriterion("resource_type <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("resource_type <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<Integer> values) {
            addCriterion("resource_type in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<Integer> values) {
            addCriterion("resource_type not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("resource_type between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_type not between", value1, value2, "resourceType");
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

        public Criteria andDocumentNameIsNull() {
            addCriterion("documentName is null");
            return (Criteria) this;
        }

        public Criteria andDocumentNameIsNotNull() {
            addCriterion("documentName is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentNameEqualTo(String value) {
            addCriterion("documentName =", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameNotEqualTo(String value) {
            addCriterion("documentName <>", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameGreaterThan(String value) {
            addCriterion("documentName >", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameGreaterThanOrEqualTo(String value) {
            addCriterion("documentName >=", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameLessThan(String value) {
            addCriterion("documentName <", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameLessThanOrEqualTo(String value) {
            addCriterion("documentName <=", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameLike(String value) {
            addCriterion("documentName like", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameNotLike(String value) {
            addCriterion("documentName not like", value, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameIn(List<String> values) {
            addCriterion("documentName in", values, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameNotIn(List<String> values) {
            addCriterion("documentName not in", values, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameBetween(String value1, String value2) {
            addCriterion("documentName between", value1, value2, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentNameNotBetween(String value1, String value2) {
            addCriterion("documentName not between", value1, value2, "documentName");
            return (Criteria) this;
        }

        public Criteria andDocumentPathIsNull() {
            addCriterion("documentPath is null");
            return (Criteria) this;
        }

        public Criteria andDocumentPathIsNotNull() {
            addCriterion("documentPath is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentPathEqualTo(String value) {
            addCriterion("documentPath =", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotEqualTo(String value) {
            addCriterion("documentPath <>", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathGreaterThan(String value) {
            addCriterion("documentPath >", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathGreaterThanOrEqualTo(String value) {
            addCriterion("documentPath >=", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathLessThan(String value) {
            addCriterion("documentPath <", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathLessThanOrEqualTo(String value) {
            addCriterion("documentPath <=", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathLike(String value) {
            addCriterion("documentPath like", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotLike(String value) {
            addCriterion("documentPath not like", value, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathIn(List<String> values) {
            addCriterion("documentPath in", values, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotIn(List<String> values) {
            addCriterion("documentPath not in", values, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathBetween(String value1, String value2) {
            addCriterion("documentPath between", value1, value2, "documentPath");
            return (Criteria) this;
        }

        public Criteria andDocumentPathNotBetween(String value1, String value2) {
            addCriterion("documentPath not between", value1, value2, "documentPath");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("upload_date is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("upload_date is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterionForJDBCDate("upload_date =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("upload_date <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterionForJDBCDate("upload_date >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("upload_date >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterionForJDBCDate("upload_date <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("upload_date <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterionForJDBCDate("upload_date in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("upload_date not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("upload_date between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("upload_date not between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadPersonIsNull() {
            addCriterion("upload_person is null");
            return (Criteria) this;
        }

        public Criteria andUploadPersonIsNotNull() {
            addCriterion("upload_person is not null");
            return (Criteria) this;
        }

        public Criteria andUploadPersonEqualTo(Integer value) {
            addCriterion("upload_person =", value, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonNotEqualTo(Integer value) {
            addCriterion("upload_person <>", value, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonGreaterThan(Integer value) {
            addCriterion("upload_person >", value, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_person >=", value, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonLessThan(Integer value) {
            addCriterion("upload_person <", value, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonLessThanOrEqualTo(Integer value) {
            addCriterion("upload_person <=", value, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonIn(List<Integer> values) {
            addCriterion("upload_person in", values, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonNotIn(List<Integer> values) {
            addCriterion("upload_person not in", values, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonBetween(Integer value1, Integer value2) {
            addCriterion("upload_person between", value1, value2, "uploadPerson");
            return (Criteria) this;
        }

        public Criteria andUploadPersonNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_person not between", value1, value2, "uploadPerson");
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

        public Criteria andDownloadLimitIsNull() {
            addCriterion("download_limit is null");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitIsNotNull() {
            addCriterion("download_limit is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitEqualTo(Boolean value) {
            addCriterion("download_limit =", value, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitNotEqualTo(Boolean value) {
            addCriterion("download_limit <>", value, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitGreaterThan(Boolean value) {
            addCriterion("download_limit >", value, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitGreaterThanOrEqualTo(Boolean value) {
            addCriterion("download_limit >=", value, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitLessThan(Boolean value) {
            addCriterion("download_limit <", value, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitLessThanOrEqualTo(Boolean value) {
            addCriterion("download_limit <=", value, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitIn(List<Boolean> values) {
            addCriterion("download_limit in", values, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitNotIn(List<Boolean> values) {
            addCriterion("download_limit not in", values, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitBetween(Boolean value1, Boolean value2) {
            addCriterion("download_limit between", value1, value2, "downloadLimit");
            return (Criteria) this;
        }

        public Criteria andDownloadLimitNotBetween(Boolean value1, Boolean value2) {
            addCriterion("download_limit not between", value1, value2, "downloadLimit");
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