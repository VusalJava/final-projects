package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Item;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ItemService extends ReadWriteService<Item, Long> {
    List<Item> getMostPopularItems(int count);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteByIdCascadeEnable(Long id);
}
