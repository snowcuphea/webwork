package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	//메소드 오버라이딩 시킬때는 선언부 무조건 동일하게
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws ServletException, IOException{
		
		System.out.println("servlet요청");
		
		
		
		
	}


}
