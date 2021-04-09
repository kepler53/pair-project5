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

	//가격순의 경우 service에서 처리해줘야한다.
	//매매 정보 가격 순 정렬 
	public List<HouseDealDTO> searchHousedealPrice(int price, String type) {
		ArrayList<HouseDealDTO> hlist = new ArrayList<>();
		try {
			conn = DBUtil.getConnect();
			String sql = "select dealdate, housedeal_city, housedeal_dong, housedeal_aptname from housedeal_tb where housedeal_price < ? and housedeal_type =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HouseDealDTO houseDealDTO = new HouseDealDTO();
				houseDealDTO.setDealdate(rs.getDate(1));
				houseDealDTO.setCity(rs.getString(2));
				houseDealDTO.setDong(rs.getString(3));
				houseDealDTO.setHousedealType(rs.getString(4));
				
				hlist.add(houseDealDTO);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("검색 결과가 없습니니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return hlist;
	}
	
	//월세 가격 순 정렬 
	public List<HouseDealDTO> searchHousedealRentmoney(int price, String type) {
		ArrayList<HouseDealDTO> hlist = new ArrayList<>();
		try {
			conn = DBUtil.getConnect();
			String sql = "select dealdate, housedeal_city, housedeal_dong, housedeal_aptname from housedeal_tb where housedeal_rentmoney < ? and housedeal_type =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HouseDealDTO houseDealDTO = new HouseDealDTO();
				houseDealDTO.setDealdate(rs.getDate(1));
				houseDealDTO.setCity(rs.getString(2));
				houseDealDTO.setDong(rs.getString(3));
				houseDealDTO.setHousedealType(rs.getString(4));
				
				hlist.add(houseDealDTO);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("검색 결과가 없습니니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return hlist;
	}
	
	//월세 정보 보증금 순 정렬 
	public List<HouseDealDTO> searchHousedealPDeposit(int price, String type) {
		ArrayList<HouseDealDTO> hlist = new ArrayList<>();
		try {
			conn = DBUtil.getConnect();
			String sql = "select dealdate, housedeal_city, housedeal_dong, housedeal_aptname from housedeal_tb where housedeal_deposit < ? and housedeal_type =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HouseDealDTO houseDealDTO = new HouseDealDTO();
				houseDealDTO.setDealdate(rs.getDate(1));
				houseDealDTO.setCity(rs.getString(2));
				houseDealDTO.setDong(rs.getString(3));
				houseDealDTO.setHousedealType(rs.getString(4));
				
				hlist.add(houseDealDTO);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("검색 결과가 없습니니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return hlist;
	}
	
	//전세 가격 순 정렬 
	public List<HouseDealDTO> searchHousedealCharterPrice(int price, String type) {
		ArrayList<HouseDealDTO> hlist = new ArrayList<>();
		try {
			conn = DBUtil.getConnect();
			String sql = "select dealdate, housedeal_city, housedeal_dong, housedeal_aptname from housedeal_tb where housedeal_charterprice < ? and housedeal_type =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HouseDealDTO houseDealDTO = new HouseDealDTO();
				houseDealDTO.setDealdate(rs.getDate(1));
				houseDealDTO.setCity(rs.getString(2));
				houseDealDTO.setDong(rs.getString(3));
				houseDealDTO.setHousedealType(rs.getString(4));
				
				hlist.add(houseDealDTO);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("검색 결과가 없습니니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return hlist;
	}
	
	
	
	//키워드 검색
	public List<HouseDealDTO> searchHousedealContain(String keyword) {
		ArrayList<HouseDealDTO> hlist = new ArrayList<>();
		try {
			conn = DBUtil.getConnect();
			String sql = "select dealdate, housedeal_city, housedeal_dong, housedeal_aptname from housedeal_tb where housedeal_aptname = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,"%"+keyword+"%");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HouseDealDTO houseDealDTO = new HouseDealDTO();
				houseDealDTO.setDealdate(rs.getDate(1));
				houseDealDTO.setCity(rs.getString(2));
				houseDealDTO.setDong(rs.getString(3));
				houseDealDTO.setHousedealType(rs.getString(4));
				
				hlist.add(houseDealDTO);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("검색 결과가 없습니니다.");
			e.printStackTrace();
		} finally {

			DBUtil.close(rs, pstmt, conn);
		}
		return hlist;
	}
	
	

}
