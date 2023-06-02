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
<form action="empUpdate" method="post" name="frm">
		사원 번호 <input name="employeeId" readonly="readonly" value="${emp.employeeId}"><br> <!-- readonly : 태그값을 넘겨줌  // disabled : 태그값 안 넘겨줌 -->
		date   <input name="hireDate" readonly="readonly" value="${emp.hireDate}"><br>
		fname  <input name="firstName" value="${emp.firstName}"><br>
		lname * <input name="lastName" value="${emp.lastName}"><br>
		email * <input name="email" value="${emp.email}"><br><br>
		departmentId <br>
		<c:forEach items="${depts}" var="dept" varStatus="status">
			<input type="radio" name="departmentId" value="${dept.departmentId}"
			<c:if test="${emp.departmentId == dept.departmentId}">checked</c:if>>${dept.departmentName}
			<c:choose>
				<c:when test="${(status.index+1) %3==0}"><br></c:when>
			</c:choose>
		</c:forEach><br><br>
		
		<select name="jobId">
		<option value="">직무</option>
		<c:forEach items="${jobs}" var="job">
			<option value="${job.jobId}">${job.jobTitle}</option>
			<!-- <option value="${job.jobId}" <c:if test="${emp.jobId == job.jobId}">selected</c:if>>${job.jobTitle}</option> -->
		</c:forEach>
		</select><br><br>
		<button>저장</button>
	</form>
</body>

<script>
frm.jobId.value = "${emp.jobId}"
</script>
</html>