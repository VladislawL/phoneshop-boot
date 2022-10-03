package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.search.SearchParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {
    Page<Phone> findPhonesBySearchParameter(SearchParameter searchParameter, Pageable pageable);
    Phone findPhoneById(Long id);
}
