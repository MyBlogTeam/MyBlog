package top.johnxiao.blog.dao;

import java.sql.ResultSet;
import java.util.List;

import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;

public interface IBaseDao<T> {
//	插入
	public boolean insert(T model);
//	修改
	public boolean update(T model);
//	删除
	public boolean delete(int id);
//	根据编号查询
	public T selectById(int id);
//	查询所有
	public List<T> selectAll();
//	条件差询
	public List<T> selectByWhere(String strWhere);
//	存储过程分页
	public PageList<T> getProcList(String showFields,String tableName,String strWhere,String colName,int pageIndex,int pageSize);
//	由resultSet得到List
	public List<T> getModel(ResultSet rs);
}
