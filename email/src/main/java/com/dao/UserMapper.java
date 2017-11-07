package com.dao;

import com.entity.User;

public interface UserMapper {

    /**
     * 根据用户名和密码进行查询
     * @param user
     * @return
     */
    User queryByUser(User user);


}
