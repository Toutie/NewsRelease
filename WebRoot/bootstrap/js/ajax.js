function getXHR(){
	var xmlHttp;
	try{
		xmlHttp = new xmlHttpRequest();
	}catch(e){
		try{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){
			alter("你的浏览器不支持ajax，请使用现代浏览器");
			return false;
		}
	}
	return xmlHttp;
}
	
function login(){
	var xhr = getXHR();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rt = xhr.responseText;
			if (rt == "login_success") {
				alert("login_success");
			}else if (rt == "login_fail") {
				alert("login_fail");
			}
		}
	}
	
	var userName = document.getElementById("userName").value;
	var psw = document.getElementById("psw").value;
	var type = document.getElementById("type").value;
	var param = "userName="+userName+"&"+"psw="+psw+"&"+"type="+type;

	xhr.open("POST","./login");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send(param);
}
function test(){
	alert("测试");
}