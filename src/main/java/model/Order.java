package model;

import utils.PriceUtil;

import java.util.*;

public class Order {

	private int id;
	private double total;//总价
	private int amount;//商品总数
	private int status;// 1、未支付/2、已付款 /3、已发送 /4、已完成
	private int paytype;// 1、微信/2、支付宝/3、货到付款
	private String name;
	private String phone;
	private String address;
	private Date datetime;
	private User user;

	private String province;
	private String city;

	public Order(int id, double total, int amount, int status, int paytype, String name, String phone, String address, Date datetime, User user, String province, String city, Map<Integer, Orderitem> itemMap, List<Orderitem> itemList) {
		this.id = id;
		this.total = total;
		this.amount = amount;
		this.status = status;
		this.paytype = paytype;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.datetime = datetime;
		this.user = user;
		this.province = province;
		this.city = city;
		this.itemMap = itemMap;
		this.itemList = itemList;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private Map<Integer,Orderitem> itemMap=new HashMap<Integer,Orderitem>();
	private List<Orderitem> itemList=new ArrayList<Orderitem>();
	
	
	public void setUsername(String username) {
		user=new User();
		user.setUsername(username);
	}
	
	public List<Orderitem> getItemList() {
		return itemList;
	}

	public void setItemList(List<Orderitem> itemList) {
		this.itemList = itemList;
	}

	public void addGoods(Goods g) {
		if(itemMap.containsKey((g.getId()))) {
			Orderitem item=itemMap.get(g.getId());
			item.setAmount(item.getAmount()+1);
						
		}else {
			Orderitem item=new Orderitem(g.getPrice(),1,g,this);
			itemMap.put(g.getId(), item);
		}
		amount++;
		total=PriceUtil.add(total, g.getPrice());
		
	}
	
	public void lessen(int goodsid) {
		if (itemMap.containsKey(goodsid)) {
			Orderitem item=itemMap.get(goodsid);
			item.setAmount(item.getAmount()-1);
			amount--;
			total-=PriceUtil.subtract(total, item.getPrice());
			if(item.getAmount()<=0) {
				itemMap.remove(goodsid);
			}
			
		}
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order() {
		super();
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + ", amount=" + amount + ", status=" + status + ", paytype="
				+ paytype + ", name=" + name + ", phone=" + phone + ", address=" + address + ", datetime=" + datetime
				+ ", user=" + user + ", itemMap=" + itemMap + "]";
	}


	public Map<Integer, Orderitem> getItemMap() {
		return itemMap;
	}


	public void setItemMap(Map<Integer, Orderitem> itemMap) {
		this.itemMap = itemMap;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
