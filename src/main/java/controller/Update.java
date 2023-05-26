package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;

@WebServlet("/update")
public class Update extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 UserDto dto=new UserDto();
		dto.setEmail(req.getParameter("email"));
		dto.setName(req.getParameter("name"));
		dto.setPassword(req.getParameter("password"));
		dto.setMobile(Long.parseLong(req.getParameter("number")));
		dto.setId(Integer.parseInt(req.getParameter("id")));
		UserDao dao=new UserDao();
		dao.Update(dto);
		
		res.getWriter().print("<h1>Data Edited successfully </h1>");
		req.setAttribute("list",dao.fetchall());
		req.getRequestDispatcher("Table.jsp").include(req, res);
}
}
