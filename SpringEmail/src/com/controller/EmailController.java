package com.controller;

import com.entity.Accepter;
import com.entity.Email;
import com.entity.User;
import com.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("singleEmail")
    public String saveSingle(@RequestParam(value = "file") MultipartFile file,HttpSession session, Email email,
                             Accepter accepter, Model model){

        //获取上传服务器的路径
        String path=session.getServletContext().getRealPath("upload");
        System.out.println(path);
        //定义上传文件
        File newFile=new File(path,file.getOriginalFilename());
        //上传解析
        try {
            file.transferTo(newFile);
        }catch (Exception e){
            e.printStackTrace();
        }

        User user= (User) session.getAttribute("u");

        //设置文件的名字
        email.setFilename(file.getOriginalFilename());
        //设置用户外键
        email.setUid(user.getId());
        //设置文件的路径
        email.setFilepath(path+"\\"+file.getOriginalFilename());
        emailService.sendSingleEmail(user,email,accepter);
        return "success";
    }


}
