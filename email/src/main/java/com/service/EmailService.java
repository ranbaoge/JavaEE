package com.service;

import com.entity.Accepter;
import com.entity.Email;
import com.entity.User;

import java.util.List;
import java.util.Map;

public interface EmailService {



    /**
     * 邮件群发
     * @param email
     * @param accepters
     */
    void sendManyEmail(User user, Email email, List<Accepter> accepters);


    /**
     * 根据ID删除已发邮的邮件信息
     * @param id
     */
    void deleteById(int id);

    /**
     * 分页查询邮件
     * @return
     */
    List<Email> queryByPage(Map<String, Integer> map);

    /**
     * 查询分页总记录数
     * @return
     */
    int count();
}
