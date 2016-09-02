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
import top.johnxiao.blog.dao.ITypeDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.TypeInfo;

public class TypeDao implements ITypeDao {

	@Override
	public boolean insert(TypeInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		TypeInfo type=null;
		AdminInfo admin=null;

		String sql = "insert into TypeInfo(adminId,typeName,typeDesc,typeIsDel) values(?,?,?,0)";
		try {
			admin=DaoFactory.createAdminDao().selectById(model.getAdmininfo().getAdminId());
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, admin.getAdminId());
			ps.setString(2, model.getTypeName());
			ps.setString(3, model.getTypeDesc());
			int i = ps.executeUpdate();
			bool=i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public boolean update(TypeInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;

		String sql = "update TypeInfo set adminId=?,typeName=?,typeDesc=?,typeIsDel=? where typeId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getAdmininfo().getAdminId());
			ps.setString(2, model.getTypeName());
			ps.setString(3, model.getTypeDesc());
			ps.setBoolean(4, model.getTypeIsDel());
			ps.setInt(5, model.getTypeId());
			int i = ps.executeUpdate();
			bool=i>0?true:false;
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
		boolean bool = false;

		String sql = "update typeInfo set typeIsDel=1 where typeId=?";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	public TypeInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		TypeInfo type=null;
		
		String sql="select * from TypeInfo where typeId=? and typeIsDel=0";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list=getModel(rs);
			if(list.size()>0){
				type=(TypeInfo) list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return type;
	}

	/**
	 * 查询所有分类信息
	 * 测试通过
	 */
	@Override
	public List<TypeInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from TypeInfo where typeIsDel=0";
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

	/**
	 * 条件查询
	 * 测试通过
	 */
	@Override
	public List<TypeInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from TypeInfo where typeIsDel=0";
		
		if(strWhere!=null&&!"".equals(strWhere)){
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

	/**
	 * 通用存储过程分页
	 * 测试通过
	 */
	@Override
	public PageList<TypeInfo> getProcList(String showFields, String tableName,
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
			page=new PageList<TypeInfo>();
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

	/**
	 * 将RS集合封装成dto的list集合
	 * 测试通过
	 */
	@Override
	public List<TypeInfo> getModel(ResultSet rs) {
		List list = new ArrayList<TypeInfo>();
		try {
			while (rs.next()) {
				TypeInfo type = new TypeInfo();
				type.setTypeId(rs.getInt("typeId"));
				type.setAdmininfo(new AdminInfo(rs.getInt("adminId")));
				type.setTypeName(rs.getString("typeName"));
				type.setTypeDesc(rs.getString("typeDesc"));
				type.setTypeIsDel(rs.getBoolean("typeIsDel"));
				list.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		TypeDao dao=(TypeDao) DaoFactory.createTypeDao();
		
//		插入测试
//		TypeInfo type=new TypeInfo();
//		type.setTypeName("成人教育");
//		type.setAdmininfo(new AdminInfo(1));
//		boolean bool = dao.insert(type);
//		if(bool){
//			System.out.println("插入成功!");
//		}
		
//		查询所有测试
//		List list = dao.selectAll();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
		
//		条件查询测试
//		List list =dao.selectByWhere("adminId=1 and typeId=4");
//		for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i).toString());
//		}
		
//		分页查询测试
//		PageList<TypeInfo> page =  dao.getProcList("*", "TypeInfo", "", "typeId", 2, 5);
//		for(int i=0;i<page.getList().size();i++){
//			System.out.println(page.getList().get(i).toString());
//		}
		
//		删除测试
//		if(dao.delete(1)){
//			System.out.println("删除成功！");
//		}
		
//		根据编号查询测试
//		TypeInfo type=dao.selectById(5);
//		System.out.println(type.toString());
		
//		删除测试
//		if(dao.delete(5)){
//			System.out.println("删除成功！");
//		}
		
//		修改测试
//		type.setTypeIsDel(false);
//		if(dao.update(type)){
//			System.out.println("修改 成功！");
//		}
		
	}
}
