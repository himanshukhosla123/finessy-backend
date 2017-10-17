package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.UniversityDTO;
import com.finessy.admin.Interfaces.IUniversityDAO;
import com.finessy.admin.QueriesSQL.IUniversitySQL;

public class UniversityDAOImpl implements IUniversityDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<UniversityDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<UniversityDTO> universityList = new ArrayList<UniversityDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IUniversitySQL.READ_ALL_UNIVERSITY);
			rs = ps.executeQuery();
			while(rs.next()) {
				universityList.add(new UniversityDTO(rs.getInt("university_id"), rs.getString("university_name"), rs.getString("campus_size"),
						rs.getDate("founded"), rs.getString("type"), rs.getString("map_location"), rs.getString("symbol"), rs.getString("endowment"),
						rs.getString("graduate_employbility_ranking"), rs.getInt("total_students"), rs.getInt("total_undergraduate_students"),
						rs.getInt("total_graduate_students"), rs.getString("ranking"), rs.getString("percentage_of_international_students"),
						rs.getString("student_groups"), rs.getString("safety_issues"), rs.getString("acceptance_rate"), rs.getString("contact_details")));
			}
			return universityList;
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
	public UniversityDTO add(UniversityDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IUniversitySQL.ADD_UNIVERSITY);
			ps.setInt(1, universityDTO.getUniversityId());
			ps.setString(2, universityDTO.getUniversityName());
			ps.setString(3, universityDTO.getCampusSize());
			ps.setDate(4, universityDTO.getFounded());
			ps.setString(5, universityDTO.getType());
			ps.setString(6, universityDTO.getMapLocation());
			ps.setString(7, universityDTO.getSymbol());
			ps.setString(8, universityDTO.getEndowment());
			ps.setString(9, universityDTO.getGraduateEmploybilityRanking());
			ps.setInt(10, universityDTO.getTotalStudents());
			ps.setInt(11, universityDTO.getTotalUndergraduateStudents());
			ps.setInt(12, universityDTO.getTotalGraduateStudents());
			ps.setString(13, universityDTO.getRanking());
			ps.setString(14, universityDTO.getPercentageOfInternationalStudents());
			ps.setString(15, universityDTO.getStudentGroups());
			ps.setString(16, universityDTO.getSafetyIssues());
			ps.setString(17, universityDTO.getAcceptanceRate());
			ps.setString(18, universityDTO.getContactDetails());
			if(ps.executeUpdate() > 0) {
				return universityDTO;
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
	public UniversityDTO read(UniversityDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IUniversitySQL.READ_UNIVERSITY);
			ps.setInt(1, universityDTO.getUniversityId());
			rs = ps.executeQuery();
			rs.next();
			universityDTO = new UniversityDTO(rs.getInt("university_id"), rs.getString("university_name"), rs.getString("campus_size"),
					rs.getDate("founded"), rs.getString("type"), rs.getString("map_location"), rs.getString("symbol"), rs.getString("endowment"),
					rs.getString("graduate_employbility_ranking"), rs.getInt("total_students"), rs.getInt("total_undergraduate_students"),
					rs.getInt("total_graduate_students"), rs.getString("ranking"), rs.getString("percentage_of_international_students"),
					rs.getString("student_groups"), rs.getString("safety_issues"), rs.getString("acceptance_rate"), rs.getString("contact_details"));
			return universityDTO;
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
	public UniversityDTO update(UniversityDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IUniversitySQL.UPDATE_UNIVERSITY);
			ps.setInt(1, universityDTO.getUniversityId());
			ps.setString(2, universityDTO.getUniversityName());
			ps.setString(3, universityDTO.getCampusSize());
			ps.setDate(4, universityDTO.getFounded());
			ps.setString(5, universityDTO.getType());
			ps.setString(6, universityDTO.getMapLocation());
			ps.setString(7, universityDTO.getSymbol());
			ps.setString(8, universityDTO.getEndowment());
			ps.setString(9, universityDTO.getGraduateEmploybilityRanking());
			ps.setInt(10, universityDTO.getTotalStudents());
			ps.setInt(11, universityDTO.getTotalUndergraduateStudents());
			ps.setInt(12, universityDTO.getTotalGraduateStudents());
			ps.setString(13, universityDTO.getRanking());
			ps.setString(14, universityDTO.getPercentageOfInternationalStudents());
			ps.setString(15, universityDTO.getStudentGroups());
			ps.setString(16, universityDTO.getSafetyIssues());
			ps.setString(17, universityDTO.getAcceptanceRate());
			ps.setString(18, universityDTO.getContactDetails());
			ps.setInt(19, universityDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return universityDTO;
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
	public UniversityDTO delete(UniversityDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IUniversitySQL.DELETE_UNIVERSITY);
			ps.setInt(1, universityDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return universityDTO;
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
