package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.UserReadWriteDao;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService, UserDetailsService {

    public final UserReadWriteDao userDao;
    public final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserReadWriteDao dao, PasswordEncoder passwordEncoder) {
        super(dao);
        userDao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByUsername(String name) {
        return userDao.getUserByUsername(name);
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.getUserByUsername(name);
    }

    @Override
    public User persist(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.persist(user);
        return user;
    }

    @Override
    public void update(User user){
        if (!user.getPassword().equals(getUserByUsername(user.getUsername()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userDao.update(user);
    }
}
