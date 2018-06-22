function getXHR(){
	var xmlhttp;
	
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	if(xmlhttp!=null)
		return xmlhttp;
	else{
		alert("你的浏览器不支持AJAX,请使用现代浏览器,如Chrome、Firefox等,或升级你的浏览器，以保证正常使用")
		return false;
	}
		
}

function getVerifyCode(){
	var xhr = getXHR();
	
	xhr.open("POST","servlet/VerifyCodeServlet");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send();
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rt = xhr.responseText;
			console.log(rt);
			var verificationCode = document.getElementById("verificationCode");
			verificationCode.value = rt;
		}
	}
}
	
function login(){
	var xhr = getXHR();

	var f = document.getElementById("loginForm");	//得到登陆表单
	var userName = f.username.value;
	var password = f.password.value;
	var verification = f.verification.value;
	
	var param = "username="+userName+"&"+"password="+password+"&"+"verification="+verification;

	console.log("param:"+param);
	
	xhr.open("POST","servlet/LoginServlet");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send(param);
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rt = xhr.responseText;
			console.log(rt);
			if (rt == "login000") {	//登陆成功
				location.href = "console/main.jsp";
				return true;
			}else if (rt == "login001") {	//账号或密码错误
				alert("账号或密码错误");
			}else if (rt == "login002") {	//验证码错误
				alert("验证码错误");
			}else if (rt == "login003") {	//格式错误
				alert("错误，请检查输入是否为空");
			}
			
			//重新得到验证码
			getVerifyCode();
		}
	}
}

function test(){
	alert("测试");
}