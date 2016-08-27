package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.ILabelDao;
import top.johnxiao.blog.dto.LabelInfo;
import top.johnxiao.blog.dto.PageList;

public class LabelDao implements ILabelDao{

	@Override
	public boolean insert(LabelInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LabelInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LabelInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<LabelInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
