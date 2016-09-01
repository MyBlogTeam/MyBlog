package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.ILinkDao;
import top.johnxiao.blog.dto.LinkInfo;
import top.johnxiao.blog.dto.PageList;

public class LinkDao implements ILinkDao{

	@Override
	public boolean insert(LinkInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LinkInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LinkInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LinkInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<LinkInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LinkInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
