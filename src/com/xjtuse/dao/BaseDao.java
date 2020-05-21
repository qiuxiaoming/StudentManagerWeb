package com.xjtuse.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.xjtuse.util.DbUtil;

/*
 * @author qgm
 * ����dao,��װ��������
 */

public class BaseDao {
	private DbUtil dbUtil=new DbUtil();
	
	//�ر����ݿ⣬�ͷ���Դ
	public void closeConnection(){
		dbUtil.closeConnection();
	}
	
	//������ѯ��������ѯ
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
	
	//�ı����ݿ����ݲ���
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
