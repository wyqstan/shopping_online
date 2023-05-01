package service;

import dao.UserDao;
import model.Page;
import model.User;
import model.UserRecord;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserService {

	private UserDao uDao=new UserDao();
	public boolean Register(User user) throws UnsupportedEncodingException {
		try {
			if(uDao.isUsernameExist(user.getUsername())) {
				return false;
			}
			if(uDao.isEmailExist(user.getEmail())) {
				return false;
			}
			String username=user.getUsername();
			user.setUsername(new String(username.getBytes("ISO-8859-1"),"utf-8"));
			String name=user.getName();
			user.setName(new String(name.getBytes("ISO-8859-1"),"utf-8"));
			String address=user.getAddress();
			user.setAddress(new String(address.getBytes("ISO-8859-1"),"utf-8"));
			uDao.addUser(user);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public User login(String ue,String password) {
		User user=null;
		try {
			user = uDao.selectByUsernamePassword(ue, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			return user;
		}
		try {
			user=uDao.selectByEmailPassword(ue, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			return user;
		}
		return null;
	}
	public void login_record(UserRecord userRecord){
		try {
			uDao.login_record(userRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void userview(String username,String second,String goodname,String typename,Date date){
		try {
			uDao.userview(username,second,goodname,typename,date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void logout_record(UserRecord userRecord){
		try {
			uDao.logout_record(userRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateusersale(int id,String typename,int amount){
		try {
			uDao.updateusersale(typename,id,amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addusersale(int id){
		try {
			uDao.addusersale(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int selectusersale(String typename,int id){
		int sale=0;
		try {
			sale=(int)uDao.selectusersale(typename,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sale;
	}

	public int get_userid(String username,String pwd){
		long userid=-1;
		try {
			userid=uDao.getUserId(username,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int)userid;
	}

	public Page get_IPList(int pageNo){
		Page p=new Page();


		p.setPageNo(pageNo);
		int pageSize=7;
		int totalCount=0;
		try {
			totalCount=uDao.getIPCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(pageSize,totalCount);
		List list=null;
		try {
			list=uDao.selectIP(pageNo,pageSize);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	public void updateTotalPrice(int userid,double total_price){
		try {
			uDao.updateTotalPrice(userid,total_price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUserAddress(User user) {
		try {
			uDao.updateUserAddress(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updatePwd(User user) {
		try {
			uDao.updatePwd(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Page getUserPage(int pageNo) {
		Page p=new Page();
		
		
		p.setPageNo(pageNo);
		int pageSize=7;
		int totalCount=0;
		try {
			totalCount=uDao.selectUserCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(pageSize,totalCount);
		List list=null;
		try {
			list=uDao.selectUserList(pageNo,pageSize);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	public User selectById(int id) {
		User u=null;
		try {
			 u= uDao.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public boolean delete(int id) {
		try {
			uDao.delete(id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
}
