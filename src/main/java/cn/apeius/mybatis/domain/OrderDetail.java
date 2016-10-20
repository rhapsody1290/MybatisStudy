package cn.apeius.mybatis.domain;

/**
 * Created by Asus on 2016/8/26.
 */
public class OrderDetail {
    private int id;
    private Order order;//private int order_id;
    private Item item;//private int item_id;
    private double total_price;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", order=" + order +
                ", item=" + item +
                ", total_price=" + total_price +
                ", status=" + status +
                '}';
    }
}
