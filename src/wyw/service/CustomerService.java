package wyw.service;

import wyw.bean.Customer;

public interface CustomerService {
    //保存顾客
    public void saveCustomer(Customer customer);
    //通过名字查找顾客
    public Customer findCustomerByName(String name,String password);
    //修改客户的个人信息
    public void updateCustomer(Customer customer);
}

