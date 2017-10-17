package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.StudentDTO;
import com.finessy.admin.Interfaces.IStudentDAO;
import com.finessy.admin.QueriesSQL.IStudentSQL;

public class StudentDAOImpl implements IStudentDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<StudentDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IStudentSQL.READ_ALL_STUDENT);
			rs = ps.executeQuery();
			while(rs.next()) {
				studentList.add(new StudentDTO(rs.getInt("student_id"), rs.getString("student_name"), rs.getInt("age"), 
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
	public StudentDTO add(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IStudentSQL.ADD_STUDENT);
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
	public StudentDTO read(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IStudentSQL.READ_STUDENT);
			ps.setInt(1, studentDTO.getStudentId());
			rs = ps.executeQuery();
			rs.next();
			studentDTO = new StudentDTO(rs.getInt("student_id"), rs.getString("student_name"), rs.getInt("age"), 
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
	public StudentDTO update(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IStudentSQL.UPDATE_STUDENT);
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
	public StudentDTO delete(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(IStudentSQL.DELETE_STUDENT);
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
