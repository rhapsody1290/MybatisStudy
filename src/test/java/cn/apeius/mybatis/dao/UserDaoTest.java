package cn.apeius.mybatis.dao;

import cn.apeius.mybatis.domain.User;
import cn.apeius.mybatis.impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Asus on 2016/8/3.
 */
public class UserDaoTest {
    UserDao userDao;
    SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void testQueryUserById() throws Exception {
        User user = userDao.queryUserById(1l);
        System.out.println(user);
    }

    @Test
    public void testQueryAllUser() throws Exception {
        List<User> users = userDao.queryAllUser();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setName("xxx");
        user.setAge(18);
        user.setSex(1);
        user.setPassword("123456");
        user.setUser_name("xxxx");
        user.setBirthday(new Date());
        userDao.addUser(user);
        sqlSession.commit();
    }

    @Test
    public void testUpdateUser() throws Exception {
        //先查询再更新
        User user = userDao.queryUserById(15l);
        user.setUser_name("二舅");
        userDao.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void testDeleteUserById() throws Exception {
        userDao.deleteUserById(17l);
        sqlSession.commit();
    }
}