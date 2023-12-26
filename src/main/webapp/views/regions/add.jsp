<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regions Add</h1>
	
	<form action="./addProcess.jsp">
		<div>
			<label for="region_id">대륙 ID : </label>
			<input id="region_id" name="region_id" type="text">
		</div>
		<div>
			<label for="region_name">대륙명 : </label>
			<input id="region_name" name="region_name" type="text">
		</div>
		<button>추가</button>
	</form>
</body>
</html>