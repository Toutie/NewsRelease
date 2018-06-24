package StringUtil;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	public static String transfer(String str) throws UnsupportedEncodingException{
		
		return new String(str.getBytes("iso-8859-1"),"utf-8");
	}
}
