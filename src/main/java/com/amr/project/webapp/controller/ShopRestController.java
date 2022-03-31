package com.amr.project.webapp.controller;

import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.AboutShopDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/shop")
public class ShopRestController {

    private final ShopService shopService;
    private final ShopMapper shopMapper;
    private final ItemService itemService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<ShopDto>> getAllShop() {
        return ResponseEntity.ok(shopMapper.toDtoList(shopService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getShopDtoById(@PathVariable Long id) {
        Shop shop = shopService.findById(id);
        return ResponseEntity.ok(shopMapper.toDto(shop));
    }

    @GetMapping("/{id}/about")
    public ResponseEntity<AboutShopDto> getAboutShop(@PathVariable Long id) {
        Shop shop = shopService.findById(id);
        ShopDto shopDto = shopMapper.toDto(shop);
        AboutShopDto aboutShopDto = AboutShopDto.builder()
                .id(shopDto.getId()).name(shopDto.getName())
                .description(shopDto.getDescription()).rating(shopDto.getRating())
                .averageRating(itemService.getAverageRatingItemsByShop(shop))
                .items(shopDto.getItems()).discounts(shopDto.getDiscounts())
                .categoryItem(categoryMapper.toDtoList(itemService.getCategoryByShop(shop))).countryId(shopDto.getCountryId())
                .email(shopDto.getEmail()).phone(shopDto.getPhone())
                .build();
        return ResponseEntity.ok(aboutShopDto);
    }

    @PostMapping
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shop) {
        Shop shopCreat = shopService.persist(shopMapper.toEntity(shop));
        return ResponseEntity.ok(shopMapper.toDto(shopCreat));
    }

    @PutMapping
    public ResponseEntity<ShopDto> updateShop(@RequestBody ShopDto shopDto) {
        Shop shop = shopMapper.toEntity(shopDto);
        shopService.update(shop);
        Shop shopUpdate = shopService.findById(shop.getId());
        return ResponseEntity.ok(shopMapper.toDto(shopUpdate));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
