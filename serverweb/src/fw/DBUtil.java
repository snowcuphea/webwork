package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DBMS�� �����ϴ� �ߺ��� �۾��� ������ Ŭ����.
public class DBUtil {
	//1. ����̹��ε��� Ŭ������ �ε��ɶ� ���� �ε��ǵ��� ó�� 
	// => static{} ���� ���ɹ��� Ŭ������ �ε��ɶ� "�� ����" ����Ǵ� �ڵ� 
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		
		
	}
	
	//2. Ŀ�ؼ��ϱ� - DBMS�� ���� �Ŀ� ���������� �����ϰ� �ִ� Connection�� ����
	//������ �� ���������� ���������� �����ؾ� �Ѵ�. 
	public static Connection getConnect() {
		//Ŀ�ؼǸ� ������ִ� �޼ҵ�
		//��ü���� �ٸ� ���� �޴� �� �ƴϰ�, �����ϴ� ���̹Ƿ� static���� �����Ѵ�. 
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}
	
	
	//3.�ڿ��ݳ� - ResultSet, Statement, Connection��ü ����� ����
	//			=> ������ ��ü�� ������ �� �ֵ��� �޼ҵ带 �����ص� ����.
	//�Ųٷ� ���� ����
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