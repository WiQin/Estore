package wyw.service.impl;

import wyw.bean.Customer;
import wyw.dao.CustomerDao;
import wyw.dao.impl.CustomerDaoImpl;
import wyw.service.CustomerService;
import wyw.util.exception.CustomerException;
import wyw.util.jdbc.JdbcUtil;

/**
 * @ClassName CustomerServiceImpl
 * @Description
 * @Author Wangyw
 */
public class CustomerServiceImpl implements CustomerService {

    CustomerDao dao;

    @Override
    public void saveCustomer(Customer customer) throws CustomerException {
        dao = new CustomerDaoImpl(JdbcUtil.getInstance());
        Customer cus = dao.selectCustomerByName(customer.getName());
        if(cus != null){

        }else{
            dao.insertCustomer(customer);
        }
    }

    @Override
    public Customer findCustomerByName(String name, String password) throws CustomerException{
        dao = new CustomerDaoImpl(JdbcUtil.getInstance());
        Customer cus = dao.selectCustomerByName(name);
        if(cus != null){
            if(cus.getPassword().equals(password)){
                return cus;
            }else{

            }
        }else{

        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerException{
        dao = new CustomerDaoImpl(JdbcUtil.getInstance());
        dao.updateCustomer(customer);
    }
}
