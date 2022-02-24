package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Shop;

import java.util.List;

public interface ShopReadWriteService extends ReadWriteService<Shop, Long> {
    List<Shop> getMostPopularShops(int count);
}
