package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IBlogDao;
import top.johnxiao.blog.dto.BlogInfo;
import top.johnxiao.blog.dto.PageList;

public class BlogDao implements IBlogDao{

	@Override
	public boolean insert(BlogInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BlogInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BlogInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<BlogInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
