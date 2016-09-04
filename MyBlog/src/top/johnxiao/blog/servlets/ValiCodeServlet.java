package top.johnxiao.blog.servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.johnxiao.blog.util.ValiCodeFactory;

public class ValiCodeServlet extends HttpServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
//		设置输出流
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		
//		创建一个图像
		int width=80;
		int height=30;
		
//		设置颜色的取值方式
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
//		获取画笔
		Graphics g=image.getGraphics();
//		绘制验证码
//		1、设置画笔颜色
		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height);
//		2、获取验证码
		String valiCode=ValiCodeFactory.CreateValidCode(4);
//		3、修改画笔颜色
		g.setColor(Color.black);
//		4、设置字体样式
//		Arial 字体类型   Font.ITALIC 风格   50 字号
//		Font.BOLD 粗体 |Font.ITALIC 斜体|Font.PLAIN 正常
		Font font=new Font("Arial", Font.ITALIC, 30);
		g.setFont(font);
		for(int i=0;i<valiCode.length();i++){
			char c = valiCode.charAt(i);
			g.drawString(String.valueOf(c), (i+1)*13, 25);
		}
//		将验证码保存在session
		request.getSession().setAttribute("valiCode",valiCode);
//		设置显示
		g.dispose();
//		将图像输出到页面
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
}
