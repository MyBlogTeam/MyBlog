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
import top.johnxiao.blog.dao.ILabelArticleDao;
import top.johnxiao.blog.dto.LabelArticle;
import top.johnxiao.blog.dto.PageList;

public class LabelArticleDao implements ILabelArticleDao {

	@Override
	public boolean insert(LabelArticle model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "insert into label_article(articleId,labelId,laIsDel)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getArticle().getArticleId());
			ps.setInt(2, model.getLabel().getLabelId());
			ps.setBoolean(3, model.getLaIsDel());
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
	public boolean update(LabelArticle model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "update label_article set articleId=?,labelId=?,laIsDel=? where LaId=?";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getArticle().getArticleId());
			ps.setInt(2, model.getLabel().getLabelId());
			ps.setBoolean(3, model.getLaIsDel());
			ps.setInt(4, model.getLaId());
			int i = ps.executeUpdate();
			if (i > 0) {
				bool = true;
			} else {
				bool = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		String sql = "update label_article set laIsDel=1 where laId=?";
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
	public LabelArticle selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LabelArticle la = null;
		String sql = "select * from label_article where laId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<LabelArticle> list = getModel(rs);
			if (list.size() > 0) {
				la = (LabelArticle) list.get(0);
			} else {
				la = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return la;
	}

	@Override
	public List<LabelArticle> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<LabelArticle> list = null;
		String sql = "select * from label_article where laIsDel=0";
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
	public List<LabelArticle> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<LabelArticle> list = null;
		String sql = "select * from label_article where laIsDel=0";
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
	public PageList<LabelArticle> getProcList(String showFields,
			String tableName, String strWhere, String colName, int pageIndex,
			int pageSize) {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List list = null;
		PageList<LabelArticle> page = null;

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
			page = new PageList<LabelArticle>();
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
	public List<LabelArticle> getModel(ResultSet rs) {
		List<LabelArticle> list = new ArrayList<LabelArticle>();
		LabelDao ldao = new LabelDao();
		ArticleDao adao = new ArticleDao();
		try {
			if (rs != null) {
				while (rs.next()) {
					LabelArticle la = new LabelArticle();
					la.setLaId(rs.getInt("laId"));
					la.setArticle(adao.selectById(rs.getInt("articleId")));
					la.setLabel(ldao.selectById(rs.getInt("labelId")));
					la.setLaIsDel(rs.getBoolean("laIsDel"));
					list.add(la);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
