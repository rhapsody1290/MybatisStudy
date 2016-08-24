package cn.apeius.mybatis.dao;

import cn.apeius.mybatis.domain.User;

import java.util.List;

/**
 * Created by Asus on 2016/8/3.
 */
public interface UserDao {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(Long id);
    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryAllUser();
    /**
     * 添加用户信息
     * @param user
     */
    public void addUser(User user);
    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);
    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);
}
