package cn.apeius.mybatis.service.inter;

import cn.apeius.mybatis.domain.User;

import java.util.List;

/**
 * Created by Asus on 2016/9/1.
 */
public interface UserServiceInter {

    public List<User> queryAll();
    public void saveUser(User user);
}
