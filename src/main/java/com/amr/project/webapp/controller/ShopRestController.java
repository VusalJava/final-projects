package com.amr.project.webapp.controller;

import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopReadWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopRestController {

    private final ShopReadWriteService shopReadWriteService;
    private final ShopMapper shopMapper;

    @GetMapping
    public ResponseEntity<Iterable<ShopDto>> getAllShop() {
        List<Shop> shops = shopReadWriteService.findAll();
        return ResponseEntity.ok(shopMapper.INSTANCE.toDto(shops));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getShopDtoById(@PathVariable Long id) {
        Shop shop = shopReadWriteService.findById(id);
        return ResponseEntity.ok(shopMapper.INSTANCE.toDto(shop));
    }

    @PostMapping
    public ResponseEntity<ShopDto> createShop(@RequestBody Shop shop) {
        Shop shopCreat = shopReadWriteService.persist(shop);
        return ResponseEntity.ok(shopMapper.INSTANCE.toDto(shopCreat));
    }

    @PutMapping
    public ResponseEntity<ShopDto> updateShop(@RequestBody Shop shop) {
        shopReadWriteService.update(shop);
        Shop shopUpdate = shopReadWriteService.findById(shop.getId());
        return ResponseEntity.ok(shopMapper.INSTANCE.toDto(shopUpdate));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopReadWriteService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
