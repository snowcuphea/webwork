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
				System.out.println("실행완료");
				PrintWriter pw = response.getWriter();
				
				//1. 요청정보 추출
				String id = request.getParameter("id");
				
				//2.비지니스메소드 호출
				MemberDAO dao = new MemberDAO();
				int result = dao.delete(id);
				
				request.setAttribute("result", result);
				
				//3.응답메시지 생성
				response.sendRedirect("/serverweb/member/list.do");
	}

}
