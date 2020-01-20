package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "delete", urlPatterns = { "/dept/delete.do" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//하이퍼링크에서 요청했으므로 get방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		System.out.println("실행완료");
		PrintWriter pw = response.getWriter();
		
		//1. 요청정보 추출
		String deptNo = request.getParameter("deptNo");
		
		//2.비지니스메소드 호출
		DeptDAO dao = new DeptDAO();
		int result = dao.delete(deptNo);
		
		//3.응답메시지 생성
		response.sendRedirect("/serverweb/member/list.do");

	}

}
