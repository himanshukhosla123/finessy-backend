package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.AdminInterfaceDTO;
import com.finessy.admin.Interfaces.IAdminInterfaceDAO;
import com.finessy.admin.QueriesSQL.AdminInterfaceSQL;

public class AdminInterfaceDAOImpl implements IAdminInterfaceDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<AdminInterfaceDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<AdminInterfaceDTO> userList = new ArrayList<AdminInterfaceDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AdminInterfaceSQL.READ_ALL_USER);
			rs = ps.executeQuery();
			while(rs.next()) {
				userList.add(new AdminInterfaceDTO(rs.getString("username"), rs.getString("password"), rs.getString("photo"),
						rs.getString("role")));
			}
			return userList;
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
	public AdminInterfaceDTO add(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AdminInterfaceSQL.ADD_USER);
			ps.setString(1, userDTO.getUsername());
			ps.setString(2, userDTO.getPassword());
			ps.setString(3, userDTO.getPhoto());
			ps.setString(4, userDTO.getRole());
			if(ps.executeUpdate() > 0) {
				return userDTO;
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
	public AdminInterfaceDTO read(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AdminInterfaceSQL.READ_USER);
			ps.setString(1, userDTO.getUsername());
			rs = ps.executeQuery();
			rs.next();
			userDTO = new AdminInterfaceDTO(rs.getString("username"), rs.getString("password"), rs.getString("photo"),
					rs.getString("role"));
			return userDTO;
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
	public AdminInterfaceDTO update(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AdminInterfaceSQL.UPDATE_USER);
			ps.setString(1, userDTO.getPassword());
			ps.setString(2, userDTO.getPhoto());
			ps.setString(3, userDTO.getRole());
			ps.setString(4, userDTO.getUsername());
			if(ps.executeUpdate() > 0) {
				return userDTO;
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
	public AdminInterfaceDTO delete(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AdminInterfaceSQL.DELETE_USER);
			ps.setString(1, userDTO.getUsername());
			if(ps.executeUpdate() > 0) {
				return userDTO;
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
