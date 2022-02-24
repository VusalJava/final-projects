package com.amr.project.webapp.controller;

import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ReadWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemRestController {

    private final ReadWriteService<Item, Long> readWriteService;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(readWriteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return ResponseEntity.ok(readWriteService.persist(item));
    }

    @PutMapping
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        readWriteService.update(item);
        return ResponseEntity.ok(readWriteService.findById(item.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        readWriteService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
