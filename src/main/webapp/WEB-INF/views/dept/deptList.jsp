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
<h3>부서 목록</h3>
	<!-- 등록 페이지 이동 -->
	<a href="deptInsert">등록페이지로 이동 >></a><br><br>
<form action="deptList">
부서명 <input name="departmentName" value="${dept.departmentName}">
지역 <input name="locationId" value="${dept.locationId}">
<button>검색</button>
<button type="reset">초기화</button>
</form><br><br>
<div>
<table border="1">
    <tr>
        <th>부서번호</th>
        <th>부서이름</th>
        <th>사수</th>
        <th>지역번호</th>
        <th colspan="2"></th>
    </tr>
    <c:forEach items="${deptList}" var="dept">
    <tr>
        <td>${dept.departmentId}</td>
        <td>${dept.departmentName}</td>
        <td>${dept.managerId}</td>
        <td>${dept.locationId}</td>
        <td><a href="deptUpdate?deptId=${dept.departmentId}">수정</a></td>
		<td><a href="deptDelete?deptId=${dept.departmentId}">삭제</a></td>
    </tr>
    </c:forEach>
</table>
</div>
</body>
</html>