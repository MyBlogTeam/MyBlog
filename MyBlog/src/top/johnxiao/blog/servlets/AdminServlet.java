package top.johnxiao.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import top.johnxiao.blog.core.DaoFactory;
import top.johnxiao.blog.dao.impl.AdminDao;
import top.johnxiao.blog.dto.AdminInfo;

public class AdminServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		// 转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String action = request.getParameter("action");

		if ("login".equals(action)) {
			login(request, response);
		}

	}
	
	
	private void login(HttpServletRequest request,HttpServletResponse response){
		try {
//		获取用户名和密码
		String userName=request.getParameter("userName");
		String pwd=request.getParameter("pwd");
		String sql="adminName='"+userName+"' and adminPwd='"+pwd+"'";
//		查询用户
		AdminDao adao=(AdminDao) DaoFactory.createAdminDao();
		List list = adao.selectByWhere(sql);
		
		PrintWriter out=response.getWriter();
		if(list.size()>0){
			System.out.println("用户存在！");
			AdminInfo admin=(AdminInfo) list.get(0);
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("back/bgMain.jsp");
		}else{
			System.out.println("用户不存在！");
			out.println("<script>用户不存在，此次登录失败，请重新登录！</script>");
//			out.println("<script>history.go(-1);</script>");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
