package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemReadWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemRestController {

    private final ItemReadWriteService itemReadWriteService;
    private final ItemMapper itemMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemDtoById(@PathVariable Long id) {
        Item item = itemReadWriteService.findById(id);
        return ResponseEntity.ok(itemMapper.INSTANCE.toDto(item));
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody Item item) {
        Item itemCreat = itemReadWriteService.persist(item);
        return ResponseEntity.ok(itemMapper.INSTANCE.toDto(itemCreat));
    }

    @PutMapping
    public ResponseEntity<ItemDto> updateItem(@RequestBody Item item) {
        itemReadWriteService.update(item);
        Item itemUpdate = itemReadWriteService.findById(item.getId());
        return ResponseEntity.ok(itemMapper.INSTANCE.toDto(itemUpdate));
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<Void> toBeDeleteItem(@RequestBody Item item) {
        item.setPretendedToBeDeleted(true);
        itemReadWriteService.update(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemReadWriteService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
