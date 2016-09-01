package cn.apeius.mybatis.mapper;

import cn.apeius.mybatis.domain.Order;
import cn.apeius.mybatis.mapper.OrderMapper;
import cn.apeius.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Asus on 2016/8/26.
 */
public class OrderMapperTest {
    UserMapper userMapper;
    SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryOrderAndUserByOrderNumber() throws Exception {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderAndUserByOrderNumber("20140921003");
        System.out.println(order);
    }

    @Test
    public void testQueryOrderAndUserAndDetailByOrderNumber(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderAndUserAndDetailByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void testQueryOrdreAndUserAndDetailAndItemByOrderNumber(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrdreAndUserAndDetailAndItemByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void testQueryOrderAndUserLazy(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderAndUserLazy("20140921001");
        System.out.println(order.getOrder_number());
        System.out.println(order.getUser());
    }

}