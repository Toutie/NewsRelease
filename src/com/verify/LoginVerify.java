package com.verify;

import com.bean.User;

public class LoginVerify {
	
	//��� ��֤�� �Ƿ���ȷ
	public static boolean codeVerify(String receive,String correct){
		if(receive.toLowerCase().equals(correct.toLowerCase())){
			return true;
		}else{
			return false;
		}
	}
	
	//��� �û��� ���� �Ƿ���ȷ
	public static boolean formVerify(String username,String password){
		if(username!=null&&!username.trim().equals("")&&password!=null&&!password.trim().equals("")){
			return true;
		}else{
			return false;
		}
	}
}
