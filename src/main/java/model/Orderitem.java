package model;

public class Orderitem {

	private int id;
	private double price;
	private int amount;
	private String goodsName;
	private Goods goods;
	private Order order;
	
	public void setName(String name) {
		this.goodsName=name;
	}
	
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodName) {
		this.goodsName = goodName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Orderitem() {
		super();
	}
	public Orderitem(double price, int amount, Goods goods, Order order) {
		super();
		this.price = price;
		this.amount = amount;
		this.goods = goods;
		this.order = order;
	}
	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", price=" + price + ", amount=" + amount + ", goods=" + goods
				+ "]";
	}
	
	
	
	
}
