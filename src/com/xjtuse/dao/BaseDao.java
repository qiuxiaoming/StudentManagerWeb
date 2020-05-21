package com.xjtuse.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.xjtuse.util.DbUtil;

/*
 * @author qgm
 * 基础dao,封装基本操作
 */

public class BaseDao {
	private DbUtil dbUtil=new DbUtil();
	
	//关闭数据库，释放资源
	public void closeConnection(){
		dbUtil.closeConnection();
	}
	
	//基础查询，多条查询
	public ResultSet query(String sql){
		List<ResultSet> ret = new ArrayList<ResultSet>();
		
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			return prepareStatement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//改变数据库内容操作
	public boolean update(String sql){
		try {
			return dbUtil.getConnection().prepareStatement(sql).executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
