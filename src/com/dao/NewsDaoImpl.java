package com.dao;

import com.bean.News;

import DataBaseUtil.BaseDAOImpl;

public class NewsDaoImpl extends BaseDAOImpl{

	public NewsDaoImpl(){}
	
	//�������ţ���������
	public boolean releaseNews(News news){
		
		String sql = "insert into news (type,title,content,username,time) values"+
				"('"+news.getType()+"','"+news.getTitle()+"','"+news.getContent()+"','"
				+news.getUsername()+"','"+news.getTime()+"');";
		
		System.out.println("sql:"+sql);
		
		return super.update(sql);
		
	}
}
