package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ShopReadWriteDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopReadWriteServiceImpl extends ReadWriteServiceImpl<Shop, Long> implements ShopReadWriteService  {

    public ShopReadWriteDao dao;

    @Autowired
    public ShopReadWriteServiceImpl(ShopReadWriteDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Shop> getMostPopularShops(int count) {
        return dao.getMostPopularShops(count);
    }
}
