
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
		//������ �������� ArrayList<DeptDTO> ��ü ��������
		ArrayList<MemberDTO> memlist = (ArrayList<MemberDTO>)request.getAttribute("memberlist");

		int size = (int)request.getAttribute("size");
	%>

	<h1>�μ� ��� ��ȸ</h1>
	<hr/>

	<table border=1>
	<tr>
	<th>���̵�</th><th>���</th><th>�̸�</th><th>�ּ�</th><th>�μ���ȣ</th><th>�Ի���</th><th>����Ʈ</th><th>����</th>
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
			<a href="/serverweb/member/delete.do?id=<%=mem.getId() %>">����</a></td>
		</tr>
		<%
			}
		%>

	</table>


</body>
</html>