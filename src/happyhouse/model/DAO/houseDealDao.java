package happyhouse.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.DBUtil;
import happyhouse.model.DTO.HouseDealDTO;
import happyhouse.model.DTO.HouseInfoDTO;
import happyhouse.model.DTO.MemberDTO;

public class houseDealDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	
	//관리자가 등록하는 매물 정보 등록
	public int insertHouseDeal(int memebernum, int houseinfonum, HouseDealDTO houseDealDTO) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "INSERT INTO housedeal_tb(dealdate,hmembernum,hhouseinfonum,housedeal_type,housedeal_price,housedeal_charterprice,housedeal_deposit,housedeal_rentmoney,housedeal_city,housedeal_dong,housedeal_name)"
					+ " VALUES(now(),?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memebernum);
			pstmt.setInt(2, houseinfonum);
			pstmt.setString(3, houseDealDTO.getHousedealType());
			pstmt.setInt(4, houseDealDTO.getHousedealPrice());
			pstmt.setInt(5, houseDealDTO.getHousdealCharterprice());
			pstmt.setInt(6, houseDealDTO.getHousedealDeposit());
			pstmt.setInt(7, houseDealDTO.getHousedeealRentmoney());
			pstmt.setString(8, houseDealDTO.getCity());
			pstmt.setString(9, houseDealDTO.getDong());
			pstmt.setString(10, houseDealDTO.getAptname());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("집 매물 추가에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(pstmt, conn);
		}
		return result;
		//추가됐으면 return 1, 아니면 return 0
	}
	
	
	//관리자가 등록하는 매물 정보 수정
	public int updateHouseDeal(int memebernum, int houseinfonum, HouseDealDTO houseDealDTO) {
		int result = 0;
		try {
			
			conn = DBUtil.getConnect();
			String sql = "update houesdeal_tb set dealdate = now(),housedeal_type = ?,housedeal_price =?, housedeal_charterprice =?, housedeal_deposit =?, housedeal_rentmoney =? housedeal_city =?, housedeal_dong =? ,housedeal_aptname =? where hmemebernum =? and hhouseinfonum =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, houseDealDTO.getHousedealType());
			pstmt.setInt(2, houseDealDTO.getHousedealPrice());
			pstmt.setInt(3, houseDealDTO.getHousdealCharterprice());
			pstmt.setInt(4, houseDealDTO.getHousedealDeposit());
			pstmt.setInt(5, houseDealDTO.getHousedeealRentmoney());
			pstmt.setString(6, houseDealDTO.getCity());
			pstmt.setString(7, houseDealDTO.getDong());
			pstmt.setString(8, houseDealDTO.getAptname());
			pstmt.setInt(9, memebernum);
			pstmt.setInt(10, houseinfonum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("집 매물 수정에 실패했습니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(pstmt, conn);
		}
		return result;
		//수정됐으면 return 1, 아니면 return 0
	}
	
	//관리자가 등록하는 매물 정보 삭제
	public int deleeHouseDeal(int housedealnum, int membernum) {
		int result = 0;
		try {
			conn = DBUtil.getConnect();
			String sql = "delete from housedeal_tb where hhousedealnum = ? and hmembernum = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, membernum);
			pstmt.setInt(1, housedealnum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("집 매물 삭제에 실패했습니다.");
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
		//삭제됐으면 return 1, 아니면 return 0
	}
	
	

}
