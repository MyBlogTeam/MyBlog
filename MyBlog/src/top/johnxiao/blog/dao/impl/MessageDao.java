package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IMessageDao;
import top.johnxiao.blog.dto.MessageInfo;
import top.johnxiao.blog.dto.PageList;

public class MessageDao implements IMessageDao{

	@Override
	public boolean insert(MessageInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MessageInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MessageInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<MessageInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
