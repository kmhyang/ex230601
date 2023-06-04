<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사원 등록</h3>
<form action="deptInsert" method="post">
		<!-- 사원 번호 <input name="employeeId" readonly><br> -->
		부서명  <input name="departmentName"><br>
		<br>
		managerId <br>
		
		<select name="managerId">
		<option value="">사수</option>
		<c:forEach items="${managers}" var="m">
			<option value="${m.managerId}">${m.firstName}_${m.lastName}</option>
		</c:forEach>
		</select><br>
		
		locationId <br>
		<select name="locationId">
		<option value="">지역</option>
		<c:forEach items="${locations}" var="loc">
			<option value="${loc.locationId}">${loc.city}</option>
		</c:forEach>
		</select><br>
		<button>저장</button>
	</form>
</body>
</html>