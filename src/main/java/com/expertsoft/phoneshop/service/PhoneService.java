package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.persistence.repository.PhoneRepository;
import com.expertsoft.phoneshop.properties.PaginationProperties;
import com.expertsoft.phoneshop.search.SearchParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class PhoneService {

    @Resource
    private PhoneRepository phoneRepository;

    @Resource
    private PaginationProperties paginationProperties;

    public Page<Phone> findPhonesBySearchParameter(SearchParameter searchParameter, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), paginationProperties.getMaxPlpPages(),
                pageable.getSort());

        return phoneRepository.findPhonesByQueryAndPrice(getQuery(searchParameter),
                getStarPrice(searchParameter), getEndPrice(searchParameter), pageable);
    }

    private String getQuery(SearchParameter searchParameter) {
        if (searchParameter.getQuery() == null) {
            return "";
        }
        return searchParameter.getQuery();
    }

    private BigDecimal getStarPrice(SearchParameter searchParameter) {
        if (searchParameter.getFromPrice() == null) {
            return BigDecimal.ZERO;
        }
        return searchParameter.getFromPrice();
    }

    private BigDecimal getEndPrice(SearchParameter searchParameter) {
        if (searchParameter.getToPrice() == null) {
            return BigDecimal.valueOf(Integer.MAX_VALUE);
        }
        return searchParameter.getToPrice();
    }
}
