package com.expertsoft.phoneshop.data;

import org.springframework.data.domain.Page;

public class PaginationData<T> {
    Page<T> page;
    int numberOfPages;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
