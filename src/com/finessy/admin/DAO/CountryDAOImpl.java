package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.CountryDTO;
import com.finessy.admin.Interfaces.ICountryDAO;
import com.finessy.admin.QueriesSQL.ICountrySQL;

public class CountryDAOImpl implements ICountryDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<CountryDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<CountryDTO> countryList = new ArrayList<CountryDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ICountrySQL.READ_ALL_COUNTRY);
			rs = ps.executeQuery();
			while(rs.next()) {
				countryList.add(new CountryDTO());
			}
			return countryList;
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}

	@Override
	public CountryDTO add(CountryDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ICountrySQL.ADD_COUNTRY);
			ps.setInt(1, countryDTO.getCountryId());
			ps.setString(2, countryDTO.getCountryName());
			ps.setInt(3, countryDTO.getNoOfStudents());
			ps.setInt(4, countryDTO.getInternationalStudentsPercent());
			ps.setString(5, countryDTO.getStatus());
			ps.setString(6, countryDTO.getHappinessIndex());
			ps.setString(7, countryDTO.getLanguagesSpoken());
			ps.setString(8, countryDTO.getPoliticalStability());
			ps.setString(9, countryDTO.getClimate());
			ps.setString(10, countryDTO.getSafetyIndex());
			ps.setString(11, countryDTO.getDisasterProne());
			ps.setString(12, countryDTO.getStudentSatisfactionIndex());
			ps.setString(13, countryDTO.getEaseOfSettlement());
			ps.setString(14, countryDTO.getEaseOfBusiness());
			ps.setInt(15, countryDTO.getExpenseForInternationalStudents());
			ps.setString(16, countryDTO.getBestThing());
			ps.setString(17, countryDTO.getSmokingDrinkingLaws());
			ps.setString(18, countryDTO.getCurrencyStrength());
			ps.setString(19, countryDTO.getStudentFriendlyCities());
			ps.setString(20, countryDTO.getCuisinesAvailable());
			ps.setString(21, countryDTO.getPeculiarLaws());
			ps.setString(22, countryDTO.getUnknownFacts());
			if(ps.executeUpdate() > 0) {
				return countryDTO;
			}
			else {
				return null;
			}
		}
		finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}

	@Override
	public CountryDTO read(CountryDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ICountrySQL.READ_COUNTRY);
			ps.setInt(1, countryDTO.getCountryId());
			rs = ps.executeQuery();
			rs.next();
			countryDTO = new CountryDTO();
			return countryDTO;
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}

	@Override
	public CountryDTO update(CountryDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ICountrySQL.UPDATE_COUNTRY);
			ps.setInt(1, countryDTO.getCountryId());
			ps.setString(2, countryDTO.getCountryName());
			ps.setInt(3, countryDTO.getNoOfStudents());
			ps.setInt(4, countryDTO.getInternationalStudentsPercent());
			ps.setString(5, countryDTO.getStatus());
			ps.setString(6, countryDTO.getHappinessIndex());
			ps.setString(7, countryDTO.getLanguagesSpoken());
			ps.setString(8, countryDTO.getPoliticalStability());
			ps.setString(9, countryDTO.getClimate());
			ps.setString(10, countryDTO.getSafetyIndex());
			ps.setString(11, countryDTO.getDisasterProne());
			ps.setString(12, countryDTO.getStudentSatisfactionIndex());
			ps.setString(13, countryDTO.getEaseOfSettlement());
			ps.setString(14, countryDTO.getEaseOfBusiness());
			ps.setInt(15, countryDTO.getExpenseForInternationalStudents());
			ps.setString(16, countryDTO.getBestThing());
			ps.setString(17, countryDTO.getSmokingDrinkingLaws());
			ps.setString(18, countryDTO.getCurrencyStrength());
			ps.setString(19, countryDTO.getStudentFriendlyCities());
			ps.setString(20, countryDTO.getCuisinesAvailable());
			ps.setString(21, countryDTO.getPeculiarLaws());
			ps.setString(22, countryDTO.getUnknownFacts());
			ps.setInt(23, countryDTO.getCountryId());
			if(ps.executeUpdate() > 0) {
				return countryDTO;
			}
			else {
				return null;
			}
		}
		finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}

	@Override
	public CountryDTO delete(CountryDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ICountrySQL.DELETE_COUNTRY);
			ps.setInt(1, countryDTO.getCountryId());
			if(ps.executeUpdate() > 0) {
				return countryDTO;
			}
			else {
				return null;
			}
		}
		finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}

}
