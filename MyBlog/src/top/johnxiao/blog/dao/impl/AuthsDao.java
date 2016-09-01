package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IAuthsDao;
import top.johnxiao.blog.dto.AuthsInfo;
import top.johnxiao.blog.dto.PageList;

public class AuthsDao implements IAuthsDao{

	@Override
	public boolean insert(AuthsInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(AuthsInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AuthsInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthsInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthsInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<AuthsInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthsInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
