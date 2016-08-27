package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.ILabelArticleDao;
import top.johnxiao.blog.dto.LabelArticle;
import top.johnxiao.blog.dto.PageList;

public class LabelArticleDao implements ILabelArticleDao{

	@Override
	public boolean insert(LabelArticle model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LabelArticle model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LabelArticle selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelArticle> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelArticle> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<LabelArticle> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelArticle> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
