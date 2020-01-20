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
<h1>응답페이지</h1>
	<%
		//서블릿이 공유한 데이터 꺼내기
		int result = (int)request.getAttribute("myresult");
	//getAttribute는 오브젝트 형태로 나오기 때문에 캐스팅이 필요하다. 
	//만약 (int)가 안되면 (Integer)라고 해줄것 
		
	%>
	<h1>응답페이지</h1>
	<hr/>
	<h2><%= result %> 개 행 삽입성공 </h2>
	<hr/>
	

</body>
</html>