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
import top.johnxiao.blog.dao.IMessageDao;
import top.johnxiao.blog.dto.MessageInfo;
import top.johnxiao.blog.dto.PageList;


public class MessageDao implements IMessageDao{

	@Override
	public boolean insert(MessageInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into MessageInfo(userId,Use_userId,messageContent,messageDate,msgIsDel) values(?,?,?,?,?)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getSender().getUserId());
			ps.setInt(2, model.getReceiver().getUserId());
			ps.setString(3, model.getMessageContent());
			ps.setTimestamp(4, model.getMessageDate());
			ps.setBoolean(5, model.getMsgIsDel());
			int i = ps.executeUpdate();
			if(i>0){
				bool=true;
			}else{
				bool=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public boolean update(MessageInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		try {
			String sql="update MessageInfo set userId=?,Use_userId=?,messageContent=?,messageDate=?,msgIsDel=? where messageId=?";
			conn= DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getSender().getUserId());
			ps.setInt(2, model.getReceiver().getUserId());
			ps.setString(3, model.getMessageContent());
			ps.setTimestamp(4, model.getMessageDate());
			ps.setBoolean(6, model.getMsgIsDel());
			ps.setInt(6, model.getMessageId());
			int i = ps.executeUpdate();
			if(i>0){
				bool=true;
			}else{
				bool=false;
			}
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
		String sql="update MessageInfo set msgIsDel=1 where MessageId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0){
				bool=true;
			}else{
				bool=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public MessageInfo selectById(int id) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		MessageInfo minfo =null;
		try {
			conn=DBUtil.getConn();
			String sql = "select * from MessageInfo where messageId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<MessageInfo> list = getModel(rs);
			if(list.size()>0){
				minfo =(MessageInfo) list.get(0);
			}else{
				minfo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return minfo;
	}

	@Override
	public List<MessageInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<MessageInfo> list=null;
		String sql="select * from MessageInfo where msgIsDel=0";
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
	public List<MessageInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<MessageInfo> list=null;
		String sql="select * from MessageInfo where msgIsDel=0";
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
	public PageList<MessageInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		List list=null;
		PageList<MessageInfo> page=null;
		
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
			page=new PageList<MessageInfo>();
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
	public List<MessageInfo> getModel(ResultSet rs) {
		List<MessageInfo> list = new ArrayList<MessageInfo>();
		UserDao udao = new UserDao();
		try {
			if(rs!=null){
				while(rs.next()){
					MessageInfo mif = new MessageInfo();
					mif.setMessageId(rs.getInt("messageId"));
					mif.setSender(udao.selectById(rs.getInt("UserId")));
					mif.setReceiver(udao.selectById( rs.getInt("Use_userId")));
					mif.setMessageContent(rs.getString("messageContent"));
					mif.setMessageDate(rs.getTimestamp("messageDate"));
					mif.setMsgIsDel(rs.getBoolean("msgIsDel"));
					list.add(mif);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) {
		
	}
}
