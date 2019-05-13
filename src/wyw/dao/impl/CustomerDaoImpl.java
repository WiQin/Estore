package wyw.dao.impl;

import wyw.bean.Customer;
import wyw.dao.CustomerDao;
import wyw.util.exception.CustomerException;
import wyw.util.jdbc.JdbcUtil;

import java.sql.ResultSet;

/**
 * @ClassName CustomerDaoImpl
 * @Description
 * @Author Wangyw
 */
public class CustomerDaoImpl implements CustomerDao {
    private JdbcUtil util;

    public CustomerDaoImpl(JdbcUtil util) {
        this.util = util;
    }

    @Override
    public void insertCustomer(Customer customer)  throws CustomerException{

        String sql = "insert into customer(name,password,zip,address,telephone,email) values(?,?,?,?,?,?)";
        String[] params = {customer.getName(),customer.getPassword(),customer.getZip(),customer.getAddress(),customer.getTelephone(),customer.getEmail()};
        int i = util.executeUpdate(sql,params);
        System.out.println(i+"行被修改");
    }

    @Override
    public Customer selectCustomerByName(String name)  throws CustomerException{
        Customer customer = null;
        String sql = "select * from customer where name=?";
        String[] params = {name};
        ResultSet rs = util.executeSelect(sql,params);

        try{
            while(rs.next()){
                int cid = rs.getInt("id");
                String cname = rs.getString("name");
                String cpassword = rs.getString("password");
                String czip = rs.getString("zip");
                String caddress = rs.getString("address");
                String ctelephone = rs.getString("telephone");
                String cemail = rs.getString("email");
                customer = new Customer(cid,cname,cpassword,czip,caddress,ctelephone,cemail);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.close();
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerException {
        String sql = "update customer set password=?,zip=?,address=?,telephone=?,email=? where name=?";
        //sql语句中的参数
        String[] params = {customer.getPassword(),customer.getZip(),customer.getAddress(),customer.getTelephone(),customer.getEmail(),customer.getName()};
        //执行修改操作
        int i = util.executeUpdate(sql, params);
        System.out.println("本次受影响行数："+i);
    }
}
