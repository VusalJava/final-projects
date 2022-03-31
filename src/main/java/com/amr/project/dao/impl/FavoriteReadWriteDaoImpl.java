package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.FavoriteReadWriteDao;
import com.amr.project.model.entity.Favorite;
import org.springframework.stereotype.Repository;

@Repository
public class FavoriteReadWriteDaoImpl extends ReadWriteDaoImpl<Favorite, Long> implements FavoriteReadWriteDao {
}
