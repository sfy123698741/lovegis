package com.lovegis.pojo;

import java.util.ArrayList;
import java.util.List;

public class ForumThreadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForumThreadExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Short value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Short value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Short value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Short value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Short value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Short> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Short> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Short value1, Short value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Short value1, Short value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andSortidIsNull() {
            addCriterion("sortid is null");
            return (Criteria) this;
        }

        public Criteria andSortidIsNotNull() {
            addCriterion("sortid is not null");
            return (Criteria) this;
        }

        public Criteria andSortidEqualTo(Short value) {
            addCriterion("sortid =", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotEqualTo(Short value) {
            addCriterion("sortid <>", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThan(Short value) {
            addCriterion("sortid >", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThanOrEqualTo(Short value) {
            addCriterion("sortid >=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThan(Short value) {
            addCriterion("sortid <", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThanOrEqualTo(Short value) {
            addCriterion("sortid <=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidIn(List<Short> values) {
            addCriterion("sortid in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotIn(List<Short> values) {
            addCriterion("sortid not in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidBetween(Short value1, Short value2) {
            addCriterion("sortid between", value1, value2, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotBetween(Short value1, Short value2) {
            addCriterion("sortid not between", value1, value2, "sortid");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorUidIsNull() {
            addCriterion("author_uid is null");
            return (Criteria) this;
        }

        public Criteria andAuthorUidIsNotNull() {
            addCriterion("author_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorUidEqualTo(Integer value) {
            addCriterion("author_uid =", value, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidNotEqualTo(Integer value) {
            addCriterion("author_uid <>", value, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidGreaterThan(Integer value) {
            addCriterion("author_uid >", value, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_uid >=", value, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidLessThan(Integer value) {
            addCriterion("author_uid <", value, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidLessThanOrEqualTo(Integer value) {
            addCriterion("author_uid <=", value, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidIn(List<Integer> values) {
            addCriterion("author_uid in", values, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidNotIn(List<Integer> values) {
            addCriterion("author_uid not in", values, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidBetween(Integer value1, Integer value2) {
            addCriterion("author_uid between", value1, value2, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorUidNotBetween(Integer value1, Integer value2) {
            addCriterion("author_uid not between", value1, value2, "authorUid");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountIsNull() {
            addCriterion("author_account is null");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountIsNotNull() {
            addCriterion("author_account is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountEqualTo(String value) {
            addCriterion("author_account =", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountNotEqualTo(String value) {
            addCriterion("author_account <>", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountGreaterThan(String value) {
            addCriterion("author_account >", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("author_account >=", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountLessThan(String value) {
            addCriterion("author_account <", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountLessThanOrEqualTo(String value) {
            addCriterion("author_account <=", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountLike(String value) {
            addCriterion("author_account like", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountNotLike(String value) {
            addCriterion("author_account not like", value, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountIn(List<String> values) {
            addCriterion("author_account in", values, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountNotIn(List<String> values) {
            addCriterion("author_account not in", values, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountBetween(String value1, String value2) {
            addCriterion("author_account between", value1, value2, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andAuthorAccountNotBetween(String value1, String value2) {
            addCriterion("author_account not between", value1, value2, "authorAccount");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andDatelineIsNull() {
            addCriterion("dateline is null");
            return (Criteria) this;
        }

        public Criteria andDatelineIsNotNull() {
            addCriterion("dateline is not null");
            return (Criteria) this;
        }

        public Criteria andDatelineEqualTo(Long value) {
            addCriterion("dateline =", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineNotEqualTo(Long value) {
            addCriterion("dateline <>", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineGreaterThan(Long value) {
            addCriterion("dateline >", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineGreaterThanOrEqualTo(Long value) {
            addCriterion("dateline >=", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineLessThan(Long value) {
            addCriterion("dateline <", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineLessThanOrEqualTo(Long value) {
            addCriterion("dateline <=", value, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineIn(List<Long> values) {
            addCriterion("dateline in", values, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineNotIn(List<Long> values) {
            addCriterion("dateline not in", values, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineBetween(Long value1, Long value2) {
            addCriterion("dateline between", value1, value2, "dateline");
            return (Criteria) this;
        }

        public Criteria andDatelineNotBetween(Long value1, Long value2) {
            addCriterion("dateline not between", value1, value2, "dateline");
            return (Criteria) this;
        }

        public Criteria andLastpostIsNull() {
            addCriterion("lastpost is null");
            return (Criteria) this;
        }

        public Criteria andLastpostIsNotNull() {
            addCriterion("lastpost is not null");
            return (Criteria) this;
        }

        public Criteria andLastpostEqualTo(Long value) {
            addCriterion("lastpost =", value, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostNotEqualTo(Long value) {
            addCriterion("lastpost <>", value, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostGreaterThan(Long value) {
            addCriterion("lastpost >", value, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostGreaterThanOrEqualTo(Long value) {
            addCriterion("lastpost >=", value, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostLessThan(Long value) {
            addCriterion("lastpost <", value, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostLessThanOrEqualTo(Long value) {
            addCriterion("lastpost <=", value, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostIn(List<Long> values) {
            addCriterion("lastpost in", values, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostNotIn(List<Long> values) {
            addCriterion("lastpost not in", values, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostBetween(Long value1, Long value2) {
            addCriterion("lastpost between", value1, value2, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastpostNotBetween(Long value1, Long value2) {
            addCriterion("lastpost not between", value1, value2, "lastpost");
            return (Criteria) this;
        }

        public Criteria andLastposterIsNull() {
            addCriterion("lastposter is null");
            return (Criteria) this;
        }

        public Criteria andLastposterIsNotNull() {
            addCriterion("lastposter is not null");
            return (Criteria) this;
        }

        public Criteria andLastposterEqualTo(String value) {
            addCriterion("lastposter =", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterNotEqualTo(String value) {
            addCriterion("lastposter <>", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterGreaterThan(String value) {
            addCriterion("lastposter >", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterGreaterThanOrEqualTo(String value) {
            addCriterion("lastposter >=", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterLessThan(String value) {
            addCriterion("lastposter <", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterLessThanOrEqualTo(String value) {
            addCriterion("lastposter <=", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterLike(String value) {
            addCriterion("lastposter like", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterNotLike(String value) {
            addCriterion("lastposter not like", value, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterIn(List<String> values) {
            addCriterion("lastposter in", values, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterNotIn(List<String> values) {
            addCriterion("lastposter not in", values, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterBetween(String value1, String value2) {
            addCriterion("lastposter between", value1, value2, "lastposter");
            return (Criteria) this;
        }

        public Criteria andLastposterNotBetween(String value1, String value2) {
            addCriterion("lastposter not between", value1, value2, "lastposter");
            return (Criteria) this;
        }

        public Criteria andViewsIsNull() {
            addCriterion("views is null");
            return (Criteria) this;
        }

        public Criteria andViewsIsNotNull() {
            addCriterion("views is not null");
            return (Criteria) this;
        }

        public Criteria andViewsEqualTo(Integer value) {
            addCriterion("views =", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotEqualTo(Integer value) {
            addCriterion("views <>", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThan(Integer value) {
            addCriterion("views >", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("views >=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThan(Integer value) {
            addCriterion("views <", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThanOrEqualTo(Integer value) {
            addCriterion("views <=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsIn(List<Integer> values) {
            addCriterion("views in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotIn(List<Integer> values) {
            addCriterion("views not in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsBetween(Integer value1, Integer value2) {
            addCriterion("views between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("views not between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andRepliesIsNull() {
            addCriterion("replies is null");
            return (Criteria) this;
        }

        public Criteria andRepliesIsNotNull() {
            addCriterion("replies is not null");
            return (Criteria) this;
        }

        public Criteria andRepliesEqualTo(Integer value) {
            addCriterion("replies =", value, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesNotEqualTo(Integer value) {
            addCriterion("replies <>", value, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesGreaterThan(Integer value) {
            addCriterion("replies >", value, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesGreaterThanOrEqualTo(Integer value) {
            addCriterion("replies >=", value, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesLessThan(Integer value) {
            addCriterion("replies <", value, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesLessThanOrEqualTo(Integer value) {
            addCriterion("replies <=", value, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesIn(List<Integer> values) {
            addCriterion("replies in", values, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesNotIn(List<Integer> values) {
            addCriterion("replies not in", values, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesBetween(Integer value1, Integer value2) {
            addCriterion("replies between", value1, value2, "replies");
            return (Criteria) this;
        }

        public Criteria andRepliesNotBetween(Integer value1, Integer value2) {
            addCriterion("replies not between", value1, value2, "replies");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(Byte value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(Byte value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(Byte value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(Byte value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(Byte value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(Byte value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<Byte> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<Byte> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(Byte value1, Byte value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(Byte value1, Byte value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andClosedIsNull() {
            addCriterion("closed is null");
            return (Criteria) this;
        }

        public Criteria andClosedIsNotNull() {
            addCriterion("closed is not null");
            return (Criteria) this;
        }

        public Criteria andClosedEqualTo(Integer value) {
            addCriterion("closed =", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotEqualTo(Integer value) {
            addCriterion("closed <>", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedGreaterThan(Integer value) {
            addCriterion("closed >", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedGreaterThanOrEqualTo(Integer value) {
            addCriterion("closed >=", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedLessThan(Integer value) {
            addCriterion("closed <", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedLessThanOrEqualTo(Integer value) {
            addCriterion("closed <=", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedIn(List<Integer> values) {
            addCriterion("closed in", values, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotIn(List<Integer> values) {
            addCriterion("closed not in", values, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedBetween(Integer value1, Integer value2) {
            addCriterion("closed between", value1, value2, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotBetween(Integer value1, Integer value2) {
            addCriterion("closed not between", value1, value2, "closed");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNull() {
            addCriterion("display is null");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNotNull() {
            addCriterion("display is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayEqualTo(Byte value) {
            addCriterion("display =", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotEqualTo(Byte value) {
            addCriterion("display <>", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThan(Byte value) {
            addCriterion("display >", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThanOrEqualTo(Byte value) {
            addCriterion("display >=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThan(Byte value) {
            addCriterion("display <", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThanOrEqualTo(Byte value) {
            addCriterion("display <=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayIn(List<Byte> values) {
            addCriterion("display in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotIn(List<Byte> values) {
            addCriterion("display not in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayBetween(Byte value1, Byte value2) {
            addCriterion("display between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotBetween(Byte value1, Byte value2) {
            addCriterion("display not between", value1, value2, "display");
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