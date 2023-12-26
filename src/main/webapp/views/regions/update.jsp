<%@page import="com.studyservlet.app.regions.RegionDTO"%>
<%@page import="com.studyservlet.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RegionDAO dao = new RegionDAO();
	RegionDTO dto = new RegionDTO();
	
	int id = Integer.parseInt(request.getParameter("region_id"));
	dto.setRegion_id(id);
	
	dto = dao.getDetail(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Update</h1>
	<form action="./updateProcess.jsp">
		<div>
			<label for="region_id">대륙 ID : </label>
			<input id="region_id" name="region_id" readonly="readonly" type="text" value="<%=dto.getRegion_id()%>">
		</div>
		<div>
			<label for="region_name">대륙명 : </label>
			<input id="region_name" name="region_name" type="text" value="<%=dto.getRegion_name()%>">
		</div>
		<button>수정</button>
	</form>
</body>
</html>