package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.*;

public interface OrderReadWriteDao extends ReadWriteDao<Order, Long>{
    public Order findById(Long id);
}
