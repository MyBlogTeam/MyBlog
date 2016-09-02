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
import top.johnxiao.blog.dao.ILabelDao;
import top.johnxiao.blog.dto.LabelInfo;
import top.johnxiao.blog.dto.MessageInfo;
import top.johnxiao.blog.dto.PageList;

public class LabelDao implements ILabelDao {

	@Override
	public boolean insert(LabelInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "insert into labelinfo(userId,labelName,lableIsDel) values(?,?,0)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setString(2, model.getLabelName());
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
	public boolean update(LabelInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		String sql = "update labelInfo set userId=?,labelName=?,lableIsDel=? where labelId=?";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setString(2, model.getLabelName());
			ps.setBoolean(3, model.getLabelIsDel());
			ps.setInt(4, model.getLabelId());
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

		String sql = "update labelInfo set adminIsDel=1 where labelId=?";
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
	public LabelInfo selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LabelInfo Label = null;
		String sql = "select * from LabelInfo where LabelId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if (list.size() > 0) {
				Label = (LabelInfo) list.get(0);
			} else {
				Label = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return Label;
	}

	@Override
	public List<LabelInfo> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<LabelInfo> list = null;
		String sql = "select * from LabelInfo where LableIsDel=0";
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
	public List<LabelInfo> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<LabelInfo> list = null;
		String sql = "select * from LabelInfo where LableIsDel=0";
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
	public PageList<LabelInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<LabelInfo> list = null;
		PageList<LabelInfo> page = null;

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
			page = new PageList<LabelInfo>();
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
	public List<LabelInfo> getModel(ResultSet rs) {
		List<LabelInfo> list = new ArrayList<LabelInfo>();
		UserDao udao = new UserDao();
		try {
			if (rs != null) {
				while (rs.next()) {
					LabelInfo linfo = new LabelInfo();
					linfo.setLabelId(rs.getInt("labelId"));
					linfo.setUser(udao.selectById(rs.getInt("userId")));
					linfo.setLabelName(rs.getString("labelName"));
					linfo.setLabelIsDel(rs.getBoolean("lableIsDel"));
					list.add(linfo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		LabelInfo linfo = new LabelInfo();
		LabelDao ldao = new LabelDao();
		UserDao udao = new UserDao();
		linfo.setUser(udao.selectById(1));
		linfo.setLabelName("标签");
		linfo.setLabelIsDel(false);
		linfo.setLabelId(1);

		// ldao.insert(linfo);
		//
		// ldao.update(linfo);

		// 查询所有的
		// List list =ldao.selectAll();
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).toString());
		// }

		// 分页
		PageList page = ldao.getProcList("*", "labelInfo", "lableIsDel=0",
				"labelId", 2, 4);
		System.out.println("sumCount:" + page.getSumCount());
		System.out.println("pageCount:" + page.getPageCount());
		for (int i = 0; i < page.getList().size(); i++) {
			LabelInfo label = (LabelInfo) page.getList().get(i);
			System.out.println(label.getLabelId() + " | "
					+ label.getUser().getUserId() + " | "
					+ label.getLabelName());
		}
	}

}
