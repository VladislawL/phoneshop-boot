package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.search.SearchParameter;
import com.expertsoft.phoneshop.service.PhoneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;

@Controller
@RequestMapping(PHONES_PATH)
public class PhoneListPageController {

    private static final String PHONE_LIST_PAGE = "phoneListPage";
    private static final String PHONES = "phones";
    private static final String SEARCH_PARAMETER = "searchParameter";
    private static final String NUMBER_OF_PAGES = "numberOfPages";

    @Resource
    private PhoneService phoneService;

    @GetMapping
    public String getPhoneList(Model model, SearchParameter searchParameter, Pageable pageable) {
        Page<Phone> phones = phoneService.findPhonesBySearchParameter(searchParameter, pageable);
        model.addAttribute(PHONES, phoneService.findPhonesBySearchParameter(searchParameter, pageable));
        model.addAttribute(SEARCH_PARAMETER, searchParameter);
        model.addAttribute(NUMBER_OF_PAGES, phones.getTotalPages());

        return PHONE_LIST_PAGE;
    }
}
