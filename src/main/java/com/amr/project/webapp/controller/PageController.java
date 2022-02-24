package com.amr.project.webapp.controller;

import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.converter.UserMapper;
import com.amr.project.model.entity.Category;
import com.amr.project.service.abstracts.ItemReadWriteService;
import com.amr.project.service.abstracts.ShopReadWriteService;
import com.amr.project.service.abstracts.UserReadWriteService;
import com.amr.project.service.impl.ReadWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {
    private final ItemReadWriteService itemService;
    private final UserReadWriteService userService;
    private final ShopReadWriteService shopService;
    private final ReadWriteServiceImpl<Category, Long> categoryService;

    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;
    private final UserMapper userMapper;
    private final CategoryMapper categoryMapper;

    @GetMapping("/")
    public String mainPage(Model model, Authentication authentication) {
        model.addAttribute("authorizedUser", (authentication != null) ?
                userMapper.toDto(userService.getUserByUsername(((UserDetails)authentication.getPrincipal()).getUsername()))
                : null );
        model.addAttribute("popularItems", itemMapper.toDtoWithoutShopDetails(itemService.getMostPopularItems(5)));
        model.addAttribute("popularShops", shopMapper.toDto(shopService.getMostPopularShops(7)));
        model.addAttribute("categories", categoryMapper.toDto(categoryService.findAll()));
        return "index";
    }
}
