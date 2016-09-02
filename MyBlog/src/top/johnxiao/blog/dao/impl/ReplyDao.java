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
import top.johnxiao.blog.dao.IReplyDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.ReplyInfo;

public class ReplyDao implements IReplyDao{

	@Override
	public boolean insert(ReplyInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into ReplyInfo(userId,discussId,replyContent,replyDate,replyIsDel) values(?,?,?,?,0)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getUserInfo().getUserId());
			ps.setInt(2, model.getDiscussInfo().getDiscussId());
			ps.setString(3, model.getReplyContent());
			ps.setTimestamp(4, model.getReplyDate());
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
	public boolean update(ReplyInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update ReplyInfo set userId=?,discussId=?,replyContent=?,replyDate=?,replyIsDel=? where replyId=?";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getUserInfo().getUserId());
			ps.setInt(2, model.getDiscussInfo().getDiscussId());
			ps.setString(3, model.getReplyContent());
			ps.setTimestamp(4, model.getReplyDate());
			ps.setBoolean(5, model.getReplyIsDel());
			ps.setInt(6, model.getReplyId());
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
		String sql="update ReplyInfo set replyIsDel=1 where replyId=?";
		conn= DBUtil.getConn();
		try {
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
	public ReplyInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ReplyInfo reply=null;
		String sql="select * from ReplyInfo where replyIsDel=0 and replyId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if(list.size()>0){
				reply=(ReplyInfo) list.get(0);
			}else{
				reply=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return reply;
	}

	@Override
	public List<ReplyInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from ReplyInfo where replyIsDel=0";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<ReplyInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from ReplyInfo where replyIsDel=0";
		if(strWhere!=null&&"".equals(strWhere)){
			sql=sql+" and "+strWhere;
		}
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	@Override
	public PageList<ReplyInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
//		定义所需的变量
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
			page=new PageList<AdminInfo>();
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
	public List<ReplyInfo> getModel(ResultSet rs) {
		UserDao udao=(UserDao) DaoFactory.createUserDao();
		DiscussDao ddao=(DiscussDao) DaoFactory.createDiscussDao();
		List list=new ArrayList<ReplyInfo>();
		try {
			if(rs!=null){
				while(rs.next()){
					ReplyInfo reply=new ReplyInfo();
					reply.setReplyId(rs.getInt("replyId"));
					reply.setUserInfo(udao.selectById(rs.getInt("userId")));
					reply.setDiscussInfo(ddao.selectById(rs.getInt("discussId")));
					reply.setReplyContent(rs.getString("replyContent"));
					reply.setReplyDate(rs.getTimestamp("replyDate"));
					reply.setReplyIsDel(rs.getBoolean("replyIsDel"));
					list.add(reply);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return list;
	}

}
