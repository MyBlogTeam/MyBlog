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

import com.google.gson.Gson;

import top.johnxiao.blog.core.DaoFactory;
import top.johnxiao.blog.dao.impl.AdminDao;
import top.johnxiao.blog.dto.AdminInfo;
import top.johnxiao.blog.dto.PageList;

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
		} else if ("selectAll".equals(action)) {
			selectAll(request, response);
		}else if("getProcList".equals(action)){
			getProcList(request, response);
			
		}else if("getList".equals(action)){
			System.out.println("已向getList方法发起了请求");
			getList(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 获取用户名和密码
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String sql = "adminName='" + userName + "' and adminPwd='" + pwd + "'";
		// 查询用户
		AdminDao adao = (AdminDao) DaoFactory.createAdminDao();
		List list = adao.selectByWhere(sql);

		PrintWriter out = response.getWriter();
		if (list.size() > 0) {
			System.out.println("用户存在！");
			AdminInfo admin = (AdminInfo) list.get(0);
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("back/bgMain.jsp");
		} else {
			System.out.println("用户不存在！");
			out.println("<script>用户不存在，此次登录失败，请重新登录！</script>");
			out.println("<script>history.go(-1);</script>");
		}

	}

	private void selectAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		AdminDao adao = (AdminDao) DaoFactory.createAdminDao();
		// Gson gson=new Gson();
		// List list = adao.selectAll();
		// String json=gson.toJson(list);
		// System.out.println(json);
		// request.getSession().setAttribute("Json", json);
		// response.sendRedirect("back/bgAdmin.jsp");
		// request.getRequestDispatcher("back/bgAdmin.jsp").forward(request,
		// response);
		List list = adao.selectAll();
		request.getSession().setAttribute("adminList", list);
		response.sendRedirect("back/bgAdmin3.jsp");
	}

	private void getProcList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		AdminDao adao = (AdminDao) DaoFactory.createAdminDao();
		PrintWriter out = response.getWriter();

		// 得到客户端传递的页码和每页记录数，并转换成int类型
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
//		String orderNum = request.getParameter("orderNum");
		System.out.println("pageSize:"+pageSize);
		System.out.println("pageNumber:"+pageNumber);
		
		PageList<AdminInfo> page = adao.getProcList("*", "AdminInfo", "", "adminId", pageNumber, pageSize);
		Gson gson=new Gson();
		List list = page.getList();
		String admins=gson.toJson(list);
		int total=page.getSumCount();
//		// 分页查找商品销售记录，需判断是否有带查询条件
//		List<SimsSellRecord> sellRecordList = null;
//		sellRecordList = sellRecordService.querySellRecordByPage(pageNumber,
//				pageSize, orderNum);
//
//		// 将商品销售记录转换成json字符串
//		String sellRecordJson = sellRecordService
//				.getSellRecordJson(sellRecordList);
//		// 得到总记录数
//		int total = sellRecordService.countSellRecord(orderNum);

		// 需要返回的数据有总记录数和行数据
		String json = "{\"total\":" + total + ",\"rows\":" + admins + "}";
		System.out.println(json);
		out.print(json);
	}
	
	private void getList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		AdminDao adao = (AdminDao) DaoFactory.createAdminDao();
		PrintWriter out = response.getWriter();
		
//		int pageSize = Integer.parseInt(request.getParameter("limit"));
//		int pageNumber = Integer.parseInt(request.getParameter("offset"));
		
		String pages = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数  
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        int pageSize = Integer.parseInt(rows);
		int pageNumber = Integer.parseInt(pages);
        
		System.out.println("pageSize"+pageSize);
		System.out.println("pageNumber"+pageNumber);
//		int pageNumber =1;
		
		PageList<AdminInfo> page = adao.getProcList("*", "AdminInfo", "", "adminId", pageNumber, pageSize);
		Gson gson=new Gson();
		List list = page.getList();
		String admins=gson.toJson(list);
		int total=page.getSumCount();
		String json = "{\"total\":" + total + ",\"rows\":" + admins + "}";
		System.out.println(json);
		out.print(json);
	}
}
