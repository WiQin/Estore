package wyw.dao;

import wyw.bean.Customer;
import wyw.bean.ShipAddress;

public interface ShipAddressDao {
    public void insertShipAddress(ShipAddress shipAddress, Customer customer);

    public ShipAddress selectShipAddressById(long id);
}
