package com.mmloo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmloo.dao.AdminDao;
import com.mmloo.entity.Admin;

public class MainServlet extends HttpServlet{
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
			String path = req.getServletPath();
			if("/login.do".equals(path)){
				//登陆操作
				login(req,res);
			}
	}
	protected void login(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
			//接收表单数据
			String adminCode = 
				req.getParameter("adminCode");
			String password = 
				req.getParameter("password");
			System.out.println("界面用户名"+adminCode);
			AdminDao dao = new AdminDao();
			Admin admin = dao.findByCode(adminCode);
			if(admin == null) {
				//账号错误，转发到登录页
				req.setAttribute("error", "账号错误");
				req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
					.forward(req, res);
			} else if(!admin.getcPassword().equals(password)) {
				//密码错误，转发到登录页
				req.setAttribute("error", "密码错误");
				req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
					.forward(req, res);
			} 
			System.out.println("登陆成功");
		}
	
}
