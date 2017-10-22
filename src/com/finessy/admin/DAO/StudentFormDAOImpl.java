package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.StudentFormDTO;
import com.finessy.admin.Interfaces.IStudentFormDAO;
import com.finessy.admin.QueriesSQL.StudentFormSQL;
import com.mysql.jdbc.Statement;

public class StudentFormDAOImpl implements IStudentFormDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<StudentFormDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<StudentFormDTO> studentList = new ArrayList<StudentFormDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentFormSQL.READ_ALL_STUDENT_FORM);
			rs = ps.executeQuery();
			while(rs.next()) {
				studentList.add(new StudentFormDTO(rs.getInt("student_id"), rs.getString("password"), rs.getString("email")));
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
	public StudentFormDTO add(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentFormSQL.ADD_STUDENT_FORM, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, studentDTO.getPassword());
			ps.setString(2, studentDTO.getEmail());
			if(ps.executeUpdate() > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next() && rs != null){
				   studentDTO.setStudentId(rs.getInt(1));
				   System.out.println(studentDTO.toString());
				} 
				return studentDTO;
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
	public StudentFormDTO read(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentFormSQL.READ_STUDENT_FORM);
			ps.setInt(1, studentDTO.getStudentId());
			rs = ps.executeQuery();
			rs.next();
			studentDTO = new StudentFormDTO(rs.getInt("student_id"), rs.getString("password"), rs.getString("email"));
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
	public StudentFormDTO update(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentFormSQL.UPDATE_STUDENT_FORM);
			ps.setString(1, studentDTO.getPassword());
			ps.setString(2, studentDTO.getEmail());
			ps.setInt(3, studentDTO.getStudentId());
			if(ps.executeUpdate() > 0) {
				return studentDTO;
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
	public StudentFormDTO delete(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentFormSQL.DELETE_STUDENT_FORM);
			ps.setInt(1, studentDTO.getStudentId());
			if(ps.executeUpdate() > 0) {
				return studentDTO;
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
