package top.johnxiao.blog.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import top.johnxiao.blog.core.DBUtil;
import top.johnxiao.blog.dao.IClickLikeDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.ClickLikeInfo;
import top.johnxiao.blog.dto.LabelInfo;
import top.johnxiao.blog.dto.PageList;

public class ClickLikeDao implements IClickLikeDao {

	@Override
	public boolean insert(ClickLikeInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "insert into clicklikeinfo(userId,liketype,likedId,likeDate,likeIsDel)values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUserId().getUserId());
			ps.setInt(2, model.getLikeType());
			ps.setInt(3, model.getLikedId());
			ps.setTimestamp(4, model.getLikeDate());
			ps.setBoolean(5, model.getLikeIsDel());
			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, null);
		}
		return flag;
	}

	@Override
	public boolean update(ClickLikeInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "update clicklikeinfo set userId=?,likeType=?,likedId=?,likeDate=?,likeIsDel=? where likeId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUserId().getUserId());
			ps.setInt(2, model.getLikeType());
			ps.setInt(3, model.getLikedId());
			ps.setTimestamp(4, model.getLikeDate());
			ps.setBoolean(5, model.getLikeIsDel());
			ps.setInt(6, model.getLikeId());
			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, null);
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "update clicklikeinfo set likeIsDel=1 where likeId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, null);
		}
		return flag;
	}

	@Override
	public ClickLikeInfo selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ClickLikeInfo likeinfo = null;
		String sql = "select * from clicklikeinfo where likeId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<ClickLikeInfo> list = getModel(rs);
			if (list.size() > 0) {
				likeinfo = (ClickLikeInfo) list.get(0);
			} else {
				likeinfo = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return likeinfo;
	}

	@Override
	public List<ClickLikeInfo> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClickLikeInfo> list = null;
		String sql = "select * from clicklikeinfo where likeIsDel=0";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<ClickLikeInfo> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClickLikeInfo> list = null;
		String sql = "select * from clicklikeinfo where likeIsDel=0";
		if (strWhere != null && "".equals(strWhere)) {
			sql = sql + " and " + strWhere;
		}
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	@Override
	public PageList<ClickLikeInfo> getProcList(String showFields,
			String tableName, String strWhere, String colName, int pageIndex,
			int pageSize) {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List list = null;
		PageList<ClickLikeInfo> page = null;

		String sql = "{call getProcList(?,?,?,?,?,?,?,?) }";
		try {
			// 获取连接，拼接SQL语句
			conn = DBUtil.getConn();
			cs = conn.prepareCall(sql);
			cs.setString(1, showFields);
			cs.setString(2, tableName);
			cs.setString(3, strWhere);
			cs.setString(4, colName);
			cs.setInt(5, pageIndex);
			cs.setInt(6, pageSize);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.INTEGER);
			rs = cs.executeQuery();

			list = getModel(rs);
			int tCount = cs.getInt(7);
			int pCount = cs.getInt(8);
			// 实例化对象，并设置存放的数据
			page = new PageList<ClickLikeInfo>();
			page.setSumCount(tCount);
			page.setPageCount(pCount);
			page.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, cs, rs);
		}
		return page;
	}

	@Override
	public List<ClickLikeInfo> getModel(ResultSet rs) {
		List<ClickLikeInfo> list = new ArrayList<ClickLikeInfo>();
		UserDao udao = new UserDao();
		try {
			if (rs != null) {
				while (rs.next()) {
					ClickLikeInfo cinfo = new ClickLikeInfo();
					cinfo.setLikeId(rs.getInt("likeId"));
					cinfo.setUserId(udao.selectById(rs.getInt("userId")));
					cinfo.setLikeType(rs.getInt("likeType"));
					cinfo.setLikeId(rs.getInt("likedId"));
					cinfo.setLikeDate(rs.getTimestamp("likeDate"));
					cinfo.setLikeIsDel(rs.getBoolean("likeIsDel"));
					list.add(cinfo);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		ClickLikeInfo clinfo = new ClickLikeInfo();
		ClickLikeDao cldao = new ClickLikeDao();
		UserDao udao = new UserDao();
		clinfo.setUserId(udao.selectById(1));
		clinfo.setLikeType(1);
		clinfo.setLikedId(2);
		clinfo.setLikeDate(new Timestamp(System.currentTimeMillis()));
		clinfo.setLikeIsDel(false);
//		clinfo.setLikeId(1);
//		cldao.insert(clinfo);
		
		if(cldao.delete(1)){
			System.out.println("删除成功");
		}
//		g更新
//		cldao.update(clinfo);
		
//		查询所有的内容
//		List list = cldao.selectAll();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
//		分页操作
		PageList page = cldao.getProcList("*", "clicklikeinfo", "likeIsDel=0", "likeId", 3, 5);
		System.out.println(page.getSumCount());
		System.out.println(page.getPageCount());
		for (int i = 0; i < page.getList().size(); i++) {
			ClickLikeInfo label = (ClickLikeInfo) page.getList().get(i);
			System.out.println(label.getLikeId() + " | "
					+ label.getUserId().getUserId() + " | "
					+ label.getLikeDate());
		}
	}

}
