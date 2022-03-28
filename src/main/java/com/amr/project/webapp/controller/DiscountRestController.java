package com.amr.project.webapp.controller;

import com.amr.project.converter.DiscountMapper;
import com.amr.project.model.dto.DiscountDto;
import com.amr.project.model.entity.Discount;
import com.amr.project.service.abstracts.DiscountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
@AllArgsConstructor
public class DiscountRestController {

    private final DiscountService discountService;
    private final DiscountMapper discountMapper;

    @GetMapping
    public ResponseEntity<List<DiscountDto>> getAllDiscounts() {
        List<Discount> discountList = discountService.findAll();
        return ResponseEntity.ok(discountMapper.toDtoList(discountList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountDto> getDiscountById(@PathVariable Long id) {
        Discount discountGet = discountService.findById(id);
        return ResponseEntity.ok(discountMapper.toDto(discountGet));
    }

    @PutMapping()
    public ResponseEntity<DiscountDto> editDiscount(@RequestBody DiscountDto discountDto) {
        Discount discount = discountMapper.toEntity(discountDto);
        discountService.update(discount);
        Discount discountUpdate = discountService.findById(discount.getId());
        return ResponseEntity.ok(discountMapper.toDto(discountUpdate));
    }

    @PostMapping
    public ResponseEntity<DiscountDto> createDiscount(@RequestBody DiscountDto discountDto) {
        Discount discount = discountMapper.toEntity(discountDto);
        Discount discountCreated = discountService.persist(discount);
        return ResponseEntity.ok(discountMapper.toDto(discountCreated));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
        discountService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
