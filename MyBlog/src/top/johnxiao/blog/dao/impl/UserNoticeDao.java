package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IUserNoticeDao;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserNotice;

public class UserNoticeDao implements IUserNoticeDao{

	@Override
	public boolean insert(UserNotice model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserNotice model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserNotice selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserNotice> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserNotice> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<UserNotice> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserNotice> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
