package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.ITypeArticleDao;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.TypeArticle;

public class TypeArticleDao implements ITypeArticleDao{

	@Override
	public boolean insert(TypeArticle model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeArticle model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeArticle selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeArticle> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeArticle> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<TypeArticle> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeArticle> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
