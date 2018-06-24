package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.bean.News;

import DataBaseUtil.BaseDAOImpl;

public class NewsDaoImpl extends BaseDAOImpl{

	public NewsDaoImpl(){}
	
	//发布新闻，插入数据
	public boolean releaseNews(News news){
		
		String sql = "insert into news (type,title,content,username,time) values"+
				"('"+news.getType()+"','"+news.getTitle()+"','"+news.getContent()+"','"
				+news.getUsername()+"','"+news.getTime()+"');";
		
		System.out.println("sql:"+sql);
		
		return super.update(sql);
		
	}
	
	//查询单条新闻
	public News queryNews(String newsid){
		String sql = "select * from news where newsid ='"+newsid+"';";
		System.out.println("sql:"+sql);
		
		List<News> list = new ArrayList<News>();
		List listRs = super.query(sql);
		
		
		for(int i=0;i<listRs.size();i++){
			List<String> rowData = (List<String>)listRs.get(i);
			
			if(rowData.size()>0){
				News news = new News();
				news.setNewsid((String)rowData.get(0));
				news.setType((String)rowData.get(1));
				news.setTitle((String)rowData.get(2));
				news.setUsername((String)rowData.get(3));
				news.setContent((String)rowData.get(4));
				news.setTime((String)rowData.get(5));
				news.setClick((String)rowData.get(6));
				list.add(news);
			}
	        
		}
		
		News news = null;
		if(list.size()>0){
			news = (News)list.get(0);
		}
		
		return news;
	}
}
