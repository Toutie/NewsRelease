package com.verify;

import com.bean.User;

public class LoginVerify {
	
	//检查 验证码 是否正确
	public static boolean codeVerify(String receive,String correct){
		if(receive.toLowerCase().equals(correct.toLowerCase())){
			return true;
		}else{
			return false;
		}
	}
	
	//检查 用户名 密码 是否正确
	public static boolean formVerify(String username,String password){
		if(username!=null&&!username.trim().equals("")&&password!=null&&!password.trim().equals("")){
			return true;
		}else{
			return false;
		}
	}
}
