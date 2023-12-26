<%@page import="com.studyservlet.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.studyservlet.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO departmentDAO = new DepartmentDAO();
	List<DepartmentDTO> list = departmentDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department List</h1>
	<table>
		<thead>
			<tr>
				<th>DEPARTMENT_ID</th>
				<th>DEPARTMENT_NAME</th>
				<th>MANAGER_ID</th>
				<th>LOCATION_ID</th>
			</tr>
		</thead>
		<tbody>
			<% for(DepartmentDTO dto : list) { %>
				<tr>
					<td><%= dto.getDepartment_id() %></td>
					<td><a href="./detail.jsp?department_id=<%=dto.getDepartment_id()%>"><%= dto.getDepartment_name() %></a></td>
					<td><%= dto.getManager_id() %></td>
					<td><%= dto.getLocation_id() %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>