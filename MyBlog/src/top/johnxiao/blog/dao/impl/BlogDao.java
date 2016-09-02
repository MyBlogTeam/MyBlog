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
import top.johnxiao.blog.dao.IBlogDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.BlogInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserInfo;

public class BlogDao implements IBlogDao{

	@Override
	public boolean insert(BlogInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		try {
			String sql="insert into bloginfo(userId,blogName,blogDesc,blogDate,blogState,blogMusic,blogPic,blogIsDel) values(?,?,?,?,?,?,?,?)";
			conn= DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getUserId().getUserId());
			ps.setString(2, model.getBlogName());
			ps.setString(3, model.getBlogDesc());
			ps.setString(4, model.getBlogDate());
			ps.setInt(5, model.getBlogState());
			ps.setString(6, model.getBlogMusic());
			ps.setString(7, model.getBlogPic());
			ps.setBoolean(8, model.getBlogIsDel());
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
	public boolean update(BlogInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "update bloginfo set userId=?,blogName=?,blogDesc=?,blogDate=?," +
				"blogState=?,blogMusic=?,blogPic=?,blogIsDel=? where blogId=?,";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUserId().getUserId());
			ps.setString(2, model.getBlogName());
			ps.setString(3, model.getBlogDesc());
			ps.setString(4, model.getBlogDate());
			ps.setInt(5, model.getBlogState());
			ps.setString(6, model.getBlogMusic());
			ps.setString(7,model.getBlogPic());
			ps.setBoolean(8,model.getBlogIsDel());
			ps.setInt(9, model.getBlogId());
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
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		
		String sql="update bloginfo set blogIsDel=1 where blogId=?";
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
	public BlogInfo selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BlogInfo blog = null;
		String sql = "select * from bloginfo where blogIsDel=0 and blogId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<BlogInfo> list = getModel(rs);
			if (list.size() > 0) {
				blog = (BlogInfo) list.get(0);
			} else {
				blog = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return blog;
	}

	@Override
	public List<BlogInfo> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BlogInfo> list=new ArrayList<BlogInfo>();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from bloginfo where blogIsDel=0";
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
	public List<BlogInfo> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BlogInfo> list=new ArrayList<BlogInfo>();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from bloginfo where blogIsDel=0";
			if(strWhere!=null&&"".equals(strWhere)){
				sql=sql+" and "+strWhere;
			}
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
	public PageList<BlogInfo> getProcList(String showFields, String tableName,
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
	public List<BlogInfo> getModel(ResultSet rs) {
		List list = new ArrayList<BlogInfo>();
		try {
			if (rs != null) {
				while (rs.next()) {
					BlogInfo blog = new BlogInfo();
					blog.setBlogId(rs.getInt("blogId"));
					blog.setUserId(new UserDao().selectById(rs.getInt("userId")));
					blog.setBlogName(rs.getString("blogName"));
					blog.setBlogDesc(rs.getString("blogDesc"));
					blog.setBlogDate(rs.getString("blogDate"));
					blog.setBlogState(rs.getInt("blogState"));
					blog.setBlogMusic(rs.getString("blogMusic"));
					blog.setBlogPic(rs.getString("blogPic"));
					blog.setBlogIsDel(rs.getBoolean("blogIsDel"));
					list.add(blog);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
//		UserInfo ui = new UserInfo(1);
//		BlogInfo bi = new BlogInfo(1, ui, "hello", "hello", "2000-1-6", 1,
//				"生如夏花", "", false);
//		BlogDao bd=new BlogDao();
//		bd.insert(bi);
	}
}
