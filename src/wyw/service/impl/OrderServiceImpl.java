package wyw.service.impl;

import wyw.bean.OrderForm;
import wyw.dao.OrderFormDao;
import wyw.dao.impl.OrderFormDaoImpl;
import wyw.service.OrderService;
import wyw.util.jdbc.JdbcUtil;

/**
 * @ClassName OrderServiceImpl
 * @Description
 * @Author Wangyw
 */
public class OrderServiceImpl implements OrderService {

    OrderFormDao orderFormDao;

    @Override
    public void saveOrderForm(OrderForm orderForm) {
        orderFormDao = new OrderFormDaoImpl(JdbcUtil.getInstance());
        orderFormDao.insertOrderForm(orderForm);
    }
}
