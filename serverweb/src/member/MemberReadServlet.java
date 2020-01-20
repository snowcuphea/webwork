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

@WebServlet(name = "memRead", urlPatterns = { "/member/read.do" })
public class MemberReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("��������û");
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		
		
		PrintWriter pw = response.getWriter();
		//1. ��û���� ���� 
				// - Ŭ���̾�Ʈ�� ���� ���±׿� �Է��� ������. �ʿ信 ���ؼ� �ѱ� �Ķ���� ����	
		String id = request.getParameter("id");
		
		//2.�����Ͻ��޼ҵ� ȣ��
		MemberDAO dao = new MemberDAO();
		MemberDTO memmem = dao.read(id);
		
		//3.  jsp�� �Ѱ� �� ������ �����ϱ� 
		request.setAttribute("memInfo", memmem);
		RequestDispatcher rd = request.getRequestDispatcher("/member/member_read.jsp");
		rd.forward(request, response);
		
	}

}