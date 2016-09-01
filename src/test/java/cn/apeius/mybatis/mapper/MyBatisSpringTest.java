package cn.apeius.mybatis.mapper;

import cn.apeius.mybatis.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Asus on 2016/9/1.
 */
public class MyBatisSpringTest {
    public static void main(String[] args){
        //1、获取Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> users = userMapper.queryAllUser();
        for(User user : users){
            System.out.println(user);
        }
    }
}
