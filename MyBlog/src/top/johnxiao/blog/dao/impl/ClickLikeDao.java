package top.johnxiao.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import top.johnxiao.blog.core.DBUtil;
import top.johnxiao.blog.dao.IClickLikeDao;
import top.johnxiao.blog.dto.ClickLikeInfo;
import top.johnxiao.blog.dto.PageList;

public class ClickLikeDao implements IClickLikeDao{

	@Override
	public boolean insert(ClickLikeInfo model) {
		Connection conn =null;
		PreparedStatement ps = null;
		boolean flag=false;
		try {
			conn=DBUtil.getConn();
			String sql="";
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(ClickLikeInfo model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClickLikeInfo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClickLikeInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClickLikeInfo> selectByWhere(String strWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<ClickLikeInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClickLikeInfo> getModel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}
