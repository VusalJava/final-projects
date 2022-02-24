package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Item;

import java.util.List;

public interface ItemReadWriteService extends ReadWriteService<Item, Long> {
    List<Item> getMostPopularItems(int count);
}
