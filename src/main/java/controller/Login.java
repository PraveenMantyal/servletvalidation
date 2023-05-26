package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;

@WebServlet("/login")
public class Login extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String emailphone = req.getParameter("emailphone");
	String password = req.getParameter("password");
	
	UserDao dao=new UserDao();
	try{
		long mobile = Long.parseLong(emailphone);
		//res.getWriter().print("<h1>You entered mobile no<h1/>");
		//UserDto dto = dao.login(mob);
//		if(dto==null)
//		{
//			//res.getWriter().print("<h1>Invalid Mobile No<h1/>");
//			req.getRequestDispatcher("Login.html").include(req, res);
//		}
//		else{
//			if(dto.getPassword().equals(password))
//			{
//				res.getWriter().print("<h1>Login sucess<h1/>");
//			}
//			else{
//				res.getWriter().print("<h1>Invalid password<h1/>");
//				req.getRequestDispatcher("Login.html").include(req, res);
//			}
//			
//		}
		UserDto dto = dao.loginm(mobile);
		if(dto==null)
		{
			res.getWriter().print("<h1>Invalid Mobile No<h1/>");
			req.getRequestDispatcher("Login.html").include(req, res);
		}
		else{
			if(dto.getPassword().equals(password))
				{
					res.getWriter().print("<h1>Login sucess<h1/>");
					req.setAttribute("list",dao.fetchall());
					req.getRequestDispatcher("Table.jsp").include(req, res);
					
				}
				else{
					res.getWriter().print("<h1>Invalid password<h1/>");
					req.getRequestDispatcher("Login.html").include(req, res);
				}
		}
		
	}
	catch (NumberFormatException e) {
		String email=emailphone;
		//res.getWriter().print("<h1>You entered email<h1/>");
		 UserDto dto = dao.logine(email);
		 if(dto==null)
		 {
			res.getWriter().print("<h1>Invalid email<h1/>");
			req.getRequestDispatcher("Login.html").include(req, res);
		 }
		 else
		 {
			 if(dto.getPassword().equals(password))
			 {
				 res.getWriter().print("<h1>Login sucess<h1/>");
				 req.setAttribute("list",dao.fetchall());
				 req.getRequestDispatcher("Table.jsp").include(req, res);
			 }
			 else
			 {
				 res.getWriter().print("<h1>Invalid password<h1/>");
				req.getRequestDispatcher("Login.html").include(req, res);
			 }
		 }
	}
		
}
}
