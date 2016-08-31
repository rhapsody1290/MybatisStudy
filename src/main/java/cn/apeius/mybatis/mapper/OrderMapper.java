package cn.apeius.mybatis.mapper;

import cn.apeius.mybatis.domain.Order;

/**
 * Created by Asus on 2016/8/26.
 */
public interface OrderMapper {

    public Order queryOrderAndUserByOrderNumber(String orderNumber);
    public Order queryOrderAndUserAndDetailByOrderNumber(String orderNumber);
    public Order queryOrdreAndUserAndDetailAndItemByOrderNumber(String orderNumber);
    public Order queryOrderAndUserLazy(String orderNumber);
}
