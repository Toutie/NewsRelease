package DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDAOImpl {

	private static Connection conn = null;
	public BaseDAOImpl(){}
	
	/*
	 * ��ѯһ���¼
	 * @param sql String sql���
	 * @param values Object[] ����ֵ����
	 * @return List һ��������
	 * @throws Exception
	 */
	public List query(String sql) {
		conn = DataBaseUtil.getConnection();
		List alist = new ArrayList<List<String>>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			//��ý�����ṹ��Ϣ,Ԫ����  
			ResultSetMetaData md = rs.getMetaData();
			//�������
			int columnCount = md.getColumnCount();
			while(rs.next()){
				List<String> rowData = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) { 
					System.out.print(rs.getString(i)+"  ");	//��ӡ������
					rowData.add(rs.getString(i));
		        }
				alist.add(rowData);
				System.out.println();//����
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		  }finally{
			  DataBaseUtil.closeDataBase();
		  }

		return alist;
	}
	
	public  boolean update(String sql) {
		conn = DataBaseUtil.getConnection();
		try {
			 Statement statement = conn.createStatement();
			 statement.executeUpdate(sql);
			 System.out.println("Update Successfully");
			 conn.close();
			 return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update Failure");
		}finally{
			DataBaseUtil.closeDataBase();
		}	
		return false;
	}
	/*
	 * @param sql String,sql���
	 * @param pageSize int,ҳ���С��һҳ����
	 * @return pageCount int,ҳ��
	 */
	//�õ���Ҫ�ּ�ҳ
	public int getPageCount(String sql,int pageSize){
		int pageCount = 0;
		conn = DataBaseUtil.getConnection();
		try{
			Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery(sql);
			rs.last();	//��ת�����һ����¼
			int size = rs.getRow();	//�õ��ܼ�¼����
			System.out.println("RecordSize:"+size);
			pageCount = (size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			DataBaseUtil.closeDataBase();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pageCount;
	}
	
	/*
	 *@param sql String,sql���
	 *@param curPage int,��ǰҳ�������ڼ�ҳ
	 *@param pageSize int, ҳ���С��һҳ����
	 */
	//��ѯָ������������
	public List queryPage(String sql,int curPage,int pageSize) {
		conn = DataBaseUtil.getConnection();
		List alist = new ArrayList<List<String>>();
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs= statement.executeQuery(sql);
			//��ý�����ṹ��Ϣ,Ԫ����  
			ResultSetMetaData md = rs.getMetaData();
			//�������
			int columnCount = md.getColumnCount();
			int rowBegin = (curPage-1)*pageSize+1;
			System.out.println("RowBegin:"+rowBegin);
			rs.absolute(rowBegin-1);      //�ѽ����ָ���������ǰҳӦ����ʾ�ļ�¼�Ŀ�ʼ��ǰһ��
			while(rs.next()&&pageSize>0){
				List<String> rowData = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) { 
					System.out.print(rs.getString(i)+"  ");	//��ӡ������
					rowData.add(rs.getString(i));
		        }
				alist.add(rowData);
				System.out.println();//����
				pageSize--;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		  }finally{
			  DataBaseUtil.closeDataBase();
		  }

		return alist;
	}

}
