package sanuj.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO.CommonDAO;
import com.finessy.admin.DTO.BestMarketDTO;
import com.finessy.admin.QueriesSQL.IBestMarket;

public class BestMarketDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<BestMarketDTO> readAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<BestMarketDTO> bestmarketList = new ArrayList<BestMarketDTO>();
	
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(BestMarketSQL.READ_ALL_BEST_MARKET);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				bestmarketList.add(new BestMarketDTO(rs.getInt(1), rs.getInt(2)));
			}
			return bestmarketList;
		
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
	
	public BestMarketDTO add(BestMarketDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(BestMarketSQL.ADD_BEST_MARKET);
			ps.setInt(1, dto.getFieldId());
			ps.setInt(2, dto.getCountryId());
			
			
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
	
	public BestMarketDTO read(BestMarketDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(BestMarketSQL.READ_BEST_MARKET);
			
			ps.setInt(1, dto.getFieldId());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new BestMarketDTO(rs.getInt(1), rs.getInt(2));
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
	
	public BestMarketDTO update(BestMarketDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(BestMarketSQL.UPDATE_BEST_MARKET);
			
			ps.setInt(1, dto.getCountryId());
			ps.setInt(2, dto.getFieldId());

			
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
	
	public BestMarketDTO delete(BestMarketDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(BestMarketSQL.DELETE_BEST_MARKET);
			
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
