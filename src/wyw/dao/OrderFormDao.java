package wyw.dao;

import wyw.bean.OrderForm;

import java.util.Map;

public interface OrderFormDao {
    public void insertOrderForm(OrderForm orderForm);
    public Map<Long,OrderForm> selectAllOrderByCusId(Long id);
    public void delOrderById(Long id);


}
