
<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dept.DeptDAO"%>
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
		//서블릿이 공유해준 ArrayList<DeptDTO> 객체 가져오기
		ArrayList<MemberDTO> memlist = (ArrayList<MemberDTO>)request.getAttribute("memberlist");

		int size = (int)request.getAttribute("size");
	%>

	<h1>부서 목록 조회</h1>
	<hr/>

	<table border=1>
	<tr>
	<th>아이디</th><th>비번</th><th>이름</th><th>주소</th><th>부서번호</th><th>입사일</th><th>포인트</th><th>삭제</th>
	</tr>
		<%
			for (int i = 0; i < size; i++) {
				MemberDTO mem = memlist.get(i);
		%>
		<tr>
			<td><a href="/serverweb/member/read.do?id=<%=mem.getId()%>"><%=mem.getId()%></a></td>
			<td></td>
			<td><%=mem.getPass()%></td>
			<td><%=mem.getName()%></td>
			<td><%=mem.getAddr()%></td>
			<td><%=mem.getDeptno()%></td>
			<td><%=mem.getHiredate()%></td>
			<td><%=mem.getPoint()%></td>
			<td>
			<a href="/serverweb/member/delete.do?id=<%=mem.getId() %>">삭제</a></td>
		</tr>
		<%
			}
		%>

	</table>


</body>
</html>