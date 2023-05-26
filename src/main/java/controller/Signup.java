package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;

@WebServlet("/signup")
public class Signup extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserDto dto=new UserDto();
		dto.setEmail(req.getParameter("email"));
		dto.setName(req.getParameter("name"));
		dto.setPassword(req.getParameter("password"));
		dto.setMobile(Long.parseLong(req.getParameter("number")));
		
	//res.getWriter().print("<h1>"+dto+"</h1>");
		
		UserDao dao=new UserDao();
		dao.save(dto);
		
	res.getWriter().print("<h1>Account created sucessfully</h1>");
	req.getRequestDispatcher("Login.html").include(req, res);
//	}
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		
//		
	}

}
