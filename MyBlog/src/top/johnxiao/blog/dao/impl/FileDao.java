package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IFileDao;
import top.johnxiao.blog.dto.FileInfo;
import top.johnxiao.blog.dto.PageList;

public class FileDao implements IFileDao{

	@Override
	public boolean insert(FileInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(FileInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FileInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<FileInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
