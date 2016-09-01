package cn.apeius.mybatis.mapper;

import cn.apeius.mybatis.domain.Order;
import cn.apeius.mybatis.domain.User;
import cn.apeius.mybatis.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * Created by Asus on 2016/8/3.
 */
public class UserMapperTest {
    UserMapper userMapper;
    SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        //this.userMapper = new UserDaoImpl(sqlSession);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception{
        sqlSession.close();
    }

    @Test
    public void testQueryUserById() throws Exception {
        User user = userMapper.queryUserById(1l);
        System.out.println(user);
    }

    @Test
    public void testQueryAllUser() throws Exception {
        List<User> users = userMapper.queryAllUser();
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
        user.setUser_name("成龙");
        user.setBirthday(new Date());
        userMapper.addUser(user);
        System.out.println(user.getId());
        sqlSession.commit();
    }

    @Test
    public void testUpdateUser() throws Exception {
        //先查询再更新
        User user = userMapper.queryUserById(6L);
        user.setUser_name("二舅");
        userMapper.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void testDeleteUserById() throws Exception {
        userMapper.deleteUserById(18l);
        sqlSession.commit();
    }

    @Test
    public void testLogin(){
        User user = userMapper.login("zhangsan","123456");
        System.out.println(user);
    }

    @Test
    public void testQueryUsersByTableName(){
        List<User> users = userMapper.queryUserByTableName("tb_user");
        for(User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void testCache(){
        //第一次查询
        User user = userMapper.queryUserById(1l);
        sqlSession.clearCache();
        userMapper.queryUserById(1l);
    }

    @Test
    public void testPage(){
        //开启分页，第一个参数：当前的页数；第二个参数：每页几条数据
        PageHelper.startPage(2,5);

        List<User> users = userMapper.queryAllUser();
        for(User u : users){
            System.out.println(u);
        }

        //获取分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数 " + pageInfo.getPages());
        System.out.println("当前页数 " + pageInfo.getPageNum());
        System.out.println("每页多少数据 " + pageInfo.getPageSize());
        System.out.println("当前页的数据条目数 " + pageInfo.getSize());
    }
}