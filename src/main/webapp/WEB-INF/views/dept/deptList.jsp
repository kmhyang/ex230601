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
<form action="deptList">
<table border="1">
    <tr>
        <th>부서번호</th>
        <th>부서이름</th>
        <th>사수</th>
        <th>지역번호</th>
    </tr>
    <c:forEach items="${deptList}" var="dept">
    <tr>
        <td>${dept.departmentId}</td>
        <td>${dept.departmentName}</td>
        <td>${dept.managerId}</td>
        <td>${dept.locationId}</td>
    </tr>
    </c:forEach>
</table>
</form>
</body>
</html>