<%@page import="com.studyservlet.app.regions.RegionDTO"%>
<%@page import="com.studyservlet.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	RegionDAO dao = new RegionDAO();
	RegionDTO dto = new RegionDTO();
	
	String id = request.getParameter("region_id");
	int num = Integer.parseInt(id);
	dto.setRegion_id(num);
	dto = dao.getDetail(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3><%= dto.getRegion_name() %></h3>
</body>
</html>