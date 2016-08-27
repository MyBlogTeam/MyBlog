package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IArticleDao;
import top.johnxiao.blog.dto.ArticleInfo;
import top.johnxiao.blog.dto.PageList;

public class ArticleDao implements IArticleDao{

	@Override
	public boolean insert(ArticleInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ArticleInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArticleInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<ArticleInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
