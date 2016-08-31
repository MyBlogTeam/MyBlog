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
import top.johnxiao.blog.dao.IArticleDao;
import top.johnxiao.blog.dto.ArticleInfo;
import top.johnxiao.blog.dto.PageList;

public class ArticleDao implements IArticleDao{

	/**
	 * 插入博文,测试通过
	 */
	@Override
	public boolean insert(ArticleInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="insert into ArticleInfo(articleTitle,articleDate,articleContent,articlePeople,articleState,articlePic,articleIsDel) values(?,?,?,?,?,?,0)";
		
		conn=DBUtil.getConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getArticleTitle());
			ps.setTimestamp(2, model.getArticleDate());
			ps.setString(3, model.getArticleContent());
			ps.setInt(4, model.getArticlePeople());
			ps.setInt(5, model.getArticleState());
			ps.setString(6, model.getArticlePic());
			int i =ps.executeUpdate();
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

	/**
	 * 更新博文信息,测试通过
	 */
	@Override
	public boolean update(ArticleInfo model) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
//		articleTitle,articleDate,articleContent,articlePeople,articleState,articlePic,articleIsDel
		String sql="update ArticleInfo set articleTitle=?,articleDate=?,articleContent=?,articlePeople=?,articleState=?,articlePic=?,articleIsDel=? where articleId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getArticleTitle());
			ps.setTimestamp(2, model.getArticleDate());
			ps.setString(3, model.getArticleContent());
			ps.setInt(4, model.getArticlePeople());
			ps.setInt(5, model.getArticleState());
			ps.setString(6, model.getArticlePic());
			ps.setBoolean(7, model.getArticleIsDel());
			ps.setInt(8, model.getArticleId());
			int i=ps.executeUpdate();
			bool = i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	/**
	 * 根据博文编号删除信息(软删除),测试通过
	 */
	@Override
	public boolean delete(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		boolean bool=false;
		String sql="update ArticleInfo set articleIsDel=1 where articleId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			bool = i>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, null);
		}
		return bool;
	}

	/**
	 * 根据编号查询博文信息,测试通过
	 */
	@Override
	public ArticleInfo selectById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArticleInfo article=null;
		
		String sql="select * from ArticleInfo where articleId=?";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			article = getModel(rs).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		
		return article;
	}

	/**
	 * 查询所有博文信息,测试通过
	 */
	@Override
	public List<ArticleInfo> selectAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		
		String sql="select * from ArticleInfo";
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			list = getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	/**
	 * 根据条件查询
	 */
	@Override
	public List<ArticleInfo> selectByWhere(String strWhere) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=null;
		
		String sql="select * from ArticleInfo";
		if(strWhere!=null&&"".equals(strWhere)){
			sql=sql+" where "+strWhere;
		}
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			list = getModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, ps, rs);
		}
		return list;
	}

	/**
	 * 通用存储过程分页查询,测试通过
	 */
	@Override
	public PageList<ArticleInfo> getProcList(String showFields, String tableName,
			String strWhere, String colName, int pageIndex, int pageSize) {
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		PageList<ArticleInfo> page=null;
		
		String sql="{call getProcList(?,?,?,?,?,?,?,?)}";
		try {
			conn=DBUtil.getConn();
			cs=conn.prepareCall(sql);
			cs.setString(1, showFields);
			cs.setString(2, tableName);
			cs.setString(3, strWhere);
			cs.setString(4, colName);
			cs.setInt(5, pageIndex);
			cs.setInt(6, pageSize);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.INTEGER);
			rs = cs.executeQuery();
			int sumCount=cs.getInt(7);
			int pageCount=cs.getInt(8);
			List list = getModel(rs);
			page=new PageList<ArticleInfo>();
			page.setSumCount(sumCount);
			page.setPageCount(pageCount);
			page.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, cs, rs);
		}
		return page;
	}

	/**
	 * 将resultSet转换为List集合,测试通过
	 */
	@Override
	public List<ArticleInfo> getModel(ResultSet rs) {
		List list=new ArrayList<ArticleInfo>();
		try {
		while(rs.next()){
			ArticleInfo article=new ArticleInfo();
			article.setArticleId(rs.getInt("articleId"));
			article.setArticleTitle(rs.getString("articleTitle"));
			article.setArticleDate(rs.getTimestamp("articleDate"));
			article.setArticleContent(rs.getString("articleContent"));
			article.setArticlePeople(rs.getInt("articlePeople"));
			article.setArticleState(rs.getInt("articleState"));
			article.setArticlePic(rs.getString("articlePic"));
			article.setArticleIsDel(rs.getBoolean("articleIsDel"));
			list.add(article);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		ArticleDao dao=(ArticleDao) DaoFactory.createArticleDao();
//		批量插入
//		for(int i=0;i<25;i++){
//			ArticleInfo model=new ArticleInfo();
//			model.setArticleTitle("今日哥就要回学校了！"+i);
//			model.setArticleDate(new Timestamp(System.currentTimeMillis()));
//			model.setArticleContent("12345,坐车回学校！"+i);
//			if(dao.insert(model)){
//				System.out.println("第"+i+"个:插入成功！");
//			}
//		}
//		查询所有
//		List list = dao.selectAll();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
		
//		ArticleInfo article = dao.selectById(1);
//		System.out.println("byId"+article);
//		
//		if(dao.delete(1)){
//			System.out.println("删除成功！");
//		}
		
//		分页查询
//		PageList<ArticleInfo> page=dao.getProcList("*", "ArticleInfo", "", "articleId", 2, 5);
//		List list=page.getList();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
		
		ArticleInfo model=dao.selectById(1);
		model.setArticleTitle("54321");
		if(dao.update(model)){
			System.out.println("修改成功！");
		}
		
		
	}
}
