package top.johnxiao.blog.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import top.johnxiao.blog.core.DBUtil;
import top.johnxiao.blog.dao.IUserDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.BlogInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserInfo;

public class UserDao implements IUserDao {

	@Override
	public boolean insert(UserInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<UserInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
