package StringUtil;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class StringUtil {

	public static String transfer(String str) throws UnsupportedEncodingException{
		
		return new String(str.getBytes("iso-8859-1"),"utf-8");
	}
	
	public static String readJson(String key) throws IOException{
		File file=new File(Thread.currentThread().getContextClassLoader().getResource("").toString()
				+"outjs.json");
		String content= FileUtils.readFileToString(file,"UTF-8");
		
		JSONObject jsonObject=new JSONObject(content);
		
		System.out.println(jsonObject.getString(key));
		
		return jsonObject.getString(key);
	}
	
	//������ת��Ϊ�����û��ܿ����ı�����ʽ
	public static String typeToChineseStr(String type){
		String resultStr = null;
		switch(type){
			case "t001":resultStr = "ѧԺ��̬"; break;
			case "t002":resultStr = "ѧ������"; break;
			case "t003":resultStr = "ѧ�罨��"; break;
			default:System.out.println("typeȡֵ�����⣡");break;
		}
		return resultStr;
	}
}
