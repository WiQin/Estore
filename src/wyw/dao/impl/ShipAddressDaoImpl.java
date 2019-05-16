package wyw.dao.impl;

import wyw.bean.Customer;
import wyw.bean.ShipAddress;
import wyw.dao.ShipAddressDao;
import wyw.util.jdbc.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName ShipAddressDaoImpl
 * @Description
 * @Author Wangyw
 */
public class ShipAddressDaoImpl implements ShipAddressDao {

    private JdbcUtil jdbcUtil;

    public ShipAddressDaoImpl(JdbcUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

    @Override
    public void insertShipAddress(ShipAddress shipAddress, Customer customer) {
        String sql = "insert into shipaddres(shipuname,adres,phone,cus_id) values(?,?,?,?)";
        String[] params = {shipAddress.getShipuname() + "", shipAddress.getAdres() + "", shipAddress.getPhone() + "", customer.getId() + ""};
        jdbcUtil.executeUpdate(sql, params);
    }

    @Override
    public ShipAddress selectShipAddressById(long id) {
        String sql = "select * from shipaddres where id = ?";
        String[] params = {id + ""};

        ResultSet rs = jdbcUtil.executeSelect(sql, params);
        ShipAddress shipaddress = null;
        try {
            while (rs.next()) {
                long sid = rs.getLong("id");
                String shipuname = rs.getString("shipuname");
                String adres = rs.getString("adres");
                String phone = rs.getString("phone");
                shipaddress = new ShipAddress(sid, shipuname, adres, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipaddress;
    }
}