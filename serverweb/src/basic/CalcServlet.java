package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String method = request.getParameter("method");
		//2. 비즈니스메소드 호출
		int result = 0; //계산결과를 저장할 변수
		
		CalcLogic logic = new CalcLogic();
		result = logic.calc(num1,method,num2);
		
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>결과값:"+result+"</h1>");
		pw.print("</body>");
		pw.print("</html>");
		
	}

}
