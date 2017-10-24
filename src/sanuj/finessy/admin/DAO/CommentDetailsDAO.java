package sanuj.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO.CommonDAO;
import com.finessy.admin.DTO.CommentDetailsDTO;
import com.finessy.admin.QueriesSQL.ICommentDetails;

public class CommentDetailsDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<CommentDetailsDTO> readAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<CommentDetailsDTO> commentdetailsList = new ArrayList<CommentDetailsDTO>();
	
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(CommentDetailsSQL.READ_ALL_COMMENT_DETAILS);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				commentdetailsList.add(new CommentDetailsDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
			return commentdetailsList;
		
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
	
	public CommentDetailsDTO add(CommentDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(CommentDetailsSQL.ADD_COMMENT_DETAILS);
			ps.setString(1, dto.getContent());
			ps.setInt(2, dto.getStudentId());
			
			
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
	
	public CommentDetailsDTO read(CommentDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(CommentDetailsSQL.READ_COMMENT_DETAILS);
			
			ps.setInt(1, dto.getCommentId());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new CommentDetailsDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
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
	
	public CommentDetailsDTO update(CommentDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(CommentDetailsSQL.UPDATE_COMMENT_DETAILS);
			
			ps.setString(1, dto.getContent());
			ps.setInt(2, dto.getCommentId());
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
	
	public CommentDetailsDTO delete(CommentDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(CommentDetailsSQL.DELETE_COMMENT_DETAILS);
			
			ps.setInt(1, dto.getCommentId());
			
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
