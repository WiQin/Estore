package wyw.service.impl;

import wyw.bean.Customer;
import wyw.bean.ShipAddress;
import wyw.dao.ShipAddressDao;
import wyw.dao.impl.ShipAddressDaoImpl;
import wyw.service.ShipAddressService;
import wyw.util.jdbc.JdbcUtil;

/**
 * @ClassName ShipAddressServiceImpl
 * @Description
 * @Author Wangyw
 */
public class ShipAddressServiceImpl implements ShipAddressService {

    ShipAddressDao shipAddressDao;

    @Override
    public void saveShipAddress(ShipAddress shipAddress, Customer customer) {
        shipAddressDao = new ShipAddressDaoImpl(JdbcUtil.getInstance());
        shipAddressDao.insertShipAddress(shipAddress,customer);

    }

    @Override
    public ShipAddress findShipAddressById(long id) {
        shipAddressDao = new ShipAddressDaoImpl(JdbcUtil.getInstance());
        ShipAddress shipAddress = shipAddressDao.selectShipAddressById(id);
        return shipAddress;
    }
}
