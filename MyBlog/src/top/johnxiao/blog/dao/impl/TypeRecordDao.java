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
import top.johnxiao.blog.dao.ITypeRecordDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;
import top.johnxiao.blog.dto.TypeInfo;
import top.johnxiao.blog.dto.TypeRecord;

public class TypeRecordDao implements ITypeRecordDao{

	@Override
	public boolean insert(TypeRecord model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;

		String sql = "insert into TypeRecord(typeId,Typ_typeId,trIsDel) values(?,?,0)";
		try {
			TypeDao tdao=(TypeDao) DaoFactory.createTypeDao();
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,model.getTypeId().getTypeId());
			ps.setInt(2, model.getTyp_typeId().getTypeId());
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
	public boolean update(TypeRecord model) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean bool = false;

		String sql = "update TypeRecord set typeId=?,Typ_typeId=?,trIsDel=? where tr=?";
		try {
			TypeDao tdao=(TypeDao) DaoFactory.createTypeDao();
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,model.getTypeId().getTypeId());
			ps.setInt(2, model.getTyp_typeId().getTypeId());
			ps.setBoolean(3, model.getTrIsDel());
			ps.setInt(4, model.getTrId());
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

		String sql = "update TypeRecord trIsDel=1 where trId=?";
		try {
			TypeDao tdao=(TypeDao) DaoFactory.createTypeDao();
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	public TypeRecord selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		TypeRecord tr=null;
		String sql="select * from TypeRecord where trIsDel=0 and trId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List list = getModel(rs);
			if(list.size()>0){
				tr=(TypeRecord) list.get(0);
			}else{
				tr=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return tr;
	}

	@Override
	public List<TypeRecord> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from TypeRecord where trIsDel=0";
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
	public List<TypeRecord> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		String sql="select * from TypeRecord where trIsDel=0";
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
	public PageList<TypeRecord> getProcList(
			String showFields, String tableName, String strWhere,
			String colName, int pageIndex, int pageSize) {
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
			page=new PageList<TypeRecord>();
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
	public List<TypeRecord> getModel(ResultSet rs) {
		List list=new ArrayList<TypeRecord>();
		TypeDao tdao=(TypeDao) DaoFactory.createTypeDao();
		
		try {
			if(rs!=null){
				while(rs.next()){
					TypeRecord tr=new TypeRecord();
					tr.setTrId(rs.getInt("trId"));
					tr.setTyp_typeId(tdao.selectById(rs.getInt("Typ_typeId")));
					tr.setTypeId(tdao.selectById(rs.getInt("typeId")));
					tr.setTrIsDel(rs.getBoolean("trIsDel"));
					list.add(tr);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return list;
	}

}
