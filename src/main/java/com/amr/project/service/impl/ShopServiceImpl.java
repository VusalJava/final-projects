package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ShopReadWriteDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends ReadWriteServiceImpl<Shop, Long> implements ShopService {

    public ShopReadWriteDao dao;

    @Autowired
    public ShopServiceImpl(ShopReadWriteDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Shop> getMostPopularShops(int count) {
        return dao.getMostPopularShops(count);
    }
}
