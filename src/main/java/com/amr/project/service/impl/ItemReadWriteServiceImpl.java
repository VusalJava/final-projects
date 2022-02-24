package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ItemReadWriteDao;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemReadWriteServiceImpl extends ReadWriteServiceImpl<Item, Long> implements ItemReadWriteService {

    public ItemReadWriteDao itemDao;

    @Autowired
    public ItemReadWriteServiceImpl(ItemReadWriteDao dao) {
        super(dao);
        itemDao = dao;
    }

    @Override
    public List<Item> getMostPopularItems(int count) {
        return itemDao.getMostPopularItems(count);
    }
}
