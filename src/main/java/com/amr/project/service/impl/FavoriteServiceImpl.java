package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.FavoriteReadWriteDao;
import com.amr.project.model.entity.Favorite;
import com.amr.project.service.abstracts.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl extends ReadWriteServiceImpl<Favorite, Long> implements FavoriteService {

    public final FavoriteReadWriteDao favoriteDao;

    @Autowired
    public FavoriteServiceImpl(FavoriteReadWriteDao dao) {
        super(dao);
        favoriteDao = dao;
    }
}
