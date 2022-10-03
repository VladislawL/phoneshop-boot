package com.expertsoft.phoneshop.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("pagination")
public class PaginationProperties {
    private int maxPlpPages;

    public int getMaxPlpPages() {
        return maxPlpPages;
    }

    public void setMaxPlpPages(int maxPlpPages) {
        this.maxPlpPages = maxPlpPages;
    }
}
