<%@page import="com.studyservlet.app.departments.DepartmentDTO"%>
<%@page import="com.studyservlet.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO dao = new DepartmentDAO();
	DepartmentDTO dto = new DepartmentDTO();
	
	dto.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
	
	dto = dao.getDetail(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./updateProcess.jsp">
	<div>
		<label for="department_id">부서 아이디 : </label>
		<input type="text" id="department_id" name="department_id" readonly="readonly" value="<%=dto.getDepartment_id()%>">
	</div>
	<div>
		<label for="department_name">부서 이름 : </label>
		<input type="text" id="department_name" name="department_name" value="<%=dto.getDepartment_name()%>"> 
	</div>
	<div>
		<label for="manager_id">매니저 아이디 : </label>
		<input type="text" id="manager_id" name="manager_id" value="<%=dto.getManager_id()%>">
	</div>
	<div>
		<label for="location_id">위치 아이디 : </label>
		<input type="text" id="location_id" name="location_id" value="<%=dto.getLocation_id()%>">
	</div>
	<button>수정</button>
	</form>
</body>
</html>