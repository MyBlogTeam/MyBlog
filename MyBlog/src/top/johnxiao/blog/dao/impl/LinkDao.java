package top.johnxiao.blog.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.sun.mail.handlers.message_rfc822;

import top.johnxiao.blog.core.DBUtil;
import top.johnxiao.blog.core.DaoFactory;
import top.johnxiao.blog.dao.ILinkDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.LinkInfo;
import top.johnxiao.blog.dto.PageList;

public class LinkDao implements ILinkDao{

	@Override
	public boolean insert(LinkInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into Linkinfo(adminId,linkName,linkUrl,linkLogo,ShowOrder,linkIsDel) values(?,?,?,?,?,0)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getAdmin().getAdminId());
			ps.setString(2, model.getLinkName());
			ps.setString(3, model.getLinkUrl());
			ps.setString(4, model.getLinkLogo());
			ps.setInt(5, model.getShowOrder());
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
	public boolean update(LinkInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update Linkinfo set adminId=?,linkName=?,linkUrl=?,linkLogo=?,showOrder=?,linkIsDel=?where linkId=? ";
		conn= DBUtil.getConn();
		try {
			ps.setInt(1, model.getAdmin().getAdminId());
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getLinkName());
			ps.setString(2, model.getLinkUrl());
			ps.setString(3, model.getLinkLogo());
			ps.setInt(4, model.getShowOrder());
			ps.setBoolean(5, model.getLinkIsDel());
			ps.setInt(6, model.getLinkId());
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
		
		String sql="update Linkinfo set linkIsDel=1 where linkId=?";
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
	public LinkInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		LinkInfo linkInfo=null;
		String sql="select * from LinkInfo where linkIsDel=0 and linkId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if(list.size()>0){
				linkInfo=(LinkInfo) list.get(0);
			}else{
				linkInfo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return linkInfo;
	}

	@Override
	public List<LinkInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from LinkInfo where linkIsDel=0";
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
	public List<LinkInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from LinkInfo where linkIsDel=0";
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
	public PageList<LinkInfo> getProcList(String showFields, String tableName,
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
			page=new PageList<LinkInfo>();
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
	public List<LinkInfo> getModel(ResultSet rs) {
		List list=new ArrayList<LinkInfo>();
		try {
			if(rs!=null){
				while(rs.next()){
					LinkInfo linkInfo=new LinkInfo();
					linkInfo.setLinkId(rs.getInt("linkId"));
					linkInfo.setLinkName(rs.getString("linkName"));
					linkInfo.setLinkLogo(rs.getString("linkLogo"));
					linkInfo.setLinkUrl(rs.getString("linkUrl"));
					linkInfo.setLinkIsDel(rs.getBoolean("linkIsDel"));
					list.add(linkInfo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return list;
	}
	public static void main(String[] args) {
		LinkDao linkDao = (LinkDao) DaoFactory.createLinkDao();
		//新增(未测试)
//		AdminInfo adminInfo=new AdminInfo();
//		adminInfo.setAdminId(1);				
//				 LinkInfo linkInfo=new LinkInfo();
//		//		 添加测试
//				 linkInfo.setLinkName("zhangsan1");
//				 linkInfo.setLinkName("zhangsan1");
//				 linkInfo.setLinkLogo("1234561");
//	
		//修改（未测试）
//		LinkInfo linkInfo =  linkDao.selectById(1);
//		linkInfo.setLinkName("Myeclipse");
//		boolean bool =linkDao.update(linkInfo);
//		if(bool){
//			System.out.println("更新成功！");
//		}
		//按条件查询
//		List list=linkDao.selectByWhere("linkName='1111'");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
//		
//		查询所有测试
//		List list=linkDao.selectAll();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
		//删除测试
//		if (linkDao.delete(1)) {
//		System.out.println("删除成功！");
//	}
	}
}
