package wyw.dao.impl;

import wyw.bean.OrderForm;
import wyw.dao.OrderFormDao;
import wyw.util.jdbc.JdbcUtil;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName OrderFormDaoImpl
 * @Description
 * @Author Wangyw
 */
public class OrderFormDaoImpl implements OrderFormDao {

    private JdbcUtil jdbcUtil;

    public OrderFormDaoImpl(JdbcUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

    @Override
    public void insertOrderForm(OrderForm orderForm) {
        String sql = "insert into orderform(cost,orderdate,customer,sadres_id) values (?,?,?,?)";
        String[] params = {orderForm.getCost()+"",new Date(orderForm.getOrderDate().getTime())+"",orderForm.getCustomer().getId()+"",orderForm.getShipAddress().getId()+""};
        int i = jdbcUtil.executeUpdate(sql, params);
        System.out.println(i+"行被插入");
    }

    @Override
    public Map<Long, OrderForm> selectAllOrderByCusId(Long id) {
        return null;
    }

    @Override
    public void delOrderById(Long id) {

    }
}
