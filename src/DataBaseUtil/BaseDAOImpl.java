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
	 * 查询一组记录
	 * @param sql String sql语句
	 * @param values Object[] 参数值数组
	 * @return List 一组结果对象
	 * @throws Exception
	 */
	public List query(String sql) {
		conn = DataBaseUtil.getConnection();
		List alist = new ArrayList<List<String>>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			//获得结果集结构信息,元数据  
			ResultSetMetaData md = rs.getMetaData();
			//获得列数
			int columnCount = md.getColumnCount();
			while(rs.next()){
				List<String> rowData = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) { 
					System.out.print(rs.getString(i)+"  ");	//打印列数据
					rowData.add(rs.getString(i));
		        }
				alist.add(rowData);
				System.out.println();//跳行
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
	 * @param sql String,sql语句
	 * @param pageSize int,页面大小即一页几条
	 * @return pageCount int,页数
	 */
	//得到需要分几页
	public int getPageCount(String sql,int pageSize){
		int pageCount = 0;
		conn = DataBaseUtil.getConnection();
		try{
			Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery(sql);
			rs.last();	//跳转到最后一条记录
			int size = rs.getRow();	//得到总记录条数
			System.out.println("RecordSize:"+size);
			pageCount = (size%pageSize==0)?(size/pageSize):(size/pageSize+1);
			DataBaseUtil.closeDataBase();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pageCount;
	}
	
	/*
	 *@param sql String,sql语句
	 *@param curPage int,当前页面数即第几页
	 *@param pageSize int, 页面大小即一页几条
	 */
	//查询指定条数的数据
	public List queryPage(String sql,int curPage,int pageSize) {
		conn = DataBaseUtil.getConnection();
		List alist = new ArrayList<List<String>>();
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs= statement.executeQuery(sql);
			//获得结果集结构信息,元数据  
			ResultSetMetaData md = rs.getMetaData();
			//获得列数
			int columnCount = md.getColumnCount();
			int rowBegin = (curPage-1)*pageSize+1;
			System.out.println("RowBegin:"+rowBegin);
			rs.absolute(rowBegin-1);      //把结果集指针调整到当前页应该显示的记录的开始的前一条
			while(rs.next()&&pageSize>0){
				List<String> rowData = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) { 
					System.out.print(rs.getString(i)+"  ");	//打印列数据
					rowData.add(rs.getString(i));
		        }
				alist.add(rowData);
				System.out.println();//跳行
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
