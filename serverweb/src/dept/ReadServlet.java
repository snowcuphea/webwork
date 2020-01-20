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
		System.out.println("서블릿요청");
		
		request.setCharacterEncoding("euc-kr"); //post방식에서만 적용 
		response.setContentType("text/html;charset=euc-kr");

		PrintWriter pw = response.getWriter();
		System.out.println("read서블릿");
		//1. 요청정보 추출 
		//	- 클라이언트가 직접 폼태그에 입력한 데이터. 필요에 의해서 넘긴 파라미터 추출
		//	- 기본설정인 경우 POST방식에서만 적용, get방식인 경우 적용하려면 server.xml의 설정을 변경한다.
		String deptNo = request.getParameter("deptNo");
		String info = request.getParameter("info");
		System.out.println("한글정보추출");
		
		//2.비지니스메소드 호출
		DeptDAO dao = new DeptDAO();
		DeptDTO dede = dao.read(deptNo);
		
		//3.  jsp로 넘겨 줄 데이터 공유하기 
		request.setAttribute("deptInfo", dede);
		
		
		//4.요청 재지정(forward) - 응답할 jsp 요청하기 
		RequestDispatcher rd = request.getRequestDispatcher("/dept/dept_read.jsp");
		rd.forward(request, response);
		//forward를 많이 쓴다 servlet에서 
		
		
	}

}
