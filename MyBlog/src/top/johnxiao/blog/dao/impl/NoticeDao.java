package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.INoticeDao;
import top.johnxiao.blog.dto.NoticeInfo;
import top.johnxiao.blog.dto.PageList;

public class NoticeDao implements INoticeDao{

	@Override
	public boolean insert(NoticeInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(NoticeInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NoticeInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<NoticeInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
