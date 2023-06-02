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
	<h2>사원 조회</h2>
	<!-- 등록 페이지 이동 -->
	<a href="empInsert">등록페이지로 이동 >></a><br><br>
	<form action="empList">
		부서번호 <input name="departmentId" value="${emp.departmentId }"> <!-- empController : @ModelAttribute("emp") EmpVO vo -->
		fname <input name="firstName" value="${emp.firstName }"> 
		<button>검색</button>
		<button type="reset">초기화</button>
	</form><br><br>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>사원 번호</th>
					<th>이름</th>
					<th>email</th>
					<th>입사일</th>
					<th>부서번호</th>
					<th>부서</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="emp">
					<tr>
						<td>${emp.employeeId }</td>
						<td>${emp.firstName }_${emp.lastName }</td>
						<td>${emp.email }</td>
						<td>${emp.hireDate }</td>
						<td>${emp.departmentId }</td>
						<td>${emp.jobId }</td>
						<td><a href="empUpdate?empId=${emp.employeeId}">수정</a></td>
						<td><a href="empDelete?empId=${emp.employeeId}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>