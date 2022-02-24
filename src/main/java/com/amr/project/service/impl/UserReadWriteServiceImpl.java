package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.UserReadWriteDao;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReadWriteServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserReadWriteService {

    public UserReadWriteDao userDao;

    @Autowired
    public UserReadWriteServiceImpl(UserReadWriteDao dao) {
        super(dao);
        userDao = dao;
    }

    @Override
    public User getUserByUsername(String name) {
        return userDao.getUserByUsername(name);
    }
}
