import com.entity.Email;
import com.entity.User;
import com.service.EmailService;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class TestEmail {

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        Map<String,Integer> map=new HashMap<>();
        map.put("page",1);
        map.put("pageSize",8);
        List<Email> emails=emailService.queryByPage(map);
        for (Email email:emails) {
            System.out.println(email);
        }

    }
}
