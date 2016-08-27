package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IAlbumDao;
import top.johnxiao.blog.dto.AlbumInfo;
import top.johnxiao.blog.dto.PageList;

public class AlbumDao implements IAlbumDao{

	@Override
	public boolean insert(AlbumInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(AlbumInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AlbumInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<AlbumInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
