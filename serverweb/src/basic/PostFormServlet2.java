package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션 : 동작을 간단히 기호로 표현해서 컴파일러에게 알려주는 것. 
@WebServlet(name = "mypost2", urlPatterns = { "/mypost2.do" })
//이렇게 해주면 web.xml에 작성한 것과 동일하게 작동한다. 
//중복이 있으면 안된다. 
public class PostFormServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();//출력에서는Printwriter를 많이 쓴다. 빠르다
		//요청정보추출
		String id = request.getParameter("userId");
		String username = request.getParameter("userName");
		String pass = request.getParameter("passwd");
		String gender= request.getParameter("gender");
		String job = request.getParameter("job");
		String[] fav = request.getParameterValues("item");
		
		//응답내용생성
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>고객정보</h1>");
		pw.print("<h3>아이디:"+id+"</h3>");
		pw.print("<h3>성명: "+username+"</h3>");
		pw.print("<h3>Favorites</h3>");
		for(String data:fav) {
			pw.print(data+" ");
		}

		pw.print("</body>");
		pw.print("</html>");
		
	
		
		
		
	}

}
