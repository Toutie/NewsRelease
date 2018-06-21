package Test;

import DataBaseUtil.BaseDAOImpl;
import DataBaseUtil.DataBaseUtil;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDAOImpl bd = new BaseDAOImpl();
		String sql = "select * from student";
		int pageCount = bd.getPageCount(sql,1);
		System.out.println(pageCount);
		bd.queryPage(sql,1,2);
	}

}
