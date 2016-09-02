package top.johnxiao.blog.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import top.johnxiao.blog.core.DBUtil;
import top.johnxiao.blog.dao.IUserDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserInfo;

public class UserDao implements IUserDao {

	@Override
	public boolean insert(UserInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "insert into userinfo(userName,userPwd,userNickName,userSex,userBirthday," +
				"userAddress,userTel,userEmail,userPic,userRank,userState,userIsDel) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, model.getUserName());
			ps.setString(2, model.getUserPwd());
			ps.setString(3, model.getUserNickName());
			ps.setString(4, model.getUserSex());
			ps.setDate(5, (java.sql.Date) model.getUserBirthday());
			ps.setString(6, model.getUserAddress());
			ps.setString(7, model.getUserTel());
			ps.setString(8, model.getUserEmail());
			ps.setString(9, model.getUserPic());
			ps.setInt(10, model.getUserRank());
			ps.setInt(11, model.getUserState());
			ps.setBoolean(12, model.getUserIsDel());
			int i = ps.executeUpdate();
			if (i > 0) {
				bool = true;
				System.out.println("添加成功");
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
	public boolean update(UserInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "update userinfo set userName=?,userPwd=?,userNickName=?,userSex=?,userBirthday=?,"
				+ "userAddress=?,userTel=?,userEmail=?,userPic=?,userRank=?,userState=?,userIsDel=? where userId=?,";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, model.getUserName());
			ps.setString(2, model.getUserPwd());
			ps.setString(3, model.getUserNickName());
			ps.setString(4, model.getUserSex());
			ps.setDate(5, (java.sql.Date) model.getUserBirthday());
			ps.setString(6, model.getUserAddress());
			ps.setString(7, model.getUserTel());
			ps.setString(8, model.getUserEmail());
			ps.setString(9, model.getUserPic());
			ps.setInt(10, model.getUserRank());
			ps.setInt(11, model.getUserState());
			ps.setBoolean(12, model.getUserIsDel());
			ps.setInt(13, model.getUserId());
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
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;

		String sql = "update userinfo set userIsDel=1 where userId=?";
		try {
			conn = DBUtil.getConn();
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
		}
		return bool;
	}

	@Override
	public UserInfo selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo user = null;
		String sql = "select * from userinfo where userIsDel=0 and userId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<UserInfo> list = getModel(rs);
			if (list.size() > 0) {
				user = (UserInfo) list.get(0);
			} else {
				user = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return user;
	}

	@Override
	public List<UserInfo> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from userinfo where userIsDel=0";
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
	public List<UserInfo> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo user = null;
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from userinfo where userIsDel=0";
			if (strWhere != null && "".equals(strWhere)) {
				sql = sql + " and " + strWhere;
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
	public PageList<UserInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List list = null;
		PageList page = null;

		String sql = "{call getProcList(?,?,?,?,?,?,?,?) }";
		try {
			// 获取连接，拼接SQL语句
			conn = DBUtil.getConn();
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

			list = getModel(rs);
			int tCount = cs.getInt(7);
			int pCount = cs.getInt(8);
			// 实例化对象，并设置存放的数据
			page = new PageList<AdminInfo>();
			page.setSumCount(tCount);
			page.setPageCount(pCount);
			page.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, cs, rs);
		}
		return page;
	}

	@Override
	public List<UserInfo> getModel(ResultSet rs) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			if (rs != null) {
				while (rs.next()) {
					UserInfo user = new UserInfo();
					user.setUserId(rs.getInt("userId"));
					user.setUserName(rs.getString("userName"));
					user.setUserPwd(rs.getString("userPwd"));
					user.setUserNickName(rs.getString("userNickName"));
					user.setUserSex(rs.getString("userSex"));
					user.setUserBirthday(rs.getDate("userBirthday"));
					user.setUserAddress(rs.getString("userAddress"));
					user.setUserTel(rs.getString("userTel"));
					user.setUserEmail(rs.getString("userEmail"));
					user.setUserPic(rs.getString("userPic"));
					user.setUserRank(rs.getInt("userRank"));
					user.setUserState(rs.getInt("userState"));
					list.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		UserDao ud = new UserDao();

		UserInfo ui = new UserInfo();
		ui.setUserName("zhangsan");
		ui.setUserPwd("123");
		ui.setUserNickName("zhangsan");
		ui.setUserSex("男");
		ui.setUserBirthday(Date.valueOf("1995-6-6"));
		ui.setUserAddress("湖北武汉");
		ui.setUserTel("12345678906");
		ui.setUserEmail("12334@163.com");
		ui.setUserPic("");
		ui.setUserRank(1);
		ui.setUserState(1);
		ui.setUserIsDel(false);
		boolean bool=ud.insert(ui);
		if(bool){
			System.out.println("插入成功！");
		}

//		 UserInfo ui=ud.selectById(1);
//		 System.out.println(ui.getUserId()+"  "+ui.getUserName());
		
//		List list=ud.selectAll();
//		for (Object o : list) {
//			UserInfo ui=(UserInfo) o;
//			System.out.println(ui.getUserId()+"  "+ui.getUserName());
//		}
		
	}

}
