package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

public class MemberDAO{
	public int insert(MemberDTO mem) {
		
		Connection con = null;
		PreparedStatement ptmt = null;

		String sql = "insert into member values(?,?,?,?,?,?,?)";
		int result = 0; 
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, mem.getId());
			ptmt.setString(2, mem.getPass());
			ptmt.setString(3, mem.getName());
			ptmt.setString(4, mem.getAddr());
			ptmt.setString(5, mem.getDeptno());
			ptmt.setString(6, mem.getHiredate());
			ptmt.setInt(7, mem.getPoint());
		
			result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ���Լ���");
		} 
		 catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			DBUtil.close(null,ptmt,con); 
		}
		return result;
		
		}
	
	
	
	
	public ArrayList<MemberDTO> getDeptList() {
		ArrayList<MemberDTO> memli = new ArrayList<MemberDTO>();
		MemberDTO mem = null;
		String sql = "select * from member";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnect();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				mem = new MemberDTO(rs.getString(1), rs.getString(2)
				, rs.getString(3) , rs.getString(4) , rs.getString(5)
				, rs.getString(6), rs.getInt(7));
				memli.add(mem);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, psmt, con);
		}
		return memli;
		

	}
	
	public int delete(String id) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from member where id = ?";
		int result = 0 ; //������� ������ ����
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,id);
			result = stmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
		
	}
	
	public MemberDTO read(String id) {
		
		MemberDTO mem = null;
		
		String sql = "select * from member where id = ?";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DBUtil.getConnect();
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			int result = psmt.executeUpdate();
			System.out.println(result+"�� �� ��ȸ ����");
			rs = psmt.executeQuery(); //select���� - ����� ���ڵ� �� �� �̹Ƿ� if�� �ᵵ �ȴ�. �������� While��
			//�������� �ڹٰ�ü�� ��ȯ
			// - ���ڵ尡 ���� �� : DTO�� ���ڵ带 ��ȯ�ϰ� ArrayList�� add
			// - ���ڵ尡 �� �� : DTO�� ���ڵ� ��ȯ
			
			if(rs.next()) { //�ִ��� ������ if ����. 
				mem = new MemberDTO(rs.getString(1), rs.getString(2)
						, rs.getString(3) , rs.getString(4) , rs.getString(5)
						, rs.getString(6), rs.getInt(7));

			}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, psmt, con);
		}
		return mem;
	}
	
}