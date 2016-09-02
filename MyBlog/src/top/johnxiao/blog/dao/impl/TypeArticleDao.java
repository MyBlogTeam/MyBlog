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
import top.johnxiao.blog.dao.ITypeArticleDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.TypeArticle;

public class TypeArticleDao implements ITypeArticleDao{

	@Override
	public boolean insert(TypeArticle model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		
		String sql="insert into Type_Article(atIsDel,typeId,articleId) values(0,?,?)";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getTypeinfo().getTypeId());
			ps.setInt(2, model.getArticleinfo().getArticleId());
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
	public boolean update(TypeArticle model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		
		String sql="update Type_Article set atIsDel=?,typeId=?,articleId=? where atId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setBoolean(1, model.getAtIsDel());
			ps.setInt(2, model.getTypeinfo().getTypeId());
			ps.setInt(3, model.getArticleinfo().getArticleId());
			ps.setInt(4, model.getAtId());
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
		
		String sql="update Type_Article set atIsDel=1 where atId=?";
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
	public TypeArticle selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		TypeArticle ta=null;
		String sql="select * from Type_Article where atId=? and atIsDel=0";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if(list.size()>0){
				ta=(TypeArticle) list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return ta;
	}

	@Override
	public List<TypeArticle> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list = null;
		String sql="select * from Type_Article where atIsDel=0";
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
	public List<TypeArticle> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list = null;
		String sql="select * from Type_Article where atIsDel=0";
		if(strWhere!=null&&!"".equals(strWhere)){
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
	public PageList<TypeArticle> getProcList(String showFields, String tableName,
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
			page=new PageList<TypeArticle>();
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
	public List<TypeArticle> getModel(ResultSet rs) {
		List list =new ArrayList<TypeArticle>();
		TypeDao typeDao = (TypeDao) DaoFactory.createTypeDao();
		ArticleDao articleDao=(ArticleDao) DaoFactory.createArticleDao();
		try {
			while(rs.next()){
				TypeArticle ta=new TypeArticle();
				ta.setAtId(rs.getInt("atId"));
				ta.setAtIsDel(rs.getBoolean("atIsDel"));
				ta.setTypeinfo(typeDao.selectById(rs.getInt("typeId")));
				ta.setArticleinfo(articleDao.selectById(rs.getInt("articleId")));
				list.add(ta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


}
