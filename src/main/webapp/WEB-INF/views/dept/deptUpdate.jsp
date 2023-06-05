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
<h3>사원 수정</h3>
<form action="deptUpdate" method="post" name="frm">
		부서 번호 <input name="departmentId" readonly="readonly" value="${dept.departmentId}"><br>
		부서명  <input name="departmentName" value="${dept.departmentName }"><br>
		<br>
		managerId <br>
		<select name="managerId">
		<option value="">사수</option>
		<c:forEach items="${managers}" var="m">
			<option value="${m.managerId}" <c:if test="${m.managerId == dept.managerId}">selected</c:if>>${m.firstName}_${m.lastName}</option>
		</c:forEach>
		</select><br>
		
		locationId <br>
		<select name="locationId">
		<option value="">지역</option>
		<c:forEach items="${locations}" var="loc">
			<option value="${loc.locationId}" <c:if test="${loc.locationId == dept.locationId}">selected</c:if>>${loc.city}</option>
		</c:forEach>
		</select><br><br>
		<button>저장</button>
	</form>
</body>
</html>