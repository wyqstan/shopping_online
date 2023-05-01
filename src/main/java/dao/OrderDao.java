package dao;

import model.Order;
import model.Orderitem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
	
	public void insertOrder(Connection con,Order order) throws SQLException{
		QueryRunner r = new QueryRunner();
		String sql = "insert into `order`(total,amount,status,paytype,name,phone,province,city,address,datetime,user_id) values(?,?,?,?,?,?,?,?,?,?,?)";
		r.update(con,sql,
				order.getTotal(),order.getAmount(),order.getStatus(),
				order.getPaytype(),order.getName(),order.getPhone(),
				order.getProvince(),order.getCity(), order.getAddress(),
				order.getDatetime(),order.getUser().getId() );
	}
	public int getLastInsertId(Connection con) throws SQLException {
		QueryRunner r=new QueryRunner();
		String sql="select last_insert_id()";
		BigInteger bi= r.query(con, sql,new ScalarHandler<BigInteger>());
		return Integer.parseInt(bi.toString());
	}
	
	public void insertOrderItem(Connection con,Orderitem item) throws SQLException {
		QueryRunner r=new QueryRunner();
		String sql="insert into orderitem(price,amount,goods_id,order_id) values(?,?,?,?)";
		r.update(con,sql,item.getPrice(),item.getAmount(),item.getGoods().getId(),item.getOrder().getId());
	}
	public List<Order> selectAll(int userid) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from `order` where user_id=? ";
		return r.query(sql, new BeanListHandler<Order>(Order.class),userid);
	}
	public List<Orderitem> selectAllItem(int orderid) throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select i.id,i.price,i.amount,g.name from orderitem i,goods g where order_id=? and i.goods_id=g.id";
		return r.query(sql, new BeanListHandler<Orderitem>(Orderitem.class),orderid);
	}
	public int getOrderCount(int status) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="";
		if(status==0) {
			sql = "select count(*) from `order`";
			return r.query(sql, new ScalarHandler<Long>()).intValue();
		}else {
			sql = "select count(*) from `order` where status=?";
			int tmp= r.query(sql, new ScalarHandler<Long>(),status).intValue();
			return tmp;
		}
	}
	public List selectOrderList(int status, int pageNo, int pageSize) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		if (status==0) {
			String sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from `order` o,user u where o.user_id=u.id order by o.datetime desc limit ?,?";
			return r.query(sql, new BeanListHandler<Order>(Order.class),(pageNo-1)*pageSize,pageSize);
		}else {
			String sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from `order` o,user u where o.user_id=u.id and o.status=? order by o.datetime desc limit ?,?";
			return r.query(sql, new BeanListHandler<Order>(Order.class),status,(pageNo-1)*pageSize,pageSize);
		}
	}
	
	
	public void updateStatus(int id,int status) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="update `order` set status= ? where id= ?";
		r.update(sql,status,id);
	}
	public void deleteOrder(Connection con ,int id) throws SQLException {
		QueryRunner r=new QueryRunner();
		String sql="delete from `order` where id = ?";
		r.update(con,sql,id);
	}
	public void deleteOrderItem(Connection con ,int id) throws SQLException {
		QueryRunner r=new QueryRunner();
		String sql="delete from orderitem where order_id = ?";
		r.update(con,sql,id);
	}
	
	
}
