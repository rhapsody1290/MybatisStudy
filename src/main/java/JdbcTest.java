import java.sql.*;

/**
 * Created by Asus on 2016/7/29.
 */
public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、创建连接
        String url = "jdbc:mysql://localhost:3306/mybatis";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3、获得statement对象
        String sql = "select * from tb_user where id = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setLong(1, 1);
        //4、执行sql语句
        ResultSet rs = psmt.executeQuery();
        //5、处理结果集
        while(rs.next()){
            System.out.println(rs.getString("user_name"));
            System.out.println(rs.getString("name"));
        }
        //6、关闭资源
        rs.close();
        psmt.close();
        conn.close();
    }
}
