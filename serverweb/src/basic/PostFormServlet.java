package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException{
			
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("userId");
		String username = req.getParameter("userName");
		String pass = req.getParameter("passwd");
		String gender= req.getParameter("gender");
		String job = req.getParameter("job");
		String fav[] = req.getParameterValues("item");
		
		System.out.println("아이디:"+id);
		System.out.println("이름:"+username);
		System.out.println("비밀번호:"+pass);
		System.out.println("성별:"+gender);
		System.out.println("직업:"+job);
		System.out.print("관심분야: ");
		for(int i=0;i<fav.length;i++) {
			System.out.print(fav[i]+"\t");
		}
}
}
