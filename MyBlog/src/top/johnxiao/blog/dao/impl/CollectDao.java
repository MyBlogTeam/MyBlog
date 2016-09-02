package top.johnxiao.blog.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import top.johnxiao.blog.core.DBUtil;
import top.johnxiao.blog.dao.ICollectDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.CollectInfo;
import top.johnxiao.blog.dto.PageList;

public class CollectDao implements ICollectDao {

	@Override
	public boolean insert(CollectInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "insert into collectinfo(userId,articleId,collectDate,collectIsDel)values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setInt(2, model.getArticle().getArticleId());
			ps.setTimestamp(3, model.getCollectDate());
			ps.setBoolean(4, model.getCollectIsDel());
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
	public boolean update(CollectInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		String sql = "update collectinfo set userId=?,articleId=?,collectDate=?,collectIsDel=? where collectId";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setInt(2, model.getArticle().getArticleId());
			ps.setTimestamp(3, model.getCollectDate());
			ps.setBoolean(4, model.getCollectIsDel());
			ps.setInt(5, model.getCollectId());
			int i = ps.executeUpdate();
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
		String sql = "update collectinfo set collectIsDel=1 where collectId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public CollectInfo selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CollectInfo collect = null;
		String sql = "select * from collectinfo where collectId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<CollectInfo> list = getModel(rs);
			if (list.size() > 0) {
				collect = (CollectInfo) list.get(0);
			} else {
				collect = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return collect;
	}

	@Override
	public List<CollectInfo> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CollectInfo> list = null;
		String sql = "select * from collectinfo where collectIsDel=0";
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
	public List<CollectInfo> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CollectInfo> list = null;
		String sql = "select * from collectinfo where collectIsDel=0";
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
	public PageList<CollectInfo> getProcList(String showFields,
			String tableName, String strWhere, String colName, int pageIndex,
			int pageSize) {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List list = null;
		PageList page = null;

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
			page = new PageList<AdminInfo>();
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
	public List<CollectInfo> getModel(ResultSet rs) {
		List<CollectInfo> list = new ArrayList<CollectInfo>();
		UserDao udao = new UserDao();
		ArticleDao adao = new ArticleDao();
		try {
			if (rs != null) {
				while (rs.next()) {
					CollectInfo cinfo = new CollectInfo();
					cinfo.setCollectId(rs.getInt("collectId"));
					cinfo.setUser(udao.selectById(rs.getInt("userId")));
					cinfo.setArticle(adao.selectById(rs.getInt("articleId")));
					cinfo.setCollectDate(rs.getTimestamp("collectDate"));
					cinfo.setCollectIsDel(rs.getBoolean("collectIsDel"));
					list.add(cinfo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
