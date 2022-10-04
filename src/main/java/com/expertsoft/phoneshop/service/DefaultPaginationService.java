package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.data.PaginationData;
import com.expertsoft.phoneshop.persistence.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class DefaultPaginationService implements PaginationService {
    @Override
    public PaginationData<Phone> getPhonePaginationData(Page<Phone> page) {
        PaginationData<Phone> paginationData = new PaginationData<>();
        paginationData.setPage(page);
        paginationData.setNumberOfPages(page.getTotalPages());
        return paginationData;
    }
}
