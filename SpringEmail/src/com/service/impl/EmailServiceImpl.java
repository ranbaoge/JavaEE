package com.service.impl;

import com.dao.EmailMapper;
import com.entity.Accepter;
import com.entity.Email;
import com.entity.User;
import com.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("emailService")
public class EmailServiceImpl implements EmailService{

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSingleEmail(User user, Email email, Accepter accepter) {

        //先保存邮件信息，然后保存发送者信息
        //创建带格式的邮件发送类
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper=new MimeMessageHelper(mimeMessage,true);
            //设置邮件的发送者
            messageHelper.setFrom(user.getEmail());
            //设置邮件发送的主题
            messageHelper.setSubject(email.getSubject());
            //设置邮件发送的内容
            messageHelper.setText(email.getContent(),true);
            //设置单个接收者的用户
            messageHelper.setTo(accepter.getAemail());
            //设置邮件发送的附件
            FileDataSource dataSource=new FileDataSource(new File(email.getFilepath()));
            //添加附件
            messageHelper.addAttachment(email.getFilename(),dataSource);

            //发送邮件
            javaMailSender.send(mimeMessage);

            //保存邮件信息
            emailMapper.saveEmail(email);
            //设置接受者的外键
            Email newEmail=emailMapper.queryBySubject(email.getSubject());
            accepter.setEid(newEmail.getId());
            //保存发送者的信息
            emailMapper.saveAccepter(accepter);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void sendManyEmail(User user,Email email, List<Accepter> accepters) {

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper=null;
        try {
            messageHelper=new MimeMessageHelper(mimeMessage,true);
            //设置邮件的发送者
            messageHelper.setFrom(user.getEmail());
            //设置邮件发送的主题
            messageHelper.setSubject(email.getSubject());
            //设置邮件发送的内容
            messageHelper.setText(email.getContent(),true);
            //设置多个接收者的用户
            List<String> accepterStrings=new LinkedList<>();
            for (int i=0;i<accepters.size();i++){
                accepterStrings.add(accepters.get(i).getAemail());
            }
            messageHelper.setTo(accepterStrings.toArray(new String[accepterStrings.size()]));
            //设置邮件发送的附件
            FileDataSource dataSource=new FileDataSource(new File(email.getFilepath()));
            //添加附件
            messageHelper.addAttachment(email.getFilename(),dataSource);

            //发送邮件
            javaMailSender.send(mimeMessage);

            //保存邮件信息
            emailMapper.saveEmail(email);

            //保存接受者信息
            Email newEmail=emailMapper.queryBySubject(email.getSubject());
            Accepter accepter=null;
            for (int i=0;i<accepters.size();i++){
                accepter=accepters.get(i);
                accepter.setEid(newEmail.getId());
                emailMapper.saveAccepter(accepter);
            }

            //发送
            javaMailSender.send(mimeMessage);
        }catch (Exception e){

        }
    }

    @Override
    public void deleteById(int id) {
        emailMapper.deleteById(id);
    }

    @Override
    public List<Email> queryByPage(Map<String,Integer> map) {
        Integer page=map.get("page");
        Integer pageSize=map.get("pageSize");
        Integer from=(page-1)*pageSize;
        map.put("from",from);
        return emailMapper.queryByPage(map);
    }

    @Override
    public int count() {

        return emailMapper.count();
    }
}
