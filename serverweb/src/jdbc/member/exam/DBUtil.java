package jdbc.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DBMS에 접근하는 중복된 작업을 정의할 클래스.
public class DBUtil {
	//1. 드라이버로딩은 클래스가 로딩될때 같이 로딩되도록 처리 
	// => static{} 안의 명령문은 클래스가 로딩될때 "한 번만" 실행되는 코드 
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		
	}
	
	//2. 커넥션하기 - DBMS와 접속 후에 접속정보를 저장하고 있는 Connection을 리턴
	//연결을 다 끝낸다음에 연결정보를 리턴해야 한다. 
	public static Connection getConnect() {
		//커넥션만 만들어주는 메소드
		//객체마다 다른 값을 받는 게 아니고, 연결하는 것이므로 static으로 설정한다. 
		Connection con = null;
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}
	
	
	//3.자원반납 - ResultSet, Statement, Connection객체 사용을 해제
	//			=> 각각의 객체를 해제할 수 있도록 메소드를 정의해도 좋다.
	//거꾸로 해제 해제
	public static void close(ResultSet rs, Statement stmt, 
			Connection con) {

		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	

}
