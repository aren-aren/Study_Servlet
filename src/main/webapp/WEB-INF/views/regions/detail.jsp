<%@page import="com.studyservlet.app.regions.RegionDTO"%>
<%@page import="com.studyservlet.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
/*  	RegionDAO dao = new RegionDAO();
	RegionDTO dto = new RegionDTO();
	
	String id = request.getParameter("region_id");
	int num = Integer.parseInt(id);
	dto.setRegion_id(num);
	dto = dao.getDetail(dto); */
	
	RegionDTO dto = (RegionDTO)request.getAttribute("detail");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3>${ requestScope.detail.region_id }</h3>
	<h3>${ requestScope.detail.region_name }</h3>
	<input type="hidden" value="${ requestScope.detail.region_id }">
	<button id="btn">수정</button>
	
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		btn.addEventListener("click", function(){
			let rId = document.querySelector("input[type=hidden]").value;
			location.href="./update.jsp?region_id="+rId;
		});
	</script>
</body>
</html>