package com.lovegis.pojo;

import java.util.ArrayList;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andNickname1IsNull() {
            addCriterion("nickname1 is null");
            return (Criteria) this;
        }

        public Criteria andNickname1IsNotNull() {
            addCriterion("nickname1 is not null");
            return (Criteria) this;
        }

        public Criteria andNickname1EqualTo(String value) {
            addCriterion("nickname1 =", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1NotEqualTo(String value) {
            addCriterion("nickname1 <>", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1GreaterThan(String value) {
            addCriterion("nickname1 >", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1GreaterThanOrEqualTo(String value) {
            addCriterion("nickname1 >=", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1LessThan(String value) {
            addCriterion("nickname1 <", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1LessThanOrEqualTo(String value) {
            addCriterion("nickname1 <=", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1Like(String value) {
            addCriterion("nickname1 like", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1NotLike(String value) {
            addCriterion("nickname1 not like", value, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1In(List<String> values) {
            addCriterion("nickname1 in", values, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1NotIn(List<String> values) {
            addCriterion("nickname1 not in", values, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1Between(String value1, String value2) {
            addCriterion("nickname1 between", value1, value2, "nickname1");
            return (Criteria) this;
        }

        public Criteria andNickname1NotBetween(String value1, String value2) {
            addCriterion("nickname1 not between", value1, value2, "nickname1");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentIsNull() {
            addCriterion("feedbackcontent is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentIsNotNull() {
            addCriterion("feedbackcontent is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentEqualTo(String value) {
            addCriterion("feedbackcontent =", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentNotEqualTo(String value) {
            addCriterion("feedbackcontent <>", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentGreaterThan(String value) {
            addCriterion("feedbackcontent >", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentGreaterThanOrEqualTo(String value) {
            addCriterion("feedbackcontent >=", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentLessThan(String value) {
            addCriterion("feedbackcontent <", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentLessThanOrEqualTo(String value) {
            addCriterion("feedbackcontent <=", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentLike(String value) {
            addCriterion("feedbackcontent like", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentNotLike(String value) {
            addCriterion("feedbackcontent not like", value, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentIn(List<String> values) {
            addCriterion("feedbackcontent in", values, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentNotIn(List<String> values) {
            addCriterion("feedbackcontent not in", values, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentBetween(String value1, String value2) {
            addCriterion("feedbackcontent between", value1, value2, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andFeedbackcontentNotBetween(String value1, String value2) {
            addCriterion("feedbackcontent not between", value1, value2, "feedbackcontent");
            return (Criteria) this;
        }

        public Criteria andAccountimgIsNull() {
            addCriterion("accountimg is null");
            return (Criteria) this;
        }

        public Criteria andAccountimgIsNotNull() {
            addCriterion("accountimg is not null");
            return (Criteria) this;
        }

        public Criteria andAccountimgEqualTo(String value) {
            addCriterion("accountimg =", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgNotEqualTo(String value) {
            addCriterion("accountimg <>", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgGreaterThan(String value) {
            addCriterion("accountimg >", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgGreaterThanOrEqualTo(String value) {
            addCriterion("accountimg >=", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgLessThan(String value) {
            addCriterion("accountimg <", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgLessThanOrEqualTo(String value) {
            addCriterion("accountimg <=", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgLike(String value) {
            addCriterion("accountimg like", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgNotLike(String value) {
            addCriterion("accountimg not like", value, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgIn(List<String> values) {
            addCriterion("accountimg in", values, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgNotIn(List<String> values) {
            addCriterion("accountimg not in", values, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgBetween(String value1, String value2) {
            addCriterion("accountimg between", value1, value2, "accountimg");
            return (Criteria) this;
        }

        public Criteria andAccountimgNotBetween(String value1, String value2) {
            addCriterion("accountimg not between", value1, value2, "accountimg");
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