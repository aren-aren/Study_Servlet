<%@page import="com.studyservlet.app.departments.DepartmentDTO"%>
<%@page import="com.studyservlet.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO dao = new DepartmentDAO();
	DepartmentDTO dto = new DepartmentDTO();

	String id = request.getParameter("department_id");
	int n = Integer.parseInt(id);
	dto.setDepartment_id(n);
	
	dto = dao.getDetail(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DepartMent Detail</h1>
	<table>
		<tr>
			<th>부서 아이디</th>
			<td><%=dto.getDepartment_id() %></td>
		</tr>
		<tr>
			<th>부서 이름</th>
			<td><%=dto.getDepartment_name() %></td>
		</tr>
		<tr>
			<th>매니저 아이디</th>
			<td><%=dto.getManager_id() %></td>
		</tr>
		<tr>
			<th>위치 아이디</th>
			<td><%=dto.getLocation_id() %></td>
		</tr>
	</table>
	<a href="./update.jsp?department_id=<%= id %>">수정</a>
</body>
</html>