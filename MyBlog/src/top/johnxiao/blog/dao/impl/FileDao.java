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
import top.johnxiao.blog.dao.IFileDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.FileInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.UserInfo;

public class FileDao implements IFileDao {

	@Override
	public boolean insert(FileInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "insert into FileInfo (userId,fileName,fileDesc,fileDate,filePath,fileImg,fileIsDel) values(?,?,?,?,?,?,0)";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setString(2, model.getFileName());
			ps.setString(3, model.getFileDesc());
			ps.setTimestamp(4, model.getFileDate());
			ps.setString(5, model.getFilePath());
			ps.setString(6, model.getFileImg());
			int i = ps.executeUpdate();
			bool = i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public boolean update(FileInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "update fileinfo set userId=?,fileName=?,fileDesc=?,fileDate=?,filePath=?,fileImg=?,fileIsDel=? where fileId=?";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getUser().getUserId());
			ps.setString(2, model.getFileName());
			ps.setString(3, model.getFileDesc());
			ps.setTimestamp(4, model.getFileDate());
			ps.setString(5, model.getFilePath());
			ps.setString(6, model.getFileImg());
			ps.setBoolean(7, model.getFileIsDel());
			ps.setInt(8, model.getFileId());
			int i = ps.executeUpdate();
			bool = i > 0 ? true : false;
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

		String sql = "update fileinfo set fileIsDel=1 where fileId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			bool = i > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	@Override
	public FileInfo selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FileInfo fileInfo = null;
		String sql = "select * from fileinfo where fileIsDel=0 and fileId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if (list.size() > 0) {
				fileInfo = (FileInfo) list.get(0);
			} else {
				fileInfo = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return fileInfo;
	}

	@Override
	public List<FileInfo> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = null;
		String sql = "select * from fileinfo where fileIsDel=0";
		try {
			conn = DBUtil.getConn();
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
	public List<FileInfo> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = null;
		String sql = "select * from fileinfo where fileIsDel=0";
		if (strWhere != null &&!"".equals(strWhere)) {
			sql = sql + " and " + strWhere;
		}
		try {
			conn = DBUtil.getConn();
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
	public PageList<FileInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		// 定义所需的变量
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
			page = new PageList<FileInfo>();
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
	public List<FileInfo> getModel(ResultSet rs) {
		UserDao uDao=(UserDao) DaoFactory.createUserDao();
		List list = new ArrayList<FileInfo>();
		try {
			if (rs != null) {
				while (rs.next()) {
					FileInfo fileInfo = new FileInfo();
					fileInfo.setFileId(rs.getInt("fileId"));
					fileInfo.setUser(uDao.selectById(rs.getInt("userId")));
					fileInfo.setFileName(rs.getString("fileName"));
					fileInfo.setFileDate(rs.getTimestamp("fileDate"));
					fileInfo.setFileDesc(rs.getString("fileDesc"));
					fileInfo.setFileImg(rs.getString("fileImg"));
					fileInfo.setFilePath(rs.getString("filePath"));
					fileInfo.setFileIsDel(rs.getBoolean("fileIsDel"));
					list.add(fileInfo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		FileDao fileDao = (FileDao) DaoFactory.createFileDao();
		UserDao udao=(UserDao) DaoFactory.createUserDao();
//		 UserInfo userInfo= new UserInfo();
//		 userInfo.setUserName("张三");
//		
		
//		 添加测试
//		 FileInfo fileInfo=new FileInfo();
//		 fileInfo.setFileName("HBuilder");
//		 fileInfo.setFileImg("zhangsan1");
//		 fileInfo.setFilePath("1234561");
//		 fileInfo.setUser(udao.selectById(1));
//		 if(fileDao.insert(fileInfo)){
//		 System.out.println("插入成功！");
//		 }

		// 修改
		// fileDao.update(fileInfo);
		// fileInfo.getFileId();
		// fileInfo.setFileName("zhangssss");

		// 删除
//		if (fileDao.delete(1)) {
//			System.out.println("删除成功！");
//		}

	//查询所有
		 List list = fileDao.selectAll();
		 for(int i=0;i<list.size();i++){
			 System.out.println(list.get(i).toString());
		 }
		
//		更新测试（）
//		FileInfo fileInfo =  fileDao.selectById(1);
//		fileInfo.setFileName("Myeclipse");
//		boolean bool = fileDao.update(fileInfo);
//		if(bool){
//			System.out.println("更新成功！");
//		}
		//按条件查询
//		List list=fileDao.selectByWhere("fileName='hbuilder'");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
		}
	}

