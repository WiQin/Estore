package wyw.bean;

/**
 * @ClassName OrderLine
 * @Description
 * @Author Wangyw
 */
public class OrderLine {
    private long id;
    private int num;
    private OrderForm orderForm;
    private Book book;

    public OrderLine() {
    }

    public OrderLine(long id, int num, OrderForm orderForm, Book book) {
        this.id = id;
        this.num = num;
        this.orderForm = orderForm;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public OrderForm getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", num=" + num +
                ", orderForm=" + orderForm +
                ", book=" + book +
                '}';
    }
}
