package wyw.bean;

/**
 * @ClassName Book
 * @Description
 * @Author Wangyw
 */
public class Book {
    private long id;//id应为long类型
    private String name;
    private float price;//价格有小数，类型为float
    private String type;

    public Book() {

    }

    public Book(long id, String name, float price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
