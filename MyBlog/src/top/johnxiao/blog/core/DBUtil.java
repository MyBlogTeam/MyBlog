package top.johnxiao.blog.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private static String DRIVER = "";
	private static String URL = "";
	private static String USER = "";
	private static String PWD = "";
	private static int MAX_ACTIVE = 10;
	private static BasicDataSource bds = null;
	private static Properties pp = null;
	private static FileInputStream fis = null;
	

	static {
	String path = DBUtil.class.getResource("/dbInfo.properties").getPath();
	try {
		bds = new BasicDataSource();
		fis = new FileInputStream(path);
		pp = new Properties();
		pp.load(fis);
		DRIVER = pp.getProperty("DRIVER");
		URL = pp.getProperty("URL");
		USER = pp.getProperty("USER");
		PWD = pp.getProperty("PWD");
		MAX_ACTIVE = Integer.parseInt(pp.getProperty("MAX_ACTIVE"));
		bds.setDriverClassName(DRIVER);
		bds.setUrl(URL);
		bds.setUsername(USER);
		bds.setPassword(PWD);
		bds.setMaxActive(MAX_ACTIVE);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

	
	public static void initDBInfo(String driver,String url,String user,String pwd,int maxActive){
		bds=new BasicDataSource();
		bds.setDriverClassName(driver);
		bds.setUrl(url);
		bds.setUsername(user);
		bds.setPassword(pwd);
		bds.setMaxActive(maxActive);
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConn(Connection conn, Statement st, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(conn!=null){
//				利用dbcp连接数据库，此时关闭并非真正的关闭
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
