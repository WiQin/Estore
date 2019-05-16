package wyw.bean;

/**
 * @ClassName ShipAddress
 * @Description
 * @Author Wangyw
 */
public class ShipAddress {
    private long id;
    private String shipuname;
    private String adres;
    private String phone;
    private Customer customer;//n：1

    public ShipAddress() {
    }

    public ShipAddress(long id, String shipuname, String adres, String phone) {
        this.id = id;
        this.shipuname = shipuname;
        this.adres = adres;
        this.phone = phone;
    }

    public ShipAddress(String shipuname, String adres, String phone, Customer customer) {
        this.shipuname = shipuname;
        this.adres = adres;
        this.phone = phone;
        this.customer = customer;
    }

    public ShipAddress(long id, String shipuname, String adres, String phone, Customer customer) {
        this.id = id;
        this.shipuname = shipuname;
        this.adres = adres;
        this.phone = phone;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShipuname() {
        return shipuname;
    }

    public void setShipuname(String shipuname) {
        this.shipuname = shipuname;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ShipAddress{" +
                "id=" + id +
                ", shipuname='" + shipuname + '\'' +
                ", adres='" + adres + '\'' +
                ", phone='" + phone + '\'' +
                ", customer=" + customer +
                '}';
    }
}
