package cn.apeius.mybatis.mapper;

import cn.apeius.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Asus on 2016/8/3.
 */
public interface UserMapper {
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

    /**
     * 登录
     */
    public User login(@Param("username") String username, @Param("password") String password);

    /**
     * 从当前表和历史表中获得数据
     */
    public List<User> queryUserByTableName(@Param("tableName") String tableName);

}
