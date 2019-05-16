package wyw.service;

import wyw.bean.Customer;
import wyw.bean.ShipAddress;

public interface ShipAddressService {
    public void saveShipAddress(ShipAddress shipAddress, Customer customer);

    public ShipAddress findShipAddressById(long id);
}
