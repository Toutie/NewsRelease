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
	
	//根据 类型type 查询 第curPage页 的 pageSize 条新闻
	public List<News> queryNewsByType(String type,int curPage,int pageSize){
		String sql = "select * from news where type='"+ type + "' order by time desc";
		System.out.println(sql);
		List resultList = this.queryPage(sql, curPage, pageSize);
		List<News> newsList = new ArrayList<News>();
		for(int i=0;i<resultList.size();i++){
			List<String> tempList = (List<String>) resultList.get(i);
			
			if(tempList.size()>0){
				News news = new News();
				news.setNewsid(tempList.get(0));
				news.setType(tempList.get(1));
				news.setTitle(tempList.get(2));
				news.setUsername(tempList.get(3));
				news.setContent(tempList.get(4));
				news.setTime(tempList.get(5));
				news.setClick(tempList.get(6));
				
				newsList.add(news);
			}
			
		}
		
		return newsList;
	}
	
	//用户点击新闻链接后更新点击量
	public boolean updateClick(String newsid) {
		// TODO Auto-generated method stub
		String sql = "update news set click=click+1 where newsid='" + newsid + "'";
		return super.update(sql);
	}
	
	public List<News> queryNewsByType(String type) {
		// TODO Auto-generated method stub
		String sql = "select * from news where type='" + type + "'";
		List resultList = super.query(sql);
		List<News> newsList = new ArrayList<News>();
		for(int i=0; i<resultList.size(); i++){
			List<String> tempList = (List<String>) resultList.get(i);
			
			if(tempList.size()>0){
				News news = new News();
				news.setNewsid(tempList.get(0));
				news.setType(tempList.get(1));
				news.setTitle(tempList.get(2));
				news.setUsername(tempList.get(3));
				news.setContent(tempList.get(4));
				news.setTime(tempList.get(5));
				news.setClick(tempList.get(6));
				
				newsList.add(news);
			}
		}
		return newsList;
	}
	
	//获取该类型新闻的总页数
	public int getNewsPage(String type,int pageSize){
		String sql = "select * from news where type='" + type +"'";
		System.out.println("sql:" + sql);
		
		return super.getPageCount(sql, pageSize);
	}
}
