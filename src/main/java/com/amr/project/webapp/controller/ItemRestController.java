package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemRestController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public ItemRestController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemDtoById(@PathVariable Long id) {
        Item item = itemService.findById(id);
        return ResponseEntity.ok(itemMapper.toDto(item));
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto item) {
        Item itemCreat = itemService.persist(itemMapper.toEntity(item));
        return ResponseEntity.ok(itemMapper.toDto(itemCreat));
    }

    @PutMapping
    public ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto item) {
        itemService.update(itemMapper.toEntity(item));
        Item itemUpdate = itemService.findById(item.getId());
        return ResponseEntity.ok(itemMapper.toDto(itemUpdate));
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<Void> toBeDeleteItem(@RequestBody ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);
        item.setPretendedToBeDeleted(true);
        itemService.update(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
