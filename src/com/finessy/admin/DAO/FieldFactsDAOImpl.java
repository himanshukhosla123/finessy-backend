package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.FieldFactsDTO;
import com.finessy.admin.Interfaces.IFieldFactsDAO;
import com.finessy.admin.QueriesSQL.FieldFactsSQL;

public class FieldFactsDAOImpl implements IFieldFactsDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<FieldFactsDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<FieldFactsDTO> fieldFactsList = new ArrayList<FieldFactsDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(FieldFactsSQL.READ_ALL_FIELD_FACTS);
			rs = ps.executeQuery();
			while(rs.next()) {
				fieldFactsList.add(new FieldFactsDTO(rs.getInt("field_id"), rs.getString("best_market"),
						rs.getInt("salary_after"), rs.getString("scope_in_each_country"),
						rs.getString("types_of_jobs"), rs.getInt("their_salaries"),
						rs.getInt("number_of_students"), rs.getInt("number_of_students_interested"),
						rs.getString("current_trends"), rs.getString("value_of_degree_to_work"),
						rs.getString("to_get_hired")));
			}
			return fieldFactsList;
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
	public FieldFactsDTO add(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(FieldFactsSQL.ADD_FIELD_FACTS);
			ps.setInt(1, fieldFactsDTO.getFieldId());
			ps.setString(2, fieldFactsDTO.getBestMarket());
			ps.setInt(3, fieldFactsDTO.getSalaryAfter());
			ps.setString(4, fieldFactsDTO.getScopeInEachCountry());
			ps.setString(5, fieldFactsDTO.getTypesOfJobs());
			ps.setInt(6, fieldFactsDTO.getTheirSalaries());
			ps.setInt(7, fieldFactsDTO.getNumberOfStudents());
			ps.setInt(8, fieldFactsDTO.getNumberOfStudentsInterested());
			ps.setString(9, fieldFactsDTO.getCurrentTrends());
			ps.setString(10, fieldFactsDTO.getValueOfDegreeToWork());
			ps.setString(11, fieldFactsDTO.getToGetHired());
			if(ps.executeUpdate() > 0) {
				return fieldFactsDTO;
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
	public FieldFactsDTO read(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(FieldFactsSQL.READ_FIELD_FACTS);
			ps.setInt(1, fieldFactsDTO.getFieldId());
			rs = ps.executeQuery();
			rs.next();
			fieldFactsDTO = new FieldFactsDTO(rs.getInt("field_id"), rs.getString("best_market"),
					rs.getInt("salary_after"), rs.getString("scope_in_each_country"),
					rs.getString("types_of_jobs"), rs.getInt("their_salaries"),
					rs.getInt("number_of_students"), rs.getInt("number_of_students_interested"),
					rs.getString("current_trends"), rs.getString("value_of_degree_to_work"),
					rs.getString("to_get_hired"));
			return fieldFactsDTO;
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
	public FieldFactsDTO update(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(FieldFactsSQL.UPDATE_FIELD_FACTS);
			ps.setString(1, fieldFactsDTO.getBestMarket());
			ps.setInt(2, fieldFactsDTO.getSalaryAfter());
			ps.setString(3, fieldFactsDTO.getScopeInEachCountry());
			ps.setString(4, fieldFactsDTO.getTypesOfJobs());
			ps.setInt(5, fieldFactsDTO.getTheirSalaries());
			ps.setInt(6, fieldFactsDTO.getNumberOfStudents());
			ps.setInt(7, fieldFactsDTO.getNumberOfStudentsInterested());
			ps.setString(8, fieldFactsDTO.getCurrentTrends());
			ps.setString(9, fieldFactsDTO.getValueOfDegreeToWork());
			ps.setString(10, fieldFactsDTO.getToGetHired());
			ps.setInt(11, fieldFactsDTO.getFieldId());
			if(ps.executeUpdate() > 0) {
				return fieldFactsDTO;
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
	public FieldFactsDTO delete(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(FieldFactsSQL.DELETE_FIELD_FACTS);
			ps.setInt(1, fieldFactsDTO.getFieldId());
			if(ps.executeUpdate() > 0) {
				return fieldFactsDTO;
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
