package top.johnxiao.blog.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PowerFilter implements Filter{

   String[] strs;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
//		拦截 .do 结尾
//		判断  login.do  放行
		String uri = request.getRequestURI();
		int start  = uri.lastIndexOf("/");
		int end = uri.lastIndexOf(".");
		String path = uri.substring(start+1,end);
		System.out.println(path);
//		特权
		for (int i = 0; i < strs.length; i++) {
			if(path.equals(strs[i])){
				chain.doFilter(request, response);
				return;
			}
		}
//		其他的 如果没有登录，那么login.jsp,已经登录，放行
//		获取session中的user对象
		Object object = request.getSession().getAttribute("user");
		if(object==null){
//			跳转到登录页面
			response.sendRedirect("login.jsp");
			return;
		}
			chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
        String str= config.getInitParameter("exclude");
        strs = str.split("\\,");
	}
	
	@Override
	public void destroy() {

	}

}
