package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;

@WebServlet("/delete")
public class Delete extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	UserDao dao=new UserDao();
	UserDto dto = dao.find(id);
	dao.delete(dto);
	res.getWriter().print("<h1>Data deleted sucessfully</h1>");
	req.setAttribute("list",dao.fetchall());
	req.getRequestDispatcher("Table.jsp").include(req, res);
	
}
}
