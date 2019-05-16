package wyw.bean;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;


public class ShoppingCart {
    private Map<Long,OrderLine> cart = new TreeMap<Long,OrderLine>();

    //添加到购物车
    public void addCar(Book book,int num){
        OrderLine line = cart.get(book.getId());
        if(line==null){
            line = new OrderLine();
            Long id = line.getId();
            line.setBook(book);
            line.setNum(num);
            cart.put(book.getId(), line);
        }else{
            line.setNum(line.getNum()+num);
        }
    }
	/*//增加Orderline
	public void addLine(OrderLine line) {
		OrderLine orderline = cart.get(line.getBook().getId());
		if(orderline != null)
			orderline.setNum(orderline.getNum()+line.getNum());
		else if(line.getNum()>0)
			cart.put(line.getBook().getId(), line);
	}*/

    //删除Orderline
    public void dropLine(Long id) {
        cart.remove(id);
    }

    //获得单个Orderline
    public OrderLine getOrderline(Long lineid){
        return cart.get(lineid);
    }

    //获得所有Orderline
    public Collection<OrderLine> getOrderlines() {
        return cart.values();
    }

    public Map<Long,OrderLine> getLines(){
        return cart;
    }
    public void updateCar(long id,int number){
        OrderLine line = cart.get(id);
        line.setNum(number);
    }

    //获得购物车总价
    public double getCost() {
        double cost = 0.0;
        Collection<OrderLine> c = getOrderlines();
        for(OrderLine orderline : c){
            cost += orderline.getBook().getPrice() * orderline.getNum();
        }
        return cost;
    }

    //清空购物车
    public void removeAll() {
        cart.clear();
    }

    //判断购物车是否为空
    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public int getSize(){
        return cart.size();
    }
}
