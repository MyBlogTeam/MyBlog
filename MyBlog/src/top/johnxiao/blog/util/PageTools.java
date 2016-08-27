//package top.johnxiao.blog.util;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//
//public class PageTools {
//
//	private String select;
//	private String from;
//	private String where;
//	private String orderAndGroup;
//	private int pageSize = 2;
//	private String gotoPage = "1";
//	private List pageNumList = new ArrayList();
//
//	private DBOperate dbo = new DBOperate();
//
//	public PageTools(String select, String from, String where,
//			String orderAndGroup, String gotoPage, int pageSize) {
//		super();
//		this.select = select;
//		this.from = from;
//		this.where = where;
//		this.orderAndGroup = orderAndGroup;
//		this.pageSize = pageSize;
//		this.gotoPage = gotoPage;
//	}
//
//	private int getRecordCount() throws SQLException, ClassNotFoundException {
//
//		String getRecordCountSQL = "select count(*) as recordCount " + " "
//				+ from + " " + where;
//
//		List returnRecordCountList = dbo.query(getRecordCountSQL, null);
//
//		int returnRecordCountInt = 0;
//
//		if (orderAndGroup.indexOf("group by") >= 0) {
//			returnRecordCountInt = returnRecordCountList.size();
//		} else {
//			returnRecordCountInt = Integer
//					.parseInt(((HashMap) returnRecordCountList.get(0)).get(
//							"recordCount").toString());
//		}
//		return returnRecordCountInt;
//
//	}
//
//	public List getPage() throws SQLException, ClassNotFoundException {
//
//		int pageCount = 0;
//
//		if (this.getRecordCount() % pageSize != 0) {
//			pageCount = this.getRecordCount() / pageSize + 1;
//		} else {
//			pageCount = this.getRecordCount() / pageSize;
//		}
//
//		for (int i = 0; i < pageCount; i++) {
//			pageNumList.add(i + 1);
//		}
//
//		int beginPos = (Integer.parseInt(gotoPage) - 1) * pageSize;
//
//		String getpageSQL = select + " " + from + " " + where + " "
//				+ orderAndGroup + " limit " + beginPos + "," + pageSize;
//		System.out.println("getpageSQL=" + getpageSQL);
//		return dbo.query(getpageSQL, null);
//	}
//
//	public List getPageNumList() {
//		return pageNumList;
//	}
//
//}
