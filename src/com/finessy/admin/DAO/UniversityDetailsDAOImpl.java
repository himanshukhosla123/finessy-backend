package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.UniversityDetailsDTO;
import com.finessy.admin.Interfaces.IUniversityDetailsDAO;
import com.finessy.admin.QueriesSQL.UniversityDetailsSQL;

public class UniversityDetailsDAOImpl implements IUniversityDetailsDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<UniversityDetailsDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<UniversityDetailsDTO> universityList = new ArrayList<UniversityDetailsDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UniversityDetailsSQL.READ_ALL_UNIVERSITY);
			rs = ps.executeQuery();
			while(rs.next()) {
				universityList.add(new UniversityDetailsDTO(rs.getString("university_name"), rs.getString("campus_size"),
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
	public UniversityDetailsDTO add(UniversityDetailsDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UniversityDetailsSQL.ADD_UNIVERSITY);
			ps.setString(1, universityDTO.getUniversityName());
			ps.setString(2, universityDTO.getCampusSize());
			ps.setDate(3, universityDTO.getFounded());
			ps.setString(4, universityDTO.getType());
			ps.setString(5, universityDTO.getMapLocation());
			ps.setString(6, universityDTO.getSymbol());
			ps.setString(7, universityDTO.getEndowment());
			ps.setString(8, universityDTO.getGraduateEmploybilityRanking());
			ps.setInt(9, universityDTO.getTotalStudents());
			ps.setInt(10, universityDTO.getTotalUndergraduateStudents());
			ps.setInt(11, universityDTO.getTotalGraduateStudents());
			ps.setString(12, universityDTO.getRanking());
			ps.setString(13, universityDTO.getPercentageOfInternationalStudents());
			ps.setString(14, universityDTO.getStudentGroups());
			ps.setString(15, universityDTO.getSafetyIssues());
			ps.setString(16, universityDTO.getAcceptanceRate());
			ps.setString(17, universityDTO.getContactDetails());
			if(ps.executeUpdate() > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next() && rs != null){
					universityDTO.setUniversityId(rs.getInt(1));
					   System.out.println(universityDTO.toString());
					} 
				return universityDTO;
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
	public UniversityDetailsDTO read(UniversityDetailsDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UniversityDetailsSQL.READ_UNIVERSITY);
			ps.setInt(1, universityDTO.getUniversityId());
			rs = ps.executeQuery();
			rs.next();
			universityDTO = new UniversityDetailsDTO(rs.getInt("university_id"), rs.getString("university_name"), rs.getString("campus_size"),
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
	public UniversityDetailsDTO update(UniversityDetailsDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UniversityDetailsSQL.UPDATE_UNIVERSITY);
			ps.setString(1, universityDTO.getUniversityName());
			ps.setString(2, universityDTO.getCampusSize());
			ps.setDate(3, universityDTO.getFounded());
			ps.setString(4, universityDTO.getType());
			ps.setString(5, universityDTO.getMapLocation());
			ps.setString(6, universityDTO.getSymbol());
			ps.setString(7, universityDTO.getEndowment());
			ps.setString(8, universityDTO.getGraduateEmploybilityRanking());
			ps.setInt(9, universityDTO.getTotalStudents());
			ps.setInt(10, universityDTO.getTotalUndergraduateStudents());
			ps.setInt(11, universityDTO.getTotalGraduateStudents());
			ps.setString(12, universityDTO.getRanking());
			ps.setString(13, universityDTO.getPercentageOfInternationalStudents());
			ps.setString(14, universityDTO.getStudentGroups());
			ps.setString(15, universityDTO.getSafetyIssues());
			ps.setString(16, universityDTO.getAcceptanceRate());
			ps.setString(17, universityDTO.getContactDetails());
			ps.setInt(18, universityDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return universityDTO;
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
	public UniversityDetailsDTO delete(UniversityDetailsDTO universityDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UniversityDetailsSQL.DELETE_UNIVERSITY);
			ps.setInt(1, universityDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return universityDTO;
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
