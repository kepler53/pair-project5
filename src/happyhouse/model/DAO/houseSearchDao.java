package happyhouse.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import happyhouse.model.DTO.MemberDTO;
import happyhouse.model.DTO.HouseDealDTO;
import happyhouse.model.DTO.HouseInfoDTO;

public class houseSearchDao {
	
	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	//매매 정보 가격 순 정렬
	public List<HouseDealDTO> insertMember(MemberDTO memberDTO) {
		ArrayList<HouseDealDTO> hlist = new ArrayList<>();
		try {
			conn = DBUtil.getConnect();
			String sql = "select ";
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("회원 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return hlist;
	}

}
