package com.dao;

import com.entity.Accepter;
import com.entity.Email;

import java.util.List;
import java.util.Map;

public interface EmailMapper {


    /**
     * 保存发送的邮件
     * @param record
     * @return
     */
    int saveEmail(Email record);


    /**
     * 保存发送者信息
     * @param accepter
     * @return
     */
    int saveAccepter(Accepter accepter);

    /**
     * 根据ID删除已发送的邮件
     * @param id
     * @return
     */
    int deleteById(int id);


    /**
     * 分页查询邮件
     * @return
     */
    List<Email> queryByPage(Map<String,Integer> map);

    /**
     * 查询分页总记录数
     * @return
     */
    int count();

    /**
     * 根据主题查询该邮件
     * @param subject
     * @return
     */
    Email queryBySubject(String subject);
}