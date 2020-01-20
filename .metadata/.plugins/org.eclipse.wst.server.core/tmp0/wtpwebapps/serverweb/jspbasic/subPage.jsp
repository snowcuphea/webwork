<%@page import="dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//서블릿이 공유한 데이터 꺼내오기
		DeptDTO dept = (DeptDTO)request.getAttribute("mydata");
		//캐스팅해줘야함. setAttribute는 object 라서 (상위객체)
	%>
	<h1>요청재지정으로 실행될 페이지</h1>
	<hr/>
	<h2>공유데이터 : <%= dept.getDeptName() %> </h2>
	<hr/>
	

</body>
</html>