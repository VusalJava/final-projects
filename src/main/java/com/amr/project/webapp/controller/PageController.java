package com.amr.project.webapp.controller;

import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.converter.UserMapper;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import com.amr.project.service.abstracts.UserService;
import com.amr.project.service.impl.CategoryServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class PageController {
    private final ItemService itemService;
    private final UserService userService;
    private final ShopService shopService;
    private final CategoryServiceImpl categoryService;

    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;
    private final UserMapper userMapper;
    private final CategoryMapper categoryMapper;

    public PageController(ItemService itemService,
                          UserService userService,
                          ShopService shopService,
                          CategoryServiceImpl categoryService,
                          ShopMapper shopMapper,
                          ItemMapper itemMapper,
                          UserMapper userMapper,
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
}
