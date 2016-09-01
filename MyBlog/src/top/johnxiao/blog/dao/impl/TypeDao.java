package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.ITypeDao;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.TypeInfo;

public class TypeDao implements ITypeDao{

	@Override
	public boolean insert(TypeInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<TypeInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
