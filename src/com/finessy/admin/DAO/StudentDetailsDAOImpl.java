package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.StudentDetailsDTO;
import com.finessy.admin.Interfaces.IStudentDetailsDAO;
import com.finessy.admin.QueriesSQL.StudentDetailsSQL;

public class StudentDetailsDAOImpl implements IStudentDetailsDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<StudentDetailsDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<StudentDetailsDTO> studentList = new ArrayList<StudentDetailsDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentDetailsSQL.READ_ALL_STUDENT);
			rs = ps.executeQuery();
			while(rs.next()) {
				studentList.add(new StudentDetailsDTO(rs.getInt("student_id"), rs.getString("student_name"), rs.getInt("age"), 
						rs.getString("looking_for"), rs.getString("country"), rs.getString("planned_year_of_higher_study"),
						rs.getString("work_ex"), rs.getString("toefl/ielts"), rs.getString("gpa"), rs.getString("exam_scores"),
						rs.getString("verbal_scores"), rs.getString("other_details")));
				
			}
			return studentList;
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
	public StudentDetailsDTO add(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentDetailsSQL.ADD_STUDENT);
			ps.setInt(1, studentDTO.getStudentId());
			ps.setString(2, studentDTO.getStudentName());
			ps.setInt(3, studentDTO.getAge());
			ps.setString(4, studentDTO.getLookingFor());
			ps.setString(5, studentDTO.getCountry());
			ps.setString(6, studentDTO.getPlannedYearOfHigherStudies());
			ps.setString(7, studentDTO.getWorkEx());
			ps.setString(8, studentDTO.getToeflIelts());
			ps.setString(9, studentDTO.getGpa());
			ps.setString(10, studentDTO.getExamScores());
			ps.setString(11, studentDTO.getVerbalScores());
			ps.setString(12, studentDTO.getOtherDetails());
			if(ps.executeUpdate() > 0) {
				return studentDTO;
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
	public StudentDetailsDTO read(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentDetailsSQL.READ_STUDENT);
			ps.setInt(1, studentDTO.getStudentId());
			rs = ps.executeQuery();
			rs.next();
			studentDTO = new StudentDetailsDTO(rs.getInt("student_id"), rs.getString("student_name"), rs.getInt("age"), 
					rs.getString("looking_for"), rs.getString("country"), rs.getString("planned_year_of_higher_study"),
					rs.getString("work_ex"), rs.getString("toefl/ielts"), rs.getString("gpa"), rs.getString("exam_scores"),
					rs.getString("verbal_scores"), rs.getString("other_details"));
			return studentDTO;
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
	public StudentDetailsDTO update(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentDetailsSQL.UPDATE_STUDENT);
			ps.setInt(1, studentDTO.getStudentId());
			ps.setString(2, studentDTO.getStudentName());
			ps.setInt(3, studentDTO.getAge());
			ps.setString(4, studentDTO.getLookingFor());
			ps.setString(5, studentDTO.getCountry());
			ps.setString(6, studentDTO.getPlannedYearOfHigherStudies());
			ps.setString(7, studentDTO.getWorkEx());
			ps.setString(8, studentDTO.getToeflIelts());
			ps.setString(9, studentDTO.getGpa());
			ps.setString(10, studentDTO.getExamScores());
			ps.setString(11, studentDTO.getVerbalScores());
			ps.setString(12, studentDTO.getOtherDetails());
			ps.setInt(13, studentDTO.getStudentId());
			if(ps.executeUpdate() > 0) {
				return studentDTO;
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
	public StudentDetailsDTO delete(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentDetailsSQL.DELETE_STUDENT);
			ps.setInt(1, studentDTO.getStudentId());
			if(ps.executeUpdate() > 0) {
				return studentDTO;
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
