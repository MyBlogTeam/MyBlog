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
import top.johnxiao.blog.dao.IAdminDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;

public class AdminDao implements IAdminDao{

	@Override
	public boolean insert(AdminInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into AdminInfo(adminName,adminPwd,adminTel,adminEmail,adminPic,adminIsDel) values(?,?,?,?,?,0)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getAdminName());
			ps.setString(2, model.getAdminPwd());
			ps.setString(3, model.getAdminTel());
			ps.setString(4, model.getAdminEmail());
			ps.setString(5, model.getAdminPic());
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
	public boolean update(AdminInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update AdminInfo set adminName=?,adminPwd=?,adminTel=?,adminEmail=?,adminPic=?,adminIsDel=?";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getAdminName());
			ps.setString(2, model.getAdminPwd());
			ps.setString(3, model.getAdminTel());
			ps.setString(4, model.getAdminEmail());
			ps.setString(5, model.getAdminPic());
			ps.setBoolean(6, model.getAdminIsDel());
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

//	此处为软删除
	@Override
	public boolean delete(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		
		String sql="update AdminInfo set adminIsDel=1 where adminId=?";
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
	public AdminInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		AdminInfo admin=null;
		String sql="select * from AdminInfo where adminId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if(list.size()>0){
				admin=(AdminInfo) list.get(0);
			}else{
				admin=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return admin;
	}

	@Override
	public List<AdminInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from AdminInfo where adminIsDel=0";
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
	public List<AdminInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from AdminInfo where adminIsDel=0";
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
	public List<AdminInfo> getModel(ResultSet rs) {
		List list=new ArrayList<AdminInfo>();
			try {
				if(rs!=null){
					while(rs.next()){
						AdminInfo admin=new AdminInfo();
						admin.setAdminId(rs.getInt("adminId"));
						admin.setAdminName(rs.getString("adminName"));
						admin.setAdminPwd(rs.getString("adminPwd"));
						admin.setAdminTel(rs.getString("adminTel"));
						admin.setAdminEmail(rs.getString("adminEmail"));
						admin.setAdminPic(rs.getString("adminPic"));
						admin.setAdminIsDel(rs.getBoolean("adminIsDel"));
						list.add(admin);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return list;
	}
	
	/**
	 * 通用存储过程分页
	 * showFields查询所要显示的字段
	 * tableName所要查询的表名
	 * strWhere 查询条件
	 * colName 排序所对应的字段
	 * pageIndex 当前页面
	 * pageSize 页面的容量
	 * totalCount 返回总行数
	 * pageCount 返回总页数
	 */
	@Override
	public PageList<AdminInfo> getProcList(String showFields, String tableName,
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
	
	/**
	 * AdminDao测试,以上方法均测试通过
	 * @param args
	 */
	public static void main(String[] args) {
		AdminDao dao=new AdminDao();
//		AdminInfo admin=new AdminInfo();
//		admin.setAdminId(2);
//		admin.setAdminName("zhangsan");
//		admin.setAdminPwd("zhangsan");
//		admin.setAdminTel("123456");
//		admin.setAdminEmail("123456@qq.com");
//		boolean bool = dao.insert(admin);
//		if(bool){
//			System.out.println("插入成功！");
//		}else{
//			System.out.println("插入失败！");
//		}
		
//		List list = dao.selectAll();
//		for (int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
//		dao.update(admin);
//		dao.delete(2);
		
		PageList page = dao.getProcList("*", "adminInfo", "adminIsDel=0", "adminId", 1, 10);
		System.out.println("sumCount:"+page.getSumCount());
		System.out.println("pageCount:"+page.getPageCount());
		for(int i=0;i<page.getList().size();i++){
			AdminInfo admin=(AdminInfo) page.getList().get(i);
			System.out.println(admin.getAdminId()+" | "+admin.getAdminName());
		}
		
		
	}


}
