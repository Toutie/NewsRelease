package DataBaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DataBaseUtil {

	//��������
	private static Connection conn = null;
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//���������ļ�
	static{
		try {
			String path = GetWebProjectRealPathTool.getRootPath();
			path = path + "/DataBase.cfg.xml";
			
			System.out.println("path");
			List<DataBaseCfg> dbCfgs = ReadCfgByDom.getDbCfg(path);
			DataBaseCfg dbcfg = new DataBaseCfg();
			//�õ���һ�������ļ���Ϣ
			dbcfg = dbCfgs.get(0);
			driver = dbcfg.getDriver();
			url = dbcfg.getUrl();
			username = dbcfg.getUsername();
			password = dbcfg.getPassword();
			
			System.out.println("Load Configuration Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Load configuration Failure");
		}
	}
	
	//�����ݿ�
	public static boolean openDataBase(){
		try {
			//������������
			Class.forName(driver);
			//getConnection()����,����Mysql���ݿ�
			conn = DriverManager.getConnection(url,username,password);
			if(!conn.isClosed()){
				System.out.println("Open Database Successfully");
				return true;
			}
			
		}catch(ClassNotFoundException cnfex) {
			System.out.println("Load Driver Failure");
			cnfex.printStackTrace();
		}catch(SQLException sqlex) {
			System.err.println("Connect Database Failure");
			sqlex.printStackTrace();
		}
		
		return false;
	}
	
	//�ر����ݿ�
	public static boolean closeDataBase(){
		try {
			if(conn != null){
				conn.close();
				System.out.println("Close Database successfully");
				return true;
			}
			else{
				System.out.println("DataBase Not Opened");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Close Database Failure");
			return false;
		}
	}
	
	//��ȡConnection����
	public static Connection getConnection(){
		openDataBase();
		return conn;
	}
}
