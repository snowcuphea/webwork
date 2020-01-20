package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import jdbc.member.exam.MemberDTO;




public class DeptDAO{
	
	public ArrayList<DeptDTO> getDeptList() {
		ArrayList<DeptDTO> deptli = new ArrayList<DeptDTO>();
		DeptDTO dept = null;
		String sql = "select * from mydept";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnect();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dept = new DeptDTO(rs.getString(1), rs.getString(2)
				, rs.getString(3) , rs.getString(4) , rs.getString(5));
				deptli.add(dept);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, psmt, con);
		}
		return deptli;
		

	}
	public int insert(DeptDTO dept) {
		
	Connection con = null;
	PreparedStatement ptmt = null;

	String sql = "insert into mydept values(?,?,?,?,?)";
	int result = 0; 
	try {
		con = DBUtil.getConnect();
		ptmt = con.prepareStatement(sql);
		ptmt.setString(1, dept.getDeptNo());
		ptmt.setString(2, dept.getDeptName());
		ptmt.setString(3, dept.getLoc());
		ptmt.setString(4, dept.getTel());
		ptmt.setString(5, dept.getMgr());
		result = ptmt.executeUpdate();
		System.out.println(result + "개 행 삽입성공");
	} 
	 catch (SQLException e) {
		e.printStackTrace();
		System.out.println("연결 실패 : " + e.getMessage());
	} finally {
		DBUtil.close(null,ptmt,con); 
	}
	return result;
	
	}
	public int delete(String deptno) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "select * from mydept where deptNo = ?";
		int result = 0 ; //결과값을 저장할 변수
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,deptno);
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
		
	}
	
	public DeptDTO read(String deptNo) {
		
		DeptDTO dede = null;
		
		String sql = "select * from mydept where deptNo = ?";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DBUtil.getConnect();
			psmt = con.prepareStatement(sql);
			psmt.setString(1,deptNo);
			int result = psmt.executeUpdate();
			System.out.println(result+"개 행 조회 성공");
			rs = psmt.executeQuery(); //select실행 - 결과가 레코드 한 개 이므로 if문 써도 된다. 여러개면 While문
			//실행결과를 자바객체로 변환
			// - 레코드가 여러 개 : DTO로 레코드를 변환하고 ArrayList에 add
			// - 레코드가 한 개 : DTO로 레코드 변환
			
			if(rs.next()) { //있는지 없는지 if 쓴다. 
				dede = new DeptDTO(rs.getString(1), rs.getString(2)
				, rs.getString(3) , rs.getString(4) , rs.getString(5));
				
			}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, psmt, con);
		}
		return dede;
	}
	
}
