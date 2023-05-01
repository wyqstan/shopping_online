package dao;

import com.mysql.cj.util.DnsSrv;
import model.Goods;
import model.User;
import model.UserRecord;
import model.UserRecord2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao {
	
	public void addUser(User user) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="insert into user(username,email,password,name,phone,address,isadmin,isvalidate,total_price) values(?,?,?,?,?,?,?,?,0)";
		r.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());

	}

	public void login_record(UserRecord userRecord) throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="insert into login_record(username,ip,time,status) values(?,?,?,?)";
		r.update(sql,userRecord.getUsername(),userRecord.getIp(),userRecord.getTime(),userRecord.getStatus());
	}
	public void userview(String username, String second, String goodname, String typename, Date date)throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="insert into userview(username,second,goodname,typename,time) values(?,?,?,?,?)";
		r.update(sql,username,second,goodname,typename,date);
	}

	public void addusersale(int id)throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="insert into usersale('id') value (?)";
		r.update(sql,id);
	}
	public void updateusersale(String typename,int userid,int amount)throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="update usersale set "+typename+"=? where id=?";
		r.update(sql,amount,userid);
	}
	public void logout_record(UserRecord userRecord) throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="insert into logout_record(user_name,ip_address,time) values(?,?,?)";
		r.update(sql,userRecord.getUsername(),userRecord.getIp(),userRecord.getTime());
	}

	public List<UserRecord2> selectIP(int pageNo, int pageSize) throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from login_record limit ?,?";
		return r.query(sql, new BeanListHandler<UserRecord2>(UserRecord2.class),(pageNo-1)*pageSize,pageSize);
	}
	public int getIPCount() throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from login_record";
		return r.query(sql, new ScalarHandler<Long>()).intValue();
	}

	public int selectusersale(String typename,int id) throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select " + typename + " from usersale where id="+id;
		return r.query(sql, new ScalarHandler<Integer>()).intValue();
	}
	public List<UserRecord> selectLogoutRecord()throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from logout_record";
		return r.query(sql,new BeanListHandler<UserRecord>(UserRecord.class));
	}
	public boolean isUsernameExist(String username) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where username=?";
		User u=r.query(sql, new BeanHandler<User>(User.class),username);
		if(u==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean isEmailExist(String email) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where email=? ";
		User u=r.query(sql, new BeanHandler<User>(User.class),email);
		if(u==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	public User selectByUsernamePassword(String username,String password) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where username=? and password=?";
		return r.query(sql, new BeanHandler<User>(User.class),username,password);
	}
	public User selectByEmailPassword(String email,String password) throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where email=? and password=?";
		return r.query(sql, new BeanHandler<User>(User.class),email,password);
	}
	public void updateUserAddress(User user) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="update user set name=?,phone=?,address=?,province=?,city=? where id=?";
		r.update(sql,user.getName(),user.getPhone(),user.getAddress(),user.getProvince(),user.getCity(),user.getId());
		
	}

	public void updatePwd(User user) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="update user set password=? where id=?";
		r.update(sql,user.getPassword(),user.getId());
	}

	public void updateTotalPrice(int userid,double extra_price)throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		double current_price=selectUserTotalPrice(userid);
		String sql="update user set total_price=? where id=?";
		r.update(sql,current_price+extra_price,userid);
	}

	public double selectUserTotalPrice(int userid)throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select total_price from user where id=?";
		return r.query(sql,new ScalarHandler<Double>(),userid).doubleValue();
	}
	public int selectUserCount() throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select count(*) from user";
		return r.query(sql, new ScalarHandler<Long>()).intValue();
	}

	public List<User> selectUserList(int pageNo, int pageSize) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user limit ?,?";
		return r.query(sql, new BeanListHandler<User>(User.class),(pageNo-1)*pageSize,pageSize);
		
		
		
	}
	public long getUserId(String username,String pwd) throws SQLException{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select id from user where username=? and password=?";
		return r.query(sql,new ScalarHandler<Long>(),username,pwd);
	}
	public User selectById(int id) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where id=?";
		return r.query(sql, new BeanHandler<User>(User.class),id);
	}
	
	public void delete(int id) throws SQLException {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="delete from user where id = ?";
		r.update(sql,id);
	}
	
}
