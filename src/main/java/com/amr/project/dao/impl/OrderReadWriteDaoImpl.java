package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.*;
import com.amr.project.model.entity.*;
import org.springframework.stereotype.*;

@Repository
public class OrderReadWriteDaoImpl extends ReadWriteDaoImpl<Order, Long> implements OrderReadWriteDao {

    @Override
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }
}
