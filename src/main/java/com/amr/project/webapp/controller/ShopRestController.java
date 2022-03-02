package com.amr.project.webapp.controller;

import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopRestController {

    private final ShopService shopService;
    private final ShopMapper shopMapper;

    @GetMapping
    public ResponseEntity<Iterable<ShopDto>> getAllShop() {
        List<Shop> shops = shopService.findAll();
        return ResponseEntity.ok(shopMapper.toDto(shops));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getShopDtoById(@PathVariable Long id) {
        Shop shop = shopService.findById(id);
        return ResponseEntity.ok(shopMapper.toDto(shop));
    }

    @PostMapping
    public ResponseEntity<ShopDto> createShop(@RequestBody Shop shop) {
        Shop shopCreat = shopService.persist(shop);
        return ResponseEntity.ok(shopMapper.toDto(shopCreat));
    }

    @PutMapping
    public ResponseEntity<ShopDto> updateShop(@RequestBody Shop shop) {
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
