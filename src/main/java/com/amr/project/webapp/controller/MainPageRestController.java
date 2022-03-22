package com.amr.project.webapp.controller;

import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.converter.UserMapper;
import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Category;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import com.amr.project.service.abstracts.UserService;
import com.amr.project.service.impl.ReadWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainPageRestController {
    private final ItemService itemService;
    private final UserService userService;
    private final ShopService shopService;
    private final ReadWriteServiceImpl<Category, Long> categoryService;

    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;
    private final UserMapper userMapper;
    private final CategoryMapper categoryMapper;

    @GetMapping("/")
    public ResponseEntity<MainPageDto> mainPage(Principal principal,
                                                @NotNull @RequestParam(value = "items") int itemsNum,
                                                @NotNull @RequestParam(value = "shops") int shopsNum) {
        MainPageDto mainPageDto = MainPageDto.builder()
                .user((principal != null) ?
                        userMapper.toDto(userService.getUserByUsername(principal.getName())) : null)
                .popularItems((List) itemMapper.toDtoList(itemService.getMostPopularItems(itemsNum)))
                .popularShops((List) shopMapper.toDtoList(shopService.getMostPopularShops(shopsNum)))
                .categories(categoryMapper.toDtoList(categoryService.findAll())).build();
        return new ResponseEntity<>(mainPageDto, HttpStatus.OK);
    }
}