<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 등록</title>
</head>
<body>
	<h3>부서 등록</h3>
	<form action="depInsert" method="post">
		<div>
			<label for="name">부서이름</label>
			<input type="text" id="name" name="departmentName" required>
		</div>
		<div>
			<label for="mId">매니저번호</label>
			<input type="number" id="mId" name="managerId">
		</div>
		<div>
			<label for="lId">지역번호</label>
			<input type="number" id="lId" name="locationId" >
		</div> <br>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='depList'">목록</button>
	</form>
</body>
</html>