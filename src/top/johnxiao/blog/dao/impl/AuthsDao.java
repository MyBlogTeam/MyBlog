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
import top.johnxiao.blog.dao.IAuthsDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.AuthsInfo;
import top.johnxiao.blog.dto.PageList;

public class AuthsDao implements IAuthsDao{

	@Override
	public boolean insert(AuthsInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into authsinfo(userId,authsType,authsToken,authsExpires,authsIsDel) values(?,?,?,?,?)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setString(2, model.getAuthsType());
			ps.setString(3, model.getAuthsToken());
			ps.setString(4, model.getAuthsExpires());
			ps.setBoolean(5, model.getAuthsIsDel());
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
	public boolean update(AuthsInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update authsinfo set userId=?,authsType=?,authsToken=?,authsExpires=?,authIsDel=? where authsId=?";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setString(2, model.getAuthsType());
			ps.setString(3, model.getAuthsToken());
			ps.setString(4, model.getAuthsExpires());
			ps.setBoolean(5, model.getAuthsIsDel());
			ps.setInt(6, model.getAuthsId());
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
		String sql="update authsinfo set authsIsdel=1 where authsId=?";
		conn= DBUtil.getConn();
		try {
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
		}finally{
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public AuthsInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		AuthsInfo auths=null;
		String sql="select * from authsinfo where authsIsDel=0 and authsId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<AuthsInfo> list = getModel(rs);
			if(list.size()>0){
				auths=(AuthsInfo) list.get(0);
			}else{
				auths=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return auths;
	}

	@Override
	public List<AuthsInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AuthsInfo> list =new ArrayList<AuthsInfo>();
		String sql="select * from authsinfo where authsIsDel=0";
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
	public List<AuthsInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AuthsInfo> list =new ArrayList<AuthsInfo>();
		String sql="select * from authsinfo where authsIsDel=0";
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
	public PageList<AuthsInfo> getProcList(String showFields, String tableName,
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
		return page;	}

	@Override
	public List<AuthsInfo> getModel(ResultSet rs) {
		List<AuthsInfo> list=new ArrayList<AuthsInfo>();
		try {
			if(rs!=null){
				while(rs.next()){
					AuthsInfo auths=new AuthsInfo();
					auths.setAuthsId(rs.getInt("authsId"));
					auths.setUser(new UserDao().selectById(rs.getInt("userId")));
					auths.setAuthsType(rs.getString("authsType"));
					auths.setAuthsToken(rs.getString("authsToken"));
					auths.setAuthsExpires(rs.getString("authsExpires"));
					auths.setAuthsIsDel(rs.getBoolean("authsIsDel"));
					list.add(auths);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return list;
	}

}
