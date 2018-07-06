package DataBaseUtil;

import java.io.File;

public class GetWebProjectRealPathTool {
	/**
	 * ��ȡ��Ŀ�ڷ������е���ʵ·���Ĺ�����
	 * ������web��Ŀ�У���ȡ��Ŀʵ��·������ѷ�ʽ����windows��linuxϵͳ�¾�������ʹ��
	 */
	
	//��ȡ��Ŀ�ĸ�·��
	public static String classPath = Thread.currentThread().getContextClassLoader().getResource("").toString();
	//����Ŀ�ĸ�·�����н������õ���Ŀ·��
	
	public static String getRootPath() {
		String rootPath = "";
		//windows��
		if("\\".equals(File.separator)){
			System.out.println("windows");
			rootPath = classPath.substring(1,classPath.indexOf("/WEB-INF/classes"));
			rootPath = rootPath.replace("/", "\\");
		}
		//linux��
		if("/".equals(File.separator)){
			System.out.println("linux");
			rootPath = classPath.substring(0,classPath.indexOf("/WEB-INF/classes"));
			rootPath = rootPath.replace("\\", "/");
		}
		return rootPath;
	}

}
