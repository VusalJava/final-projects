package com.amr.project.service.abstracts;

import com.amr.project.model.entity.User;

public interface UserService extends ReadWriteService<User, Long> {
    User getUserByUsername(String name);
}
