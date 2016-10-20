package cn.apeius.mybatis.mapper;

import cn.apeius.mybatis.domain.Order;
import cn.apeius.mybatis.domain.OrderDetail;
import cn.apeius.mybatis.domain.User;
import cn.apeius.mybatis.mapper.OrderMapper;
import cn.apeius.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Asus on 2016/8/26.
 */
public class OrderMapperTest {
    OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
                "applicationContext-transaction.xml"});
        orderMapper = context.getBean(OrderMapper.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testQueryOrderAndUserLazy(){
        Order order = orderMapper.queryOrderAndUserLazy("20140921001");
        System.out.println(order);
        System.out.println(order.getUser());
    }

    @Test
    public void testQueryOrderAndUserByOrderNumber() throws Exception {
        //OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderAndUserByOrderNumber("20140921003");
        System.out.println(order);
    }

    @Test
    public void testQueryOrderAndUserAndDetailByOrderNumber(){
        //OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderAndUserAndDetailByOrderNumber("20140921001");
        System.out.println(order);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for(OrderDetail d : orderDetails)
            System.out.println(d);
    }

    @Test
    public void testQueryOrdreAndUserAndDetailAndItemByOrderNumber(){
        //OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrdreAndUserAndDetailAndItemByOrderNumber("20140921001");
        System.out.println(order);
    }



}