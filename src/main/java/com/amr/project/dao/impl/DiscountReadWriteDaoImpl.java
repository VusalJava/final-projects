package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.DiscountReadWriteDao;
import com.amr.project.model.entity.Discount;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountReadWriteDaoImpl extends ReadWriteDaoImpl<Discount, Long> implements DiscountReadWriteDao {
}
