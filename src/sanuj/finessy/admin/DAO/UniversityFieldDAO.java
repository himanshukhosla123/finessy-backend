package sanuj.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO.CommonDAO;
import com.finessy.admin.DTO.UniversityFieldDTO;
import com.finessy.admin.QueriesSQL.IUniversityField;

public class UniversityFieldDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<UniversityFieldDTO> readAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<UniversityFieldDTO> universityfieldList = new ArrayList<UniversityFieldDTO>();
	
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UniversityFieldSQL.READ_ALL_UNIVERSITY_FIELD);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				universityfieldList.add(new UniversityFieldDTO(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
			return universityfieldList;
		
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
	
	public UniversityFieldDTO add(UniversityFieldDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(UniversityFieldSQL.ADD_UNIVERSITY_FIELD);
			ps.setInt(1, dto.getFieldId());
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
	
	public UniversityFieldDTO read(UniversityFieldDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(UniversityFieldSQL.READ_UNIVERSITY_FIELD);
			
			ps.setInt(1, dto.getFieldId());
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new UniversityFieldDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
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
	
	public UniversityFieldDTO update(UniversityFieldDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(UniversityFieldSQL.UPDATE_UNIVERSITY_FIELD);
			
			ps.setInt(1, dto.getUniversityId());
			ps.setString(2, dto.getCourseCode());
			ps.setInt(3, dto.getFieldId());
			
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
	
	public UniversityFieldDTO delete(UniversityFieldDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(UniversityFieldSQL.DELETE_UNIVERSITY_FIELD);
			
			ps.setInt(1, dto.getFieldId());
			
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
