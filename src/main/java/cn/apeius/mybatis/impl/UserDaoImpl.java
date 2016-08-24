package cn.apeius.mybatis.impl;

import cn.apeius.mybatis.dao.UserDao;
import cn.apeius.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Asus on 2016/8/3.
 */
public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;
    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    public User queryUserById(Long id) {
        return sqlSession.selectOne("user.queryUserById", id);
    }

    public List<User> queryAllUser() {
        return sqlSession.selectList("user.queryAllUser");
    }

    public void addUser(User user) {
        sqlSession.insert("user.addUser", user);
    }

    public void updateUser(User user) {
        sqlSession.update("user.updateUser", user);
    }

    public void deleteUserById(Long id) {
        sqlSession.delete("user.deleteUserById", id);
    }
}
