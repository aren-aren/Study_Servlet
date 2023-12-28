<%@page import="com.studyservlet.app.departments.DepartmentDTO"%>
<%@page import="com.studyservlet.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO dao = new DepartmentDAO();
	DepartmentDTO dto = new DepartmentDTO();
	
	String did = request.getParameter("department_id");
	String name = request.getParameter("department_name");
	String mid = request.getParameter("manager_id");
	String lid = request.getParameter("location_id");
	
	dto.setDepartment_id(Integer.parseInt(did));
	dto.setDepartment_name(name);
	dto.setManager_id(Integer.parseInt(mid));
	dto.setLocation_id(Integer.parseInt(lid));
	
	int result = dao.update(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Update Process</h1>
</body>
</html>