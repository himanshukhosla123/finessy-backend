package sanuj.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO.CommonDAO;
import com.finessy.admin.DTO.PostDetailsDTO;
import com.finessy.admin.QueriesSQL.IPostDetails;

public class PostDetailsDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<PostDetailsDTO> readAll() throws ClassNotFoundException, SQLException {
		
		ArrayList<PostDetailsDTO> postDetailsList = new ArrayList<PostDetailsDTO>();
	
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(PostDetailsSQL.READ_ALL_POST_DETAILS);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				postDetailsList.add(new PostDetailsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			return postDetailsList;
		
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
	
	public PostDetailsDTO add(PostDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(PostDetailsSQL.ADD_POST_DETAILS);
			ps.setString(1, dto.getContent());
			ps.setString(2, dto.getThumbnail());
			
			
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
	
	public PostDetailsDTO read(PostDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(PostDetailsSQL.READ_POST_DETAILS);
			
			ps.setInt(1, dto.getPostId());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new PostDetailsDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
	
	public PostDetailsDTO update(PostDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(PostDetailsSQL.UPDATE_POST_DETAILS);
			
			ps.setString(1, dto.getContent());
			ps.setString(2, dto.getThumbnail());
			ps.setInt(3, dto.getPostId());
			
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
	
	public PostDetailsDTO delete(PostDetailsDTO dto) throws ClassNotFoundException, SQLException {
		
		try {
			con = CommonDAO.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(PostDetailsSQL.DELETE_POST_DETAILS);
			
			ps.setInt(1, dto.getPostId());
			
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
