package sanuj.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO.CommonDAO;
import com.finessy.admin.DTO.FamousProgramsDTO;
import com.finessy.admin.QueriesSQL.IFamousPrograms;

public class FamousProgramsDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<FamousProgramsDTO> readAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<FamousProgramsDTO> famousprogramsList = new ArrayList<FamousProgramsDTO>();
	
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(FamousProgramsSQL.READ_ALL_FAMOUS_PROGRAMS);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				famousprogramsList.add(new FamousProgramsDTO(rs.getInt(1), rs.getString(2)));
			}
			return famousprogramsList;
		
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
	
	public FamousProgramsDTO add(FamousProgramsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(FamousProgramsSQL.ADD_FAMOUS_PROGRAMS);
			ps.setInt(1, dto.getUniversityId());
			ps.setString(2, dto.getFamousPrograms());
			
			
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
	
	public FamousProgramsDTO read(FamousProgramsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(FamousProgramsSQL.READ_FAMOUS_PROGRAMS);
			
			ps.setInt(1, dto.getUniversityId());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new FamousProgramsDTO(rs.getInt(1), rs.getString(2));
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
	
	public FamousProgramsDTO update(FamousProgramsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(FamousProgramsSQL.UPDATE_FAMOUS_PROGRAMS);
			
			ps.setString(1, dto.getFamousPrograms());
			ps.setInt(2, dto.getUniversityId());

			
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
	
	public FamousProgramsDTO delete(FamousProgramsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(FamousProgramsSQL.DELETE_FAMOUS_PROGRAMS);
			
			ps.setInt(1, dto.getUniversityId());
			
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
