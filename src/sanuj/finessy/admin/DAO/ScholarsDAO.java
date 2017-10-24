package sanuj.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO.CommonDAO;
import com.finessy.admin.DTO.ScholarsDTO;
import com.finessy.admin.QueriesSQL.IScholars;

public class ScholarsDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<ScholarsDTO> readAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<ScholarsDTO> scholarsList = new ArrayList<ScholarsDTO>();
	
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ScholarsSQL.READ_ALL_SCHOLARS);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				scholarsList.add(new ScholarsDTO(rs.getInt(1), rs.getString(2)));
			}
			return scholarsList;
		
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
	
	public ScholarsDTO add(ScholarsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(ScholarsSQL.ADD_SCHOLARS);
			ps.setInt(1, dto.getUniversityId());
			ps.setString(2, dto.getScholars());
			
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
	
	public ScholarsDTO read(ScholarsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ScholarsSQL.READ_SCHOLARS);
			
			ps.setInt(1, dto.getUniversityId());
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new ScholarsDTO(rs.getInt(1), rs.getString(2));
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
	
	public ScholarsDTO update(ScholarsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(ScholarsSQL.UPDATE_SCHOLARS);
			
			ps.setString(1, dto.getScholars());
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
	
	public ScholarsDTO delete(ScholarsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(ScholarsSQL.DELETE_SCHOLARS);
			
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
