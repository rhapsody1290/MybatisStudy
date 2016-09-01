package cn.apeius.mybatis.service.imp;

import cn.apeius.mybatis.domain.User;
import cn.apeius.mybatis.mapper.UserMapper;
import cn.apeius.mybatis.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Asus on 2016/9/1.
 */
@Service
public class UserServiceImp implements UserServiceInter {

    @Autowired
    protected UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return userMapper.queryAllUser();
    }

    @Override
    public void saveUser(User user) {
        userMapper.addUser(user);
        //int a = 9 / 0;
    }
}
