package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryReadWriteServiceImpl extends ReadWriteServiceImpl<Category, Long> {
    @Autowired
    public CategoryReadWriteServiceImpl(ReadWriteDao<Category, Long> dao) {
        super(dao);
    }
}
