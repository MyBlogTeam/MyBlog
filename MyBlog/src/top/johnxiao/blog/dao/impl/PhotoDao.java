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
import top.johnxiao.blog.dao.IPhotoDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.AlbumInfo;
import top.johnxiao.blog.dto.AuthsInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.PhotoInfo;

public class PhotoDao implements IPhotoDao {

	@Override
	public boolean insert(PhotoInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "insert into photoinfo(albumId,photoName,photoPath,photoDesc,photoDate,photoIsDel) values(?,?,?,?,?,?)";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getAlbuminfo().getAlbumId());
			ps.setString(2, model.getPhotoName());
			ps.setString(3, model.getPhotoPath());
			ps.setString(4, model.getPhotoDesc());
			ps.setTimestamp(5, model.getPhotoDate());
			ps.setBoolean(6, model.getPhotoIsDel());
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
	public boolean update(PhotoInfo model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;
		String sql = "update photoinfo set albumId=?,photoName=?,photoPath=?,photoDesc=?,photoDate=?,photoIsdel=? where photoId=?";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getAlbuminfo().getAlbumId());
			ps.setString(2, model.getPhotoName());
			ps.setString(3, model.getPhotoPath());
			ps.setString(4, model.getPhotoDesc());
			ps.setTimestamp(5, model.getPhotoDate());
			ps.setBoolean(6, model.getPhotoIsDel());
			ps.setInt(7, model.getPhotoId());
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
		String sql = "update photoinfo set photoIsdel=1 where photoId=?";
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
	public PhotoInfo selectById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PhotoInfo photo = null;
		String sql = "select * from photoinfo where photoIsDel=0 and photoId=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<PhotoInfo> list = getModel(rs);
			if (list.size() > 0) {
				photo = (PhotoInfo) list.get(0);
			} else {
				photo = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return photo;
	}

	@Override
	public List<PhotoInfo> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PhotoInfo> list = new ArrayList<PhotoInfo>();
		String sql = "select * from photoinfo where photoIsDel=0";
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
	public List<PhotoInfo> selectByWhere(String strWhere) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PhotoInfo> list = new ArrayList<PhotoInfo>();
		String sql = "select * from photoinfo where photoIsDel=0";
		if (strWhere != null && "".equals(strWhere)) {
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
	public PageList<PhotoInfo> getProcList(String showFields, String tableName,
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
	public List<PhotoInfo> getModel(ResultSet rs) {
		List<PhotoInfo> list = new ArrayList<PhotoInfo>();
		try {
			if (rs != null) {
				while (rs.next()) {
					PhotoInfo photo = new PhotoInfo();
					photo.setPhotoId(rs.getInt("photoId"));
					photo.setAlbuminfo(DaoFactory.createAlbumDao().selectById(
							rs.getInt("albumId")));
					photo.setPhotoName(rs.getString("photoName"));
					photo.setPhotoPath(rs.getString("photoPath"));
					photo.setPhotoDesc(rs.getString("photoDesc"));
					photo.setPhotoDate(rs.getTimestamp("photoDate"));
					photo.setPhotoIsDel(rs.getBoolean("photoIsDel"));
					list.add(photo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		PhotoDao pd = new PhotoDao();
//		for (int i = 0; i < 10; i++) {
//			PhotoInfo photo = new PhotoInfo();
//			AlbumInfo ai = new AlbumInfo();
//			ai.setAlbumId(1);
//			photo.setAlbuminfo(ai);
//			pd.insert(photo);
//
//		}

		// photo.setPhotoId(1);
		// photo.setPhotoName("aa");
		// pd.update(photo);

		List list = pd.selectAll();
		for (Object object : list) {
			PhotoInfo ai = (PhotoInfo) object;
			System.out.println(ai.getPhotoId() + "  " + ai.getPhotoName());
		}
	}

}
