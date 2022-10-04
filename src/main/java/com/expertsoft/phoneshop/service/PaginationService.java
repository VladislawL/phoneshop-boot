package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.data.PaginationData;
import com.expertsoft.phoneshop.persistence.model.Phone;
import org.springframework.data.domain.Page;

public interface PaginationService {
    PaginationData<Phone> getPhonePaginationData(Page<Phone> page);
}
