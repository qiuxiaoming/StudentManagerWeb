package com.xjtuse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.xjtuse.model.Admin;

/*
 * @author qgm
 * 管理员数据库操作封装
 */
public class AdminDao extends BaseDao {

	public Admin login(String name,String passWord){
		String sql="Select * from s_admin where name = '" +name+ "' and passWord = '" +passWord+"'";
		ResultSet resultSet=query(sql);
		
		try {
			if(resultSet.next()){
				Admin admin = new Admin();
				admin.setId(resultSet.getInt("id"));
				admin.setName(resultSet.getString("name"));
				admin.setPassWord(resultSet.getString("passWord"));
				admin.setStatus(resultSet.getInt("status"));
				return admin;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
