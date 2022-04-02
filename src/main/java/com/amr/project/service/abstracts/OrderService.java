package com.amr.project.service.abstracts;

import com.amr.project.model.entity.*;

public interface OrderService extends ReadWriteService<Order, Long>{
    Order getOrderById(Long id);
}
