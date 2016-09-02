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
import top.johnxiao.blog.dao.IUserNoticeDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserNotice;

public class UserNoticeDao implements IUserNoticeDao{

	@Override
	public boolean insert(UserNotice model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into User_notice(noticeId,userId) values(?,?,0)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getNoticeinfo().getNoticeId());
		    ps.setInt(2, model.getUserinfo().getUserId());
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
	public boolean update(UserNotice model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update User_notice set nuIsDel where unId=?";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,model.getUserinfo().getUserId());
			ps.setInt(2, model.getNoticeinfo().getNoticeId());
			ps.setInt(1, model.getUnId());
			ps.setBoolean(2, model.getUnIsDel());
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
		
		String sql="update User_notice set unIsDel=1 where unId=?";
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
	public UserNotice selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserNotice userNotice=null;
		String sql="select * from User_notice where unIsDel=0 and unId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if(list.size()>0){
				userNotice=(UserNotice) list.get(0);
			}else{
				userNotice=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return userNotice;
	}

	@Override
	public List<UserNotice> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from User_notice where unIsDel=0";
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
	public List<UserNotice> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from User_notice where unIsDel=0";
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
	public PageList<UserNotice> getProcList(String showFields, String tableName,
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
			page=new PageList<UserNotice>();
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
	public List<UserNotice> getModel(ResultSet rs) {
		List list=new ArrayList<UserNotice>();
		try {
			if(rs!=null){
				while(rs.next()){
					UserNotice user=new UserNotice();
					user.setUnId(rs.getInt("unId"));
					user.setUnIsDel(rs.getBoolean("unIsDel"));			
					list.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return list;
	}

public static void main(String[] args) {
	UserNoticeDao userNoticeDao=(UserNoticeDao)DaoFactory.createUNDao();
	//新增(未测试)
//	AdminInfo adminInfo=new AdminInfo();
//	adminInfo.setAdminId(1);				
//			 LinkInfo linkInfo=new LinkInfo();
//	//		 添加测试
//			 linkInfo.setLinkName("zhangsan1");
//			 linkInfo.setLinkName("zhangsan1");
//			 linkInfo.setLinkLogo("1234561");
//
	//修改（未测试）
//	LinkInfo linkInfo =  linkDao.selectById(1);
//	linkInfo.setLinkName("Myeclipse");
//	boolean bool =linkDao.update(linkInfo);
//	if(bool){
//		System.out.println("更新成功！");
//	}
	//按条件查询
	List list=userNoticeDao.selectByWhere("noticeId='1'");
	for(int i=0;i<list.size();i++){
		System.out.println(list.get(i).toString());
	}
//	
//	查询所有测试
//	List list=userNoticeDao.selectAll();
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i).toString());
//	}
//	
	
	//删除测试
//	if (userNoticeDao.delete(1)) {
//	System.out.println("删除成功！");
//}
	
	
}
}
