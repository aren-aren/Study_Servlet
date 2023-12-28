<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Add</h1>
	<form action="./addProcess.jsp">
		<div>
			<label for="department_id">부서 아이디 : </label>
			<input type="text" id="department_id" name="department_id">
		</div>
		<div>
			<label for="department_name">부서 이름 : </label>
			<input type="text" id="department_name" name="department_name">
		</div>
		<div>
			<label for="manager_id">매니저 아이디 : </label>
			<input type="text" id="manager_id" name="manager_id">
		</div>
		<div>
			<label for="location_id">위치 아이디 : </label>
			<input type="text" id="location_id" name="location_id">
		</div>
		<button>추가</button>
	</form>
</body>
</html>