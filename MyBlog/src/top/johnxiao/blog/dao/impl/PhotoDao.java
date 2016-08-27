package top.johnxiao.blog.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dao.IPhotoDao;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.PhotoInfo;

public class PhotoDao implements IPhotoDao{

	@Override
	public boolean insert(PhotoInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PhotoInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhotoInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhotoInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhotoInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<PhotoInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhotoInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
