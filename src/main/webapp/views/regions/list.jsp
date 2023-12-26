<%@page import="com.studyservlet.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.studyservlet.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java 구역 - 스크립틀릿
	RegionDAO regionDAO = new RegionDAO();
	List<RegionDTO> list = regionDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regions List</h1>
	<table>
		<thead>
			<tr>
				<th>REGION_ID</th>
				<th>REGION_NAME</th>
			</tr>
		</thead>
		<tbody>
			<% for(RegionDTO regionDTO : list){ //표현식 %>
				<tr>
					<td><%= regionDTO.getRegion_id() %></td>
					<td><a href="./detail.jsp?region_id=<%=regionDTO.getRegion_id() %>"><%= regionDTO.getRegion_name() %></a></td>
				</tr>	
			<% } %>
		</tbody>
	</table>
</body>
</html>