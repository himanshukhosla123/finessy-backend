package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.NotificationsDTO;
import com.finessy.admin.Interfaces.INotificationsDAO;
import com.finessy.admin.QueriesSQL.NotificationsSQL;

public class NotificationsDAOImpl implements INotificationsDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<NotificationsDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<NotificationsDTO> notificationList = new ArrayList<NotificationsDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(NotificationsSQL.READ_ALL_NOTIFICATION);
			rs = ps.executeQuery();
			while(rs.next()) {
				notificationList.add(new NotificationsDTO(rs.getInt("student_id"), rs.getInt("university_id"), 
						rs.getString("course_code")));
			}
			return notificationList;
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
	public NotificationsDTO add(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(NotificationsSQL.ADD_NOTIFICATION);
			ps.setInt(1, notificationDTO.getStudentId());
			ps.setInt(2, notificationDTO.getUniversityId());
			ps.setString(3, notificationDTO.getCourseCode());
			if(ps.executeUpdate() > 0) {
				return notificationDTO;
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
	public NotificationsDTO read(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(NotificationsSQL.READ_NOTIFICATION);
			ps.setInt(1, notificationDTO.getStudentId());
			ps.setInt(2, notificationDTO.getUniversityId());
			rs = ps.executeQuery();
			rs.next();
			notificationDTO = new NotificationsDTO(rs.getInt("student_id"), rs.getInt("university_id"), 
					rs.getString("course_code"));
			return notificationDTO;
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

//	NOT CORRECT
	@Override
	public NotificationsDTO update(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(NotificationsSQL.UPDATE_NOTIFICATION);
			ps.setInt(1, notificationDTO.getUniversityId());
			ps.setString(2, notificationDTO.getCourseCode());
			ps.setInt(3, notificationDTO.getStudentId());
			ps.setInt(4, notificationDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return notificationDTO;
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
	public NotificationsDTO delete(NotificationsDTO notificationDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(NotificationsSQL.DELETE_NOTIFICATION);
			ps.setInt(1, notificationDTO.getStudentId());
			ps.setInt(1, notificationDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return notificationDTO;
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
