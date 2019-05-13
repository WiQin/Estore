package wyw.dao;

import wyw.bean.Customer;
import wyw.util.exception.CustomerException;

public interface CustomerDao {
    //添加
    public void insertCustomer(Customer customer) throws CustomerException;
    //查询
    public Customer selectCustomerByName(String name)  throws CustomerException;
    //更新
    public void updateCustomer(Customer customer)  throws CustomerException;

}
