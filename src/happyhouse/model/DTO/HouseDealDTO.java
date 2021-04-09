package happyhouse.model.DTO;

import java.sql.Date;

public class HouseDealDTO {
	
	
	public Date getDealdate() {
		return dealdate;
	}
	public void setDealdate(Date dealdate) {
		this.dealdate = dealdate;
	}
	public String getHousedealType() {
		return housedealType;
	}
	public void setHousedealType(String housedealType) {
		this.housedealType = housedealType;
	}
	public int getHousedealPrice() {
		return housedealPrice;
	}
	public void setHousedealPrice(int housedealPrice) {
		this.housedealPrice = housedealPrice;
	}
	public int getHousdealCharterprice() {
		return housdealCharterprice;
	}
	public void setHousdealCharterprice(int housdealCharterprice) {
		this.housdealCharterprice = housdealCharterprice;
	}
	public int getHousedealDeposit() {
		return housedealDeposit;
	}
	public void setHousedealDeposit(int housedealDeposit) {
		this.housedealDeposit = housedealDeposit;
	}
	public int getHousedeealRentmoney() {
		return housedeealRentmoney;
	}
	public void setHousedeealRentmoney(int housedeealRentmoney) {
		this.housedeealRentmoney = housedeealRentmoney;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	String city;
	String aptname;
	String dong;
	
	
	Date dealdate;
	String housedealType;
	int housedealPrice;
	int housdealCharterprice;
	int housedealDeposit;
	int housedeealRentmoney;
	
	
}
