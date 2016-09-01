package top.johnxiao.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 肖伟
 * 管理员servlet，在里面自定义方法，实现后台业务逻辑
 * 复写service方法，避免post和get两种请求的选择
 * 注意：一下两种方法均可，我习惯下面第一种,统一采用下面两种的任意一种,不要采用第三种(复写doget()和doPost())
 * 此处我复写的是父类的service(ServletRequest req, ServletResponse resp)
 * 也可以复写子类的service(HttpServletRequest req,HttpServletResponse resp)
 *
 */
public class AdminServlet extends HttpServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
//		转换
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		String action=request.getParameter("action");
		
		if("".equals(action)){
			
		}
		
	}

}
