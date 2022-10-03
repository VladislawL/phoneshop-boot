package com.expertsoft.phoneshop.search;

import java.math.BigDecimal;

public class SearchParameter {
    private String query;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public BigDecimal getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(BigDecimal fromPrice) {
        this.fromPrice = fromPrice;
    }

    public BigDecimal getToPrice() {
        return toPrice;
    }

    public void setToPrice(BigDecimal toPrice) {
        this.toPrice = toPrice;
    }
}
