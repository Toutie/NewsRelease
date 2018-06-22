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
	
	public static boolean formVerify(String username,String password){

		
		if(username!=null&&!username.trim().equals("")&&password!=null&&!password.trim().equals("")){
			return true;
		}else{
			return false;
		}
	}
}
