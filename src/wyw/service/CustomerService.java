package wyw.service;

import wyw.bean.Customer;
import wyw.util.exception.CustomerException;

public interface CustomerService {
    //保存顾客
    public void saveCustomer(Customer customer) throws CustomerException;
    //通过名字查找顾客
    public Customer findCustomerByName(String name,String password) throws CustomerException;
    //修改客户的个人信息
    public void updateCustomer(Customer customer) throws CustomerException;
}

