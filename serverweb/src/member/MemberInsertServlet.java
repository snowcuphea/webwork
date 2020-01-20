package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;
import dept.DeptDTO;


@WebServlet(name = "memInsert", urlPatterns = { "/member/insert.do" })
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		System.out.println("����Ϸ�");

		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String deptno = request.getParameter("deptno");
		String hiredate = request.getParameter("hiredate");
		int point = Integer.parseInt(request.getParameter("point"));

		System.out.println("���̵�: " + id);
		System.out.println("��й�ȣ: " + pass);
		System.out.println("�̸�: " + name);
		System.out.println("�ּ�: " + addr);
		System.out.println("�μ��ڵ�: " + deptno);
		System.out.println("�Ի���: " + hiredate);
		System.out.println("����Ʈ: " + point);
		

		//2. ����Ͻ� �޼ҵ� call
		MemberDTO mem = new MemberDTO(id, pass, name, addr, deptno, hiredate, point);
		MemberDAO dao = new MemberDAO();
		int result = dao.insert(mem);
		
		request.setAttribute("result", result);
	
		//new 3.����ȭ������ ��û������. ������ ���� sendRedirect�ϸ� �ȵǰ� RequestDispatcher�ؾ���
		RequestDispatcher rd = request.getRequestDispatcher("/member/mem_insertResult.jsp");
		rd.forward(request, response);
		
		
	}

}