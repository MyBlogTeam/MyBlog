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
import top.johnxiao.blog.core.DaoFactory;
import top.johnxiao.blog.dao.IDiscussDao;
import top.johnxiao.blog.dto.DiscussInfo;
import top.johnxiao.blog.dto.PageList;

public class DiscussDao implements IDiscussDao{

	@Override
	public boolean insert(DiscussInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		
		String sql="insert into DiscussInfo(Dis_discussId,articleId,userId,discussContent,discussDate,discussIsDel) values(?,?,?,?,?,0)";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getDiscussId());
			ps.setInt(2, model.getArticle().getArticleId());
			ps.setInt(3, model.getUser().getUserId());
			ps.setString(4, model.getDiscussContent());
			ps.setTimestamp(5, model.getDiscussDate());
			int i = ps.executeUpdate();
			bool=i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public boolean update(DiscussInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		
		String sql="update DiscussInfo set Dis_discussId=?,articleId=?,userId=?,discussContent=?,discussDate=?,discussIsDel=? where discussId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getDiscussId());
			ps.setInt(2, model.getArticle().getArticleId());
			ps.setInt(3, model.getUser().getUserId());
			ps.setString(4, model.getDiscussContent());
			ps.setTimestamp(5, model.getDiscussDate());
			ps.setBoolean(6, model.getDiscussIsDel());
			ps.setInt(7, model.getDiscussId());
			int i = ps.executeUpdate();
			bool=i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public boolean delete(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		
		String sql="update DiscussInfo set discussIsDel=1 where discussId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			bool=i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public DiscussInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DiscussInfo discuss=null;
		
		String sql="select * from DiscussInfo where discussIsDel=0 and discussId=? ";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			discuss=getModel(rs).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return discuss;
	}

	@Override
	public List<DiscussInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		
		String sql="select * from DiscussInfo where discussIsDel=0 ";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list=getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<DiscussInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		
		String sql="select * from DiscussInfo where discussIsDel=0 ";
		if(strWhere!=null&&"".equals(strWhere)){
			sql=sql+" and "+strWhere;
		}
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list=getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	@Override
	public PageList<DiscussInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		List list=null;
		PageList page=null;
		
		String sql="{call getProcList(?,?,?,?,?,?,?,?) }";
		try {
//			获取连接，拼接SQL语句
			conn=DBUtil.getConn();
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
			
			list=getModel(rs);
			int tCount=cs.getInt(7);
			int pCount=cs.getInt(8);
//			实例化对象，并设置存放的数据
			page=new PageList<DiscussInfo>();
			page.setSumCount(tCount);
			page.setPageCount(pCount);
			page.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, cs, rs);
		}
		return page;
	}

	@Override
	public List<DiscussInfo> getModel(ResultSet rs) {
		List list=new ArrayList<DiscussInfo>();
		ArticleDao articleDao=(ArticleDao) DaoFactory.createArticleDao();
		UserDao userDao=(UserDao) DaoFactory.createUserDao();
		DiscussDao discussDao=(DiscussDao) DaoFactory.createDiscussDao();
		
		try {
			while(rs.next()){
				DiscussInfo discuss=new DiscussInfo();
				discuss.setDiscussId(rs.getInt("discussId"));
				discuss.setArticle(articleDao.selectById(rs.getInt("articleId")));
				discuss.setUser(userDao.selectById(rs.getInt("userId")));
				discuss.setDiscuss(discuss);
				discuss.setDiscussContent(rs.getString("discussContent"));
				discuss.setDiscussDate(rs.getTimestamp("discussContent"));
				discuss.setDiscussIsDel(rs.getBoolean("discussIsDel"));
				list.add(discuss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


}
