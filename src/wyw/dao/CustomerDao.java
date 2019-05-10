package wyw.dao;

import wyw.bean.Customer;

public interface CustomerDao {
    //添加
    public void insertCustomer(Customer customer);
    //查询
    public Customer selectCustomerByName(String name);
    //更新
    public void updateCustomer(Customer customer);

}
