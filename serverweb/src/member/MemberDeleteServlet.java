package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;

@WebServlet(description = "memDel", urlPatterns = { "/member/delete.do" })
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
				
				request.setCharacterEncoding("euc-kr");
				response.setContentType("text/html;charset=euc-kr");
				System.out.println("����Ϸ�");
				PrintWriter pw = response.getWriter();
				
				//1. ��û���� ����
				String id = request.getParameter("id");
				
				//2.�����Ͻ��޼ҵ� ȣ��
				MemberDAO dao = new MemberDAO();
				int result = dao.delete(id);
				
				request.setAttribute("result", result);
				
				//3.����޽��� ����
				response.sendRedirect("/serverweb/member/list.do");
	}

}