package com.grope6.design.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndentitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndentitemExample() {
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

        public Criteria andIndentitemidIsNull() {
            addCriterion("indentitemid is null");
            return (Criteria) this;
        }

        public Criteria andIndentitemidIsNotNull() {
            addCriterion("indentitemid is not null");
            return (Criteria) this;
        }

        public Criteria andIndentitemidEqualTo(String value) {
            addCriterion("indentitemid =", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidNotEqualTo(String value) {
            addCriterion("indentitemid <>", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidGreaterThan(String value) {
            addCriterion("indentitemid >", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidGreaterThanOrEqualTo(String value) {
            addCriterion("indentitemid >=", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidLessThan(String value) {
            addCriterion("indentitemid <", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidLessThanOrEqualTo(String value) {
            addCriterion("indentitemid <=", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidLike(String value) {
            addCriterion("indentitemid like", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidNotLike(String value) {
            addCriterion("indentitemid not like", value, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidIn(List<String> values) {
            addCriterion("indentitemid in", values, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidNotIn(List<String> values) {
            addCriterion("indentitemid not in", values, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidBetween(String value1, String value2) {
            addCriterion("indentitemid between", value1, value2, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andIndentitemidNotBetween(String value1, String value2) {
            addCriterion("indentitemid not between", value1, value2, "indentitemid");
            return (Criteria) this;
        }

        public Criteria andBuyeridIsNull() {
            addCriterion("buyerid is null");
            return (Criteria) this;
        }

        public Criteria andBuyeridIsNotNull() {
            addCriterion("buyerid is not null");
            return (Criteria) this;
        }

        public Criteria andBuyeridEqualTo(String value) {
            addCriterion("buyerid =", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotEqualTo(String value) {
            addCriterion("buyerid <>", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridGreaterThan(String value) {
            addCriterion("buyerid >", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridGreaterThanOrEqualTo(String value) {
            addCriterion("buyerid >=", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridLessThan(String value) {
            addCriterion("buyerid <", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridLessThanOrEqualTo(String value) {
            addCriterion("buyerid <=", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridLike(String value) {
            addCriterion("buyerid like", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotLike(String value) {
            addCriterion("buyerid not like", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridIn(List<String> values) {
            addCriterion("buyerid in", values, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotIn(List<String> values) {
            addCriterion("buyerid not in", values, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridBetween(String value1, String value2) {
            addCriterion("buyerid between", value1, value2, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotBetween(String value1, String value2) {
            addCriterion("buyerid not between", value1, value2, "buyerid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(String value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(String value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(String value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(String value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(String value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(String value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLike(String value) {
            addCriterion("goodsid like", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotLike(String value) {
            addCriterion("goodsid not like", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<String> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<String> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(String value1, String value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(String value1, String value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(double value1, double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(double value1, double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeIsNull() {
            addCriterion("indentdatetime is null");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeIsNotNull() {
            addCriterion("indentdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeEqualTo(Date value) {
            addCriterion("indentdatetime =", value, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeNotEqualTo(Date value) {
            addCriterion("indentdatetime <>", value, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeGreaterThan(Date value) {
            addCriterion("indentdatetime >", value, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("indentdatetime >=", value, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeLessThan(Date value) {
            addCriterion("indentdatetime <", value, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("indentdatetime <=", value, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeIn(List<Date> values) {
            addCriterion("indentdatetime in", values, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeNotIn(List<Date> values) {
            addCriterion("indentdatetime not in", values, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeBetween(Date value1, Date value2) {
            addCriterion("indentdatetime between", value1, value2, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andIndentdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("indentdatetime not between", value1, value2, "indentdatetime");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNull() {
            addCriterion("paystate is null");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNotNull() {
            addCriterion("paystate is not null");
            return (Criteria) this;
        }

        public Criteria andPaystateEqualTo(boolean value) {
            addCriterion("paystate =", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotEqualTo(boolean value) {
            addCriterion("paystate <>", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThan(boolean value) {
            addCriterion("paystate >", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThanOrEqualTo(boolean value) {
            addCriterion("paystate >=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThan(boolean value) {
            addCriterion("paystate <", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThanOrEqualTo(boolean value) {
            addCriterion("paystate <=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateIn(List<Boolean> values) {
            addCriterion("paystate in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotIn(List<Boolean> values) {
            addCriterion("paystate not in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateBetween(boolean value1, boolean value2) {
            addCriterion("paystate between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotBetween(boolean value1, boolean value2) {
            addCriterion("paystate not between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andFinishstateIsNull() {
            addCriterion("finishstate is null");
            return (Criteria) this;
        }

        public Criteria andFinishstateIsNotNull() {
            addCriterion("finishstate is not null");
            return (Criteria) this;
        }

        public Criteria andFinishstateEqualTo(boolean value) {
            addCriterion("finishstate =", value, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateNotEqualTo(boolean value) {
            addCriterion("finishstate <>", value, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateGreaterThan(boolean value) {
            addCriterion("finishstate >", value, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateGreaterThanOrEqualTo(boolean value) {
            addCriterion("finishstate >=", value, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateLessThan(boolean value) {
            addCriterion("finishstate <", value, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateLessThanOrEqualTo(boolean value) {
            addCriterion("finishstate <=", value, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateIn(List<Boolean> values) {
            addCriterion("finishstate in", values, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateNotIn(List<Boolean> values) {
            addCriterion("finishstate not in", values, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateBetween(boolean value1, boolean value2) {
            addCriterion("finishstate between", value1, value2, "finishstate");
            return (Criteria) this;
        }

        public Criteria andFinishstateNotBetween(boolean value1, boolean value2) {
            addCriterion("finishstate not between", value1, value2, "finishstate");
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