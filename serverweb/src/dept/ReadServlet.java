package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet(name = "deptread", urlPatterns = { "/dept/read.do" })
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��������û");
		
		request.setCharacterEncoding("euc-kr"); //post��Ŀ����� ���� 
		response.setContentType("text/html;charset=euc-kr");

		PrintWriter pw = response.getWriter();
		System.out.println("read������");
		//1. ��û���� ���� 
		//	- Ŭ���̾�Ʈ�� ���� ���±׿� �Է��� ������. �ʿ信 ���ؼ� �ѱ� �Ķ���� ����
		//	- �⺻������ ��� POST��Ŀ����� ����, get����� ��� �����Ϸ��� server.xml�� ������ �����Ѵ�.
		String deptNo = request.getParameter("deptNo");
		String info = request.getParameter("info");
		System.out.println("�ѱ���������");
		
		//2.�����Ͻ��޼ҵ� ȣ��
		DeptDAO dao = new DeptDAO();
		DeptDTO dede = dao.read(deptNo);
		
		//3.  jsp�� �Ѱ� �� ������ �����ϱ� 
		request.setAttribute("deptInfo", dede);
		
		
		//4.��û ������(forward) - ������ jsp ��û�ϱ� 
		RequestDispatcher rd = request.getRequestDispatcher("/dept/dept_read.jsp");
		rd.forward(request, response);
		//forward�� ���� ���� servlet���� 
		
		
	}

}