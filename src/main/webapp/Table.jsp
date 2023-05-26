<%@page import="dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<UserDto> list=(List<UserDto>)request.getAttribute("list");  %>
<table border="1px">
<tr>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Mobile</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%for(UserDto dto:list)
	{%>
	<tr>
	<th><%=dto.getName() %></th>
	<th><%=dto.getEmail() %> </th>
	<th><%=dto.getPassword() %> </th>
	<th><%=dto.getMobile() %> </th>
	<th><a href="edit.jsp?id=<%= dto.getId() %>"><button>Edit</button></a></th>
	<th><a href="delete?id=<%= dto.getId() %>"><button>Delete</button></a></th>
	</tr>
	<%} %>	
</table>
<a href="Login.html"><button>Logout</button></a>
</body>
</html>