package wyw.bean;

import java.util.Date;

/**
 * @ClassName OrderForm
 * @Description
 * @Author Wangyw
 */
public class OrderForm {
    private long id;
    private double cost;
    private Date orderDate;
    private Customer customer;
    private ShipAddress shipAddress;

    public OrderForm() {
    }

    public OrderForm(long id, double cost, Date orderDate, Customer customer, ShipAddress shipAddress) {
        this.id = id;
        this.cost = cost;
        this.orderDate = orderDate;
        this.customer = customer;
        this.shipAddress = shipAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShipAddress getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(ShipAddress shipAddress) {
        this.shipAddress = shipAddress;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", cost=" + cost +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", shipAddress=" + shipAddress +
                '}';
    }
}
