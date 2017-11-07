package com.controller;

import com.entity.Accepter;
import com.entity.Email;
import com.entity.User;
import com.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @RequestMapping("query/{page}")
    public String query(@PathVariable int page, Model model){
        int count=emailService.count();
        int pageSize=8;
        int lastPage=count%pageSize==0?count/pageSize:count/pageSize+1;
        Map<String,Integer> map=new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        List<Email> emails= emailService.queryByPage(map);
        model.addAttribute("page",page);
        model.addAttribute("lastPage",lastPage);
        model.addAttribute("emails",emails);

        return "show";
    }

    @RequestMapping("email")
    public String sendEmail(@RequestParam(value = "file") MultipartFile file,HttpSession session, Email email,
                            String[] aemail, Model model){

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

        //循环遍历接受者邮箱，分别使用对象保存
        List<Accepter> accepters=new ArrayList<>();
        Accepter accepter=null;
        for (int i = 0; i <aemail.length ; i++) {
           accepter=new Accepter(aemail[i],null);
           accepters.add(accepter);
        }
        emailService.sendManyEmail(user,email,accepters);
        return "success";
    }


}
