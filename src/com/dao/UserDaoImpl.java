package com.dao;
import java.util.ArrayList;
import java.util.List;
import com.bean.User;
import DataBaseUtil.BaseDAOImpl;

public class UserDaoImpl extends BaseDAOImpl{

	public UserDaoImpl(){}
	
	//验证登陆
	public User isValid(String username,String password){
		List<User> list = new ArrayList<User>();
		
		String sql = "select * from user where username='"+username+"' and "
				+"password='"+password+"'";
		
		List listRs = super.query(sql);
			
		for(int i=0;i<listRs.size();i++){
			List<String> rowData = (List<String>)listRs.get(i);
			
			if(rowData.size()>0){
				User user = new User();
				user.setUsername((String)rowData.get(0));
				user.setPassword((String)rowData.get(1));
				user.setName((String)rowData.get(2));
				user.setSex((String)rowData.get(3));
				user.setBirthday((String)rowData.get(4));
				user.setIdentity((String)rowData.get(5));
				user.setGrade((String)rowData.get(6));
				user.setIsNews((String)rowData.get(7));
				user.setIsNotice((String)rowData.get(8));
				list.add(user);
			}
	        
		}
		
		User user = null;
		if(list.size()>0){
			user = (User)list.get(0);
		}
		
		return user;
	}
	
	//按主键查找用户
	public List<User> queryUsers(String username){
		List<User> list = new ArrayList<User>();
		
		String sql = "select * from user where username like '%"+username+"%';";
		System.out.println("sql:"+sql);
		
		List listRs = super.query(sql);
			
		for(int i=0;i<listRs.size();i++){
			List<String> rowData = (List<String>)listRs.get(i);
			
			if(rowData.size()>0){
				User user = new User();
				user.setUsername((String)rowData.get(0));
				user.setPassword((String)rowData.get(1));
				user.setName((String)rowData.get(2));
				user.setSex((String)rowData.get(3));
				user.setBirthday((String)rowData.get(4));
				user.setIdentity((String)rowData.get(5));
				user.setGrade((String)rowData.get(6));
				user.setIsNews((String)rowData.get(7));
				user.setIsNotice((String)rowData.get(8));
				list.add(user);
			}
	        
		}
		
		
		return list;
	}
}
