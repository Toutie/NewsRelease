package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.bean.News;
import com.bean.Notice;

import DataBaseUtil.BaseDAOImpl;


public class NoticeDaoImpl extends BaseDAOImpl{

	public NoticeDaoImpl(){}
	
	public boolean releaseNotice(Notice notice){
		
		String sql = "insert into notice (title,sender,receiver,time,content) values"+
				"('"+notice.getTitle()+"','"+notice.getSender()+"','"+notice.getReceiver()+"','"
				+notice.getTime()+"','"+notice.getContent()+"');";
		
		System.out.println("sql:"+sql);
		
		return super.update(sql);
		
	}
	
	//得到通知页数（带参数）
	public int getNoticePage(int pageSize){
		
		String sql = "select * from notice";
		System.out.println("sql:"+sql);
		
		return super.getPageCount(sql, pageSize);
	}
	
	
	//查询单条通知
	public Notice queryNotice(String noticeid){
		String sql = "select * from notice where noticeid ='"+noticeid+"';";
		System.out.println("sql:"+sql);
		
		List<Notice> list = new ArrayList<Notice>();
		List listRs = super.query(sql);
		
		for(int i=0;i<listRs.size();i++){
			List<String> rowData = (List<String>)listRs.get(i);
			
			if(rowData.size()>0){
				Notice notice = new Notice();
				notice.setNoticeid((String)rowData.get(0));
				notice.setTitle((String)rowData.get(1));
				notice.setSender((String)rowData.get(2));
				notice.setReceiver((String)rowData.get(3));
				notice.setTime((String)rowData.get(4));
				notice.setContent((String)rowData.get(5));
				
				list.add(notice);
			}
	        
		}
		
		Notice notice = null;
		if(list.size()>0){
			notice = (Notice)list.get(0);
		}
		
		return notice;
	}
	
	//查询多条通知(带参数)
	public List<Notice> queryNotices(int curPage,int pageSize,String username){
		String sql = "select * from notice where receiver='*' or receiver='"+username+
				"' order by time desc";
		System.out.println("sql:"+sql);
		
		List<Notice> list = new ArrayList<Notice>();
		List listRs = super.queryPage(sql, curPage, pageSize);
		
		for(int i=0;i<listRs.size();i++){
			List<String> rowData = (List<String>)listRs.get(i);
			
			if(rowData.size()>0){
				Notice notice = new Notice();
				notice.setNoticeid((String)rowData.get(0));
				notice.setTitle((String)rowData.get(1));
				notice.setSender((String)rowData.get(2));
				notice.setReceiver((String)rowData.get(3));
				notice.setTime((String)rowData.get(4));
				notice.setContent((String)rowData.get(5));
				
				list.add(notice);
			}
	        
		}

		return list;
	}
}
