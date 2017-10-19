package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.CountryDetailsDTO;
import com.finessy.admin.Interfaces.ICountryDetailsDAO;
import com.finessy.admin.QueriesSQL.CountryDetailsSQL;
import com.mysql.jdbc.Statement;

public class CountryDetailsDAOImpl implements ICountryDetailsDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<CountryDetailsDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<CountryDetailsDTO> countryList = new ArrayList<CountryDetailsDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(CountryDetailsSQL.READ_ALL_COUNTRY);
			rs = ps.executeQuery();
			while(rs.next()) {
				countryList.add(new CountryDetailsDTO(rs.getInt("country_id"), rs.getString("country_name"), rs.getInt("no_of_students"),
						rs.getInt("international_students_percent"), rs.getString("status"), rs.getString("happiness_index"),
						rs.getString("languages_spoken"), rs.getString("political_stability"), rs.getString("climate"),
						rs.getString("safety_index"), rs.getString("disaster_prone"), rs.getString("student_satisfaction_index"),
						rs.getString("ease_of_settlement"), rs.getString("ease_of_business"), rs.getInt("expense_for_international_students"),
						rs.getString("best_thing"), rs.getString("smoking_drinking_laws"), rs.getString("currency_strength"),
						rs.getString("student_friendly_cities"), rs.getString("cuisines_available"), rs.getString("peculiar_laws"),
						rs.getString("unknown_facts")));
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
	public CountryDetailsDTO add(CountryDetailsDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(CountryDetailsSQL.ADD_COUNTRY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, countryDTO.getCountryName());
			ps.setInt(2, countryDTO.getNoOfStudents());
			ps.setInt(3, countryDTO.getInternationalStudentsPercent());
			ps.setString(4, countryDTO.getStatus());
			ps.setString(5, countryDTO.getHappinessIndex());
			ps.setString(6, countryDTO.getLanguagesSpoken());
			ps.setString(7, countryDTO.getPoliticalStability());
			ps.setString(8, countryDTO.getClimate());
			ps.setString(9, countryDTO.getSafetyIndex());
			ps.setString(10, countryDTO.getDisasterProne());
			ps.setString(11, countryDTO.getStudentSatisfactionIndex());
			ps.setString(12, countryDTO.getEaseOfSettlement());
			ps.setString(13, countryDTO.getEaseOfBusiness());
			ps.setInt(14, countryDTO.getExpenseForInternationalStudents());
			ps.setString(15, countryDTO.getBestThing());
			ps.setString(16, countryDTO.getSmokingDrinkingLaws());
			ps.setString(17, countryDTO.getCurrencyStrength());
			ps.setString(18, countryDTO.getStudentFriendlyCities());
			ps.setString(19, countryDTO.getCuisinesAvailable());
			ps.setString(20, countryDTO.getPeculiarLaws());
			ps.setString(21, countryDTO.getUnknownFacts());
			if(ps.executeUpdate() > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next() && rs != null){
					   countryDTO.setCountryId(rs.getInt(1));
					   System.out.println(countryDTO.toString());
					} 
				return countryDTO;
			}
			return null;
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
	public CountryDetailsDTO read(CountryDetailsDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(CountryDetailsSQL.READ_COUNTRY);
			ps.setInt(1, countryDTO.getCountryId());
			rs = ps.executeQuery();
			rs.next();
			countryDTO = new CountryDetailsDTO(rs.getInt("country_id"), rs.getString("country_name"), rs.getInt("no_of_students"),
					rs.getInt("international_students_percent"), rs.getString("status"), rs.getString("happiness_index"),
					rs.getString("languages_spoken"), rs.getString("political_stability"), rs.getString("climate"),
					rs.getString("safety_index"), rs.getString("disaster_prone"), rs.getString("student_satisfaction_index"),
					rs.getString("ease_of_settlement"), rs.getString("ease_of_business"), rs.getInt("expense_for_international_students"),
					rs.getString("best_thing"), rs.getString("smoking_drinking_laws"), rs.getString("currency_strength"),
					rs.getString("student_friendly_cities"), rs.getString("cuisines_available"), rs.getString("peculiar_laws"),
					rs.getString("unknown_facts"));
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
	public CountryDetailsDTO update(CountryDetailsDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(CountryDetailsSQL.UPDATE_COUNTRY);
			ps.setString(1, countryDTO.getCountryName());
			ps.setInt(2, countryDTO.getNoOfStudents());
			ps.setInt(3, countryDTO.getInternationalStudentsPercent());
			ps.setString(4, countryDTO.getStatus());
			ps.setString(5, countryDTO.getHappinessIndex());
			ps.setString(6, countryDTO.getLanguagesSpoken());
			ps.setString(7, countryDTO.getPoliticalStability());
			ps.setString(8, countryDTO.getClimate());
			ps.setString(9, countryDTO.getSafetyIndex());
			ps.setString(10, countryDTO.getDisasterProne());
			ps.setString(11, countryDTO.getStudentSatisfactionIndex());
			ps.setString(12, countryDTO.getEaseOfSettlement());
			ps.setString(13, countryDTO.getEaseOfBusiness());
			ps.setInt(14, countryDTO.getExpenseForInternationalStudents());
			ps.setString(15, countryDTO.getBestThing());
			ps.setString(16, countryDTO.getSmokingDrinkingLaws());
			ps.setString(17, countryDTO.getCurrencyStrength());
			ps.setString(18, countryDTO.getStudentFriendlyCities());
			ps.setString(19, countryDTO.getCuisinesAvailable());
			ps.setString(20, countryDTO.getPeculiarLaws());
			ps.setString(21, countryDTO.getUnknownFacts());
			ps.setInt(22, countryDTO.getCountryId());
			if(ps.executeUpdate() > 0) {
				return countryDTO;
			}
			return null;
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
	public CountryDetailsDTO delete(CountryDetailsDTO countryDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(CountryDetailsSQL.DELETE_COUNTRY);
			ps.setInt(1, countryDTO.getCountryId());
			if(ps.executeUpdate() > 0) {
				return countryDTO;
			}
			return null;
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
