package sanuj.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO.CommonDAO;
import com.finessy.admin.DTO.StudentAbroadDTO;
import com.finessy.admin.QueriesSQL.IStudentAbroad;

public class StudentAbroadDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<StudentAbroadDTO> readAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<StudentAbroadDTO> studentabroadList = new ArrayList<StudentAbroadDTO>();
	
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentAbroadSQL.READ_ALL_STUDENT_ABROAD);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				studentabroadList.add(new StudentAbroadDTO(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
			return studentabroadList;
		
		}finally {
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
	
	public StudentAbroadDTO add(StudentAbroadDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(StudentAbroadSQL.ADD_STUDENT_ABROAD);
			ps.setInt(1, dto.getStudentId());
			ps.setInt(2, dto.getUniversityId());
			ps.setString(3, dto.getCourseCode());
			
			if(ps.executeUpdate()>0) {
				con.commit();
				return dto;
			}
			else {
				con.rollback();
				return null;
			}
		
		}finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public StudentAbroadDTO read(StudentAbroadDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(StudentAbroadSQL.READ_STUDENT_ABROAD);
			
			ps.setInt(1, dto.getStudentId());
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new StudentAbroadDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
			}
			return dto;
		
		}finally {
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
	
	public StudentAbroadDTO update(StudentAbroadDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(StudentAbroadSQL.UPDATE_STUDENT_ABROAD);
			
			ps.setInt(1, dto.getUniversityId());
			ps.setString(2, dto.getCourseCode());
			ps.setInt(3, dto.getStudentId());
			
			if(ps.executeUpdate()>0) {
				con.commit();
				return dto;
			}
			else {
				con.rollback();
				return null;
			}
		
		}finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public StudentAbroadDTO delete(StudentAbroadDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(StudentAbroadSQL.DELETE_STUDENT_ABROAD);
			
			ps.setInt(1, dto.getStudentId());
			
			if(ps.executeUpdate()>0) {
				con.commit();
				return dto;
			}
			else {
				con.rollback();
				return null;
			}
		
		}finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
}
