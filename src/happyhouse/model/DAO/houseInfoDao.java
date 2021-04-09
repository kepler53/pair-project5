package happyhouse.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtil;
import happyhouse.model.DTO.HouseInfoDTO;

public class houseInfoDao {

	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//집 정보 등록
	public int insertHouseInfo(HouseInfoDTO houseInfoDTO) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "";

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("집 정보 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return result;
		//추가됐으면 return 1, 아니면 return 0이든 -1이든
	}

	//집 정보 삭제
	public int deleteHouseInfo(int houseInfonum) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "delete from houseinfo_tb where houseinfonum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, houseInfonum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("집 정보 삭제에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return result;
		//삭제됐으면 return 1, 아니면 return 0이든 -1이든
	}
	
	//집 정보 업데이트
	public int updateHouseInfoDTO(HouseInfoDTO houseInfoDTO) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "UPDATE houseinfo_tb  SET city =?, dongcode=?,gugun =?, lat=?,lang =?  WHERE houseinfonum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, houseInfoDTO.getCity());
			pstmt.setInt(2,houseInfoDTO.getDongcode());
			pstmt.setString(3, houseInfoDTO.getGugun());
			pstmt.setFloat(4, houseInfoDTO.getLat());
			pstmt.setFloat(5, houseInfoDTO.getLang());
			pstmt.setInt(6, houseInfoDTO.getNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("집 정보 수정에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return result;
		//수정됐으면 return 1, 아니면 return 0이든 -1이든
	}
	
	
}
