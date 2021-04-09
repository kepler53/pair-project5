package happyhouse.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtil;
import happyhouse.model.DTO.MemberDTO;

public class MemberDao {
	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	//멤버추가
	
	public int insertMember(MemberDTO memberDTO) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "INSERT INTO member_tb(userid,pwd,user_name,email_id,email_domain) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getUserid());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getEmailId());
			pstmt.setString(5, memberDTO.getEmailDomain());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("회원 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return result;
		//추가됐으면 return 1, 아니면 return 0이든 -1이든
	}
	//아니면 return type을 그냥 void로 하기
	
	//멤버 삭제
	public int deleteMember(String userid) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "delete from member_tb where memebernum = (select membernum from member_tb where userid = ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("회원 삭제에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return result;
		//삭제됐으면 return 1, 아니면 return 0이든 -1이든
	}
	
	//관리자 추가
	public int insertAdmin(MemberDTO memberDTO) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "INSERT INTO member_tb(userid,pwd,user_name,email_id,email_domain, admin_type) VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getUserid());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getEmailId());
			pstmt.setString(5, memberDTO.getEmailDomain());
			pstmt.setInt(6, 1); //어떻게 집어넣어야하지???
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("회원 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return result;
		//추가됐으면 return 1, 아니면 return 0이든 -1이든
	}
	
	//멤버 정보 업데이트
	public int updateMember(MemberDTO memberDTO) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "UPDATE member_tb  SET pwd=?,user_name =?, email_id=?,email_domain =?  WHERE memebernum = (select membernum from member_tb where userid = ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getPwd());
			pstmt.setString(2, memberDTO.getName());
			pstmt.setString(3, memberDTO.getEmailId());
			pstmt.setString(4, memberDTO.getEmailDomain());
			pstmt.setNString(5, memberDTO.getUserid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("회원 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return result;
		//추가됐으면 return 1, 아니면 return 0이든 -1이든
	}
	
	


	
	
	
}
