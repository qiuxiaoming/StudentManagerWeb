package com.xjtuse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xjtuse.model.Clazz;
import com.xjtuse.model.Page;
import com.xjtuse.util.StringUtil;

/*
 * 
 * 班级信息数据库操作
 * */
public class ClazzDao extends BaseDao {
	public List<Clazz> getClazzList(Clazz clazz,Page page){
		List<Clazz> ret = new ArrayList<Clazz>();
		
		String sql = "select * from s_clazz";
		if(!StringUtil.isEmpty(clazz.getName())){
			sql += "where name like '% "+clazz.getName()+" '";
		}
		sql += " limit " +page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql);
		
		try {
			while(resultSet.next()){
				Clazz cl = new Clazz();
				cl.setId(resultSet.getInt("id"));
				cl.setName(resultSet.getString("name"));
				cl.setInfo(resultSet.getString("info"));
				ret.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ret;
	}
}
