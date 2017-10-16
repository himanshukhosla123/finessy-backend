package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.StudentDTO;
import com.finessy.admin.Interfaces.IStudentDAO;
import com.finessy.admin.Interfaces.IStudentSQL;

public class StudentDAOImpl implements IStudentDAO{

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
				studentList.add(new StudentDTO());
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
			ps.setString(3, studentDTO.getEmail());
			ps.setInt(4, studentDTO.getAge());
			ps.setString(5, studentDTO.getLookingFor());
			ps.setString(6, studentDTO.getCountry());
			ps.setString(7, studentDTO.getPlannedYearOfHigherStudies());
			ps.setString(8, studentDTO.getWorkEx());
			ps.setString(9, studentDTO.getToeflIelts());
			ps.setString(10, studentDTO.getGpa());
			ps.setString(11, studentDTO.getExamScores());
			ps.setString(12, studentDTO.getVerbalScores());
			ps.setString(13, studentDTO.getOtherDetails());
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
			studentDTO = new StudentDTO();
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
			ps.setString(3, studentDTO.getEmail());
			ps.setInt(4, studentDTO.getAge());
			ps.setString(5, studentDTO.getLookingFor());
			ps.setString(6, studentDTO.getCountry());
			ps.setString(7, studentDTO.getPlannedYearOfHigherStudies());
			ps.setString(8, studentDTO.getWorkEx());
			ps.setString(9, studentDTO.getToeflIelts());
			ps.setString(10, studentDTO.getGpa());
			ps.setString(11, studentDTO.getExamScores());
			ps.setString(12, studentDTO.getVerbalScores());
			ps.setString(13, studentDTO.getOtherDetails());
			ps.setInt(14, studentDTO.getStudentId());
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
