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
import top.johnxiao.blog.dao.IAlbumDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.AlbumInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserInfo;

public class AlbumDao implements IAlbumDao{

	@Override
	public boolean insert(AlbumInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into albuminfo(userId,albumName,albumState,albumPwd,albumQuest,albumAnswer,albumPic,albumIsdel) values(?,?,?,?,?,?,?,?)";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getUserInfo().getUserId());
			ps.setString(2, model.getAlbumName());
			ps.setInt(3, model.getAlbumState());
			ps.setString(4, model.getAlbumPwd());
			ps.setString(5, model.getAlbumQuest());
			ps.setString(6,model.getAlbumAnswer());
			ps.setString(7,model.getAlbumPic());
			ps.setBoolean(8, model.getAlbumIsDel());
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
	public boolean update(AlbumInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update albuminfo set userId=?,albumName=?,albumState=?,albumPwd=?,albumQuest=?,albumAnswer=?,albumPic=?,albumIsdel=? where albumId=?";
		conn= DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getUserInfo().getUserId());
			ps.setString(2, model.getAlbumName());
			ps.setInt(3, model.getAlbumState());
			ps.setString(4, model.getAlbumPwd());
			ps.setString(5, model.getAlbumQuest());
			ps.setString(6,model.getAlbumAnswer());
			ps.setString(7,model.getAlbumPic());
			ps.setBoolean(8, model.getAlbumIsDel());
			ps.setInt(9, model.getAlbumId());
			int i = ps.executeUpdate();
			if(i>0){
				bool=true;
				System.out.println("修改成功");
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
		String sql="update albuminfo set albumIsDel=1 where albumId=?";
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
	public AlbumInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		AlbumInfo album=null;
		String sql="select * from albuminfo where albumIsDel=0 and albumId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<AlbumInfo> list = getModel(rs);
			if(list.size()>0){
				album=(AlbumInfo) list.get(0);
			}else{
				album=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return album;
	}

	@Override
	public List<AlbumInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AlbumInfo> list=new ArrayList<AlbumInfo>();
		String sql="select * from albuminfo where albumIsDel=0";
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
	public List<AlbumInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AlbumInfo> list=new ArrayList<AlbumInfo>();
		String sql="select * from albuminfo where albumIsDel=0";
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
	public PageList<AlbumInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
//		定义所需的变量
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		List list=new ArrayList();
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
	public List<AlbumInfo> getModel(ResultSet rs) {
		List<AlbumInfo> list=new ArrayList<AlbumInfo>();
		try {
			if(rs!=null){
				while(rs.next()){
					AlbumInfo album=new AlbumInfo();
					album.setAlbumId(rs.getInt("albumId"));
					album.setUserInfo(DaoFactory.createUserDao().selectById(rs.getInt("userId")));
					album.setAlbumName(rs.getString("albumName"));
					album.setAlbumState(rs.getInt("albumState"));
					album.setAlbumPwd(rs.getString("albumPwd"));
					album.setAlbumQuest(rs.getString("albumQuest"));
					album.setAlbumAnswer(rs.getString("albumAnswer"));
					album.setAlbumPic(rs.getString("albumPic"));
					album.setAlbumIsDel(rs.getBoolean("albumIsDel"));
					list.add(album);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return list;
	}

	public static void main(String[] args) {
		AlbumDao ad=new AlbumDao();
//		AlbumInfo ai=new AlbumInfo();
		
//		UserInfo ui=new UserInfo();
//		ui.setUserId(1);
		
//		ai.setUserInfo(ui);
//		ai.setAlbumName("aaa");
		//ad.insert(ai);
//		ai.setAlbumId(1);
//		ai.setAlbumState(0);
//		ai.setAlbumPwd("123");
//		ai.setAlbumQuest("");
//		ai.setAlbumAnswer("");
//		ai.setAlbumPic("");
//		System.out.println(ad.update(ai));
		
//		List list=ad.selectAll();
//		for (Object object : list) {
//			AlbumInfo ai=(AlbumInfo) object;
//			System.out.println(ai.getAlbumId()+"  "+ai.getAlbumName());
//		}
	}

}
