package com.service;

import com.entity.User;

public interface UserService {

    /**
     * 登录查询
     * @param user
     * @return
     */
    User login(User user);

}
