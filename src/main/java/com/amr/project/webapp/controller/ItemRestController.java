package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemRestController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemDtoById(@PathVariable Long id) {
        Item item = itemService.findById(id);
        return ResponseEntity.ok(itemMapper.toDto(item));
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody Item item) {
        Item itemCreat = itemService.persist(item);
        return ResponseEntity.ok(itemMapper.toDto(itemCreat));
    }

    @PutMapping
    public ResponseEntity<ItemDto> updateItem(@RequestBody Item item) {
        itemService.update(item);
        Item itemUpdate = itemService.findById(item.getId());
        return ResponseEntity.ok(itemMapper.toDto(itemUpdate));
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<Void> toBeDeleteItem(@RequestBody Item item) {
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
