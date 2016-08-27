package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IDiscussDao;
import top.johnxiao.blog.dto.DiscussInfo;
import top.johnxiao.blog.dto.PageList;

public class DiscussDao implements IDiscussDao{

	@Override
	public boolean insert(DiscussInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DiscussInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DiscussInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscussInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscussInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<DiscussInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscussInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
