<%@page import="dto.UserDto"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Enter Your Updated Details</h1>
<% int id=Integer.parseInt(request.getParameter("id")); 
UserDao dao=new UserDao();
UserDto dto=dao.find(id);
%>
<form action="update" method="post">
<table>
<tr>
<th>Enter the Id:</th>
<th> <input type="text" name="id" placeholder="enter the id" value="<%= dto.getId() %>"> </th>
</tr>
<tr>
<th>Enter the Email:</th>
<th> <input type="email" name="email" placeholder="enter the email" value="<%= dto.getEmail() %> "> </th>
</tr>
<tr>
<th>Enter the Mobile:</th>
<th> <input type="number" name="number" placeholder="enter the number" value="<%= dto.getMobile() %>"> </th>
</tr>
<tr>
<th>Enter the Name:</th>
<th> <input type="text" name="name" placeholder="enter the name" value="<%= dto.getName()  %>"> </th>
</tr>
<tr>
<th>Enter the Password:</th>
<th> <input type="password" name="password" placeholder="enter the password" value="<%= dto.getPassword()  %>"> </th>
</tr>
<tr> 
<th><button type="reset"> Cancel </button> </th>
<th><button>Update</button></th>
</tr>
</table>
</form>
</body>
</html>