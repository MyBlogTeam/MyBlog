package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.ICollectDao;
import top.johnxiao.blog.dto.CollectInfo;
import top.johnxiao.blog.dto.PageList;

public class CollectDao implements ICollectDao{

	@Override
	public boolean insert(CollectInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CollectInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CollectInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<CollectInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
