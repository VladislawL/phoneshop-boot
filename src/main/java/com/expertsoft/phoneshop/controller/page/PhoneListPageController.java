package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.data.PaginationData;
import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.search.SearchParameter;
import com.expertsoft.phoneshop.service.PaginationService;
import com.expertsoft.phoneshop.service.PhoneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;

@Controller
@RequestMapping(PHONES_PATH)
public class PhoneListPageController {

    private static final String PHONE_LIST_PAGE = "phoneListPage";
    private static final String SEARCH_PARAMETER = "searchParameter";
    private static final String PAGINATION_DATA = "paginationData";

    @Resource
    private PhoneService phoneService;

    @Resource
    private PaginationService paginationService;

    @GetMapping
    public String getPhoneList(Model model, SearchParameter searchParameter, Errors error, Pageable pageable) {
        if (error.hasErrors()) {
            return "redirect:" + PHONES_PATH;
        }

        PaginationData<Phone> paginationData = paginationService.getPhonePaginationData(
                phoneService.findPhonesBySearchParameter(searchParameter, pageable));

        model.addAttribute(SEARCH_PARAMETER, searchParameter);
        model.addAttribute(PAGINATION_DATA, paginationData);

        return PHONE_LIST_PAGE;
    }
}
