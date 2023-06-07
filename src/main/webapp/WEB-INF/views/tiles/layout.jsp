<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>web site / layout.jsp</title>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<main>
		<tiles:insertAttribute name="content" />
	</main>
	<footer>
		<hr>
		<div style="text-align: center;">
			<h1>예담 직업 전문학교</h1>
		</div>
	</footer>
</body>
</html>