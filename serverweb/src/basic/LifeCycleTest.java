package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTest extends HttpServlet {
	
	public LifeCycleTest() {
		System.out.println("서블릿객체생성..");
	}
	public void init() {
		System.out.println("서블릿객체의 초기화 init()...");
	}
	public void service(HttpServletRequest req,
				HttpServletResponse res)
	throws ServletException, IOException{
		System.out.println("클라이언트의 요청처리 service()...^^"
				+req.getMethod());
		//요청방식이 GET이면 doGet호출, POST면 doPost호출
		if(req.getMethod().equals("GET")) {
			doGet(req,res);
		}else {
			doPost(req, res);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()..");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()..");
		
	}
	public void destroy() {
		
		System.out.println("서블릿객체소멸..destroy()..");
	}
	

}
