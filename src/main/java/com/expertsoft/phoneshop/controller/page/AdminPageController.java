package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.expertsoft.phoneshop.PhoneShopConstants.ADMIN_PATH;

@Controller
@RequestMapping(ADMIN_PATH)
public class AdminPageController {

    private static final String ADMIN_PAGE = "admin/adminPanelPage";
    private static final String USERS = "users";

    @Autowired
    private UserService userService;

    @GetMapping
    private String admin(Model model) {
        model.addAttribute(USERS, userService.findAllUsers());
        return ADMIN_PAGE;
    }
}
