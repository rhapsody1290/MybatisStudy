package cn.apeius.mybatis.service;

import cn.apeius.mybatis.domain.User;
import cn.apeius.mybatis.service.imp.UserServiceImp;
import cn.apeius.mybatis.service.inter.UserServiceInter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Asus on 2016/9/1.
 */
public class UserServiceTest {

    private UserServiceInter userServiceInter;

    @Before
    public void setUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-transaction.xml"});
        userServiceInter = context.getBean(UserServiceImp.class);
    }

    @Test
    public void testQueryAll(){
        List<User> users = userServiceInter.queryAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUser_name("陈冠希");
        user.setName("dsfa");
        userServiceInter.saveUser(user);
    }
}
