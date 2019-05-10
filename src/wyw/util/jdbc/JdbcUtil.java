package wyw.util.jdbc;

import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JdbcUtil
 * @Description
 * @Author Wangyw
 */
public class JdbcUtil {

    private static JdbcUtil instance = null;

    //数据库连接信息
    private static String driver = "";
    private static String url = "";
    private static String userName = "";
    private static String passWord = "";

    //数据库连接对象
    private Connection conn = null;
    //PreparedStatement对象
    private PreparedStatement ps = null;
    //结果集对象
    private ResultSet rs = null;

    public static JdbcUtil getInstance(){
        if(instance == null){
            instance = new JdbcUtil();
        }
        return instance;
    }

    private JdbcUtil(){
        Properties properties = new Properties();

        try {
            properties.load(JdbcUtil.class.getResourceAsStream("/property.properties"));

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");

            //加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //建立连接
    public Connection getConnection(){
        try {
            conn = DriverManager.getConnection(url,userName,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭资源
    public void close(){
        try{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //insert,update,delete操作
    public int executeUpdate(String sql,Object[] params){
        //受影响行数
        int affectLines = 0;
        try{
            //获取连接
            conn = this.getConnection();
            //调用sql
            ps = conn.prepareStatement(sql);
            //为参数赋值
            if(params != null){
                for(int i = 0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            //执行
            affectLines = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
        return affectLines;
    }

    //select操作
    public ResultSet executeSelect(String sql, Object[] params){

        try{
            conn = this.getConnection();
            ps  = conn.prepareStatement(sql);
            if(params != null){
                for(int i = 0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}








