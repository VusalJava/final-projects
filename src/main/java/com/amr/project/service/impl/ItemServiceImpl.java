package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ItemReadWriteDao;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends ReadWriteServiceImpl<Item, Long> implements ItemService {

    public final ItemReadWriteDao itemDao;

    @Autowired
    public ItemServiceImpl(ItemReadWriteDao dao) {
        super(dao);
        itemDao = dao;
    }

    @Override
    public List<Item> getMostPopularItems(int count) {
        return itemDao.getMostPopularItems(count);
    }
}
