package com.amr.project.service.abstracts;

import com.amr.project.model.entity.User;

public interface UserReadWriteService extends ReadWriteService<User, Long>{
    User getUserByUsername(String name);
}
