package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.*;
import com.amr.project.model.entity.*;
import com.amr.project.service.abstracts.*;
import org.springframework.stereotype.*;

@Service
public class OrderServiceImpl extends ReadWriteServiceImpl<Order, Long> implements OrderService {

    public final OrderReadWriteDao orderDao;

    public OrderServiceImpl(OrderReadWriteDao dao) {
        super(dao);
        orderDao = dao;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.findById(id);
    }

}
