package com.verify;

import com.bean.User;

public class LoginVerify {

	public static boolean codeVerify(String receive,String correct){
		if(receive.equals(correct)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean formVerify(User user){
		String username = user.getUsername();
		String password = user.getPassword();
		
		if(username!=null&&!username.trim().equals("")&&password!=null&&!password.trim().equals("")){
			return true;
		}else{
			return false;
		}
	}
}
