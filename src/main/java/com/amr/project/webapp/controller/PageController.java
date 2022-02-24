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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private ItemReadWriteService itemService;
    private UserReadWriteService userService;
    private ShopReadWriteService shopService;
    private ReadWriteServiceImpl<Category, Long> categoryService;

    private ShopMapper shopMapper;
    private ItemMapper itemMapper;
    private UserMapper userMapper;
    private CategoryMapper categoryMapper;


    @Autowired
    public PageController(ItemReadWriteService itemService, UserReadWriteService userService,
                          ShopReadWriteService shopService, ShopMapper shopMapper, ItemMapper itemMapper,
                          UserMapper userMapper, ReadWriteServiceImpl<Category, Long> categoryService,
                          CategoryMapper categoryMapper) {
        this.itemService = itemService;
        this.userService = userService;
        this.shopService = shopService;
        this.categoryService = categoryService;
        this.shopMapper = shopMapper;
        this.itemMapper = itemMapper;
        this.userMapper = userMapper;
        this.categoryMapper = categoryMapper;
    }

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
