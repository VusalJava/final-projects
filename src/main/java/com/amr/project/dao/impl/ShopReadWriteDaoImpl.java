package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ShopReadWriteDao;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopReadWriteDaoImpl extends ReadWriteDaoImpl<Shop, Long> implements ShopReadWriteDao {
    @Override
    public List<Shop> getMostPopularShops(int count) {
        return em.createQuery("select i from Shop i order by i.rating desc", Shop.class).setMaxResults(count).getResultList();
    }
}
