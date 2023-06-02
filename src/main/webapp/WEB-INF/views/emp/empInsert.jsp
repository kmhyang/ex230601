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
<form action="empInsert" method="post">
		<!-- 사원 번호 <input name="employeeId" readonly><br> -->
		fname  <input name="firstName"><br>
		lname * <input name="lastName"><br>
		email * <input name="email"><br><br>
		departmentId <br>
		<c:forEach items="${depts}" var="dept" varStatus="status">
			<input type="radio" name="departmentId" value="${dept.departmentId}">${dept.departmentName}
			<c:choose>
				<c:when test="${(status.index+1) %3==0}"><br></c:when>
			</c:choose>
		</c:forEach><br><br>
		
		<select name="jobId">
		<option value="">직무</option>
		<c:forEach items="${jobs}" var="job">
			<option value="${job.jobId}">${job.jobTitle}</option>
		</c:forEach>
		</select><br>
		<button>저장</button>
	</form>
</body>
</html>