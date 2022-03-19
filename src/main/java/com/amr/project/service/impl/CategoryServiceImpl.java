package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Category;
import com.amr.project.service.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ReadWriteServiceImpl<Category, Long> implements CategoryService {
    @Autowired
    public CategoryServiceImpl(ReadWriteDao<Category, Long> dao) {
        super(dao);
    }
}
