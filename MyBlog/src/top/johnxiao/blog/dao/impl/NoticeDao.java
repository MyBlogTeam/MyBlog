package top.johnxiao.blog.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.OffsetDST;
import top.johnxiao.blog.core.DBUtil;
import top.johnxiao.blog.core.DaoFactory;
import top.johnxiao.blog.dao.INoticeDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.NoticeInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserInfo;

public class NoticeDao implements INoticeDao{

	@Override
	public boolean insert(NoticeInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into Noticeinfo(adminId,noticeTopic,noticeContent,noticeDate,noticeIsDel) values(?,?,?,?,0)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getAdmininfo().getAdminId());
			ps.setString(2, model.getNoticeTopic());
			ps.setString(3, model.getNoticeContent());
			ps.setTimestamp(4, model.getNoticeDate());
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
	public boolean update(NoticeInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update Noticeinfo set adminId=?,noticeTopic=?,noticeContent=?,noticeDate=?,noticeIsDel=?  where noticeId=?";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getAdmininfo().getAdminId());
			ps.setString(1, model.getNoticeTopic());
			ps.setString(2, model.getNoticeContent());
			ps.setTimestamp(3, model.getNoticeDate());
			ps.setBoolean(4, model.getNoticeIsDel());
			ps.setInt(5, model.getNoticeId());
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
		
		String sql="update NoticeInfo set noticeIsDel=1 where noticeId=?";
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
	public NoticeInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		NoticeInfo noticeInfo=null;
		String sql="select * from NoticeInfo where noticeIsDel=0 and noticeId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if(list.size()>0){
				noticeInfo=(NoticeInfo) list.get(0);
			}else{
				noticeInfo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return noticeInfo;
	}

	@Override
	public List<NoticeInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from NoticeInfo where noticeIsDel=0";
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
	public List<NoticeInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from NoticeInfo where noticeIsDel=0";
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
	public PageList<NoticeInfo> getProcList(String showFields, String tableName,
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
			page=new PageList<NoticeInfo>();
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
	public List<NoticeInfo> getModel(ResultSet rs) {
		List list=new ArrayList<NoticeInfo>();
		try {
			if(rs!=null){
				while(rs.next()){
					NoticeInfo noticeInfo=new NoticeInfo();
					noticeInfo.setNoticeId(rs.getInt("noticeId"));
					noticeInfo.setNoticeTopic(rs.getString("noticeTopic"));
					noticeInfo.setNoticeContent(rs.getString("noticeContent"));
					noticeInfo.setNoticeDate(rs.getTimestamp("noticeDate"));
					noticeInfo.setNoticeIsDel(rs.getBoolean("noticeIsDel"));
					list.add(noticeInfo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return list;
	}
public static void main(String[] args) {
	NoticeDao noticeDao = (NoticeDao) DaoFactory.createNoticeDao();
NoticeInfo noticeInfo=new NoticeInfo();
//新增				
//	AdminInfo adminInfo=new AdminInfo();
//	adminInfo.setAdminId(1);

//			 添加测试
//			noticeInfo.setNoticeTopic("zhangsan1");
//			noticeInfo.setNoticeContent("zhangsan1");
//			noticeInfo.setNoticeDate(null);
//			 if(noticeDao.insert(noticeInfo)){
//			 System.out.println("插入成功！");
//			 }
//	
	// 修改
//			 noticeDao.update(noticeInfo);
//			noticeInfo.getNoticeId();		
//			noticeInfo.setNoticeTopic("12214214");

//按条件查询
//List list=noticeDao.selectByWhere("noticeTopic='111'");
//for (int i = 0; i < list.size(); i++) {
//	System.out.println(list);
//}
//查询所有
//List list= noticeDao.selectAll();
//for(int i=0;i<list.size();i++){
//	 System.out.println(list.get(i).toString());
//}
//删除
//if (noticeDao.delete(1)) {
//	System.out.println("shanchuchenggong");
//}


}

}
