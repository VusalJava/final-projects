package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.UserReadWriteDao;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {

    public UserReadWriteDao userDao;

    @Autowired
    public UserServiceImpl(UserReadWriteDao dao) {
        super(dao);
        userDao = dao;
    }

    @Override
    public User getUserByUsername(String name) {
        return userDao.getUserByUsername(name);
    }
}
