package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.AlumniDTO;
import com.finessy.admin.Interfaces.IAlumniDAO;
import com.finessy.admin.QueriesSQL.AlumniSQL;

public class AlumniDAOImpl implements IAlumniDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<AlumniDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<AlumniDTO> alumniList = new ArrayList<AlumniDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AlumniSQL.READ_ALL_ALUMNI);
			rs = ps.executeQuery();
			while(rs.next()) {
				alumniList.add(new AlumniDTO(rs.getInt("university_id"), rs.getString("famous_alumni"), rs.getString("image")));
			}
			return alumniList;
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
	public AlumniDTO add(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AlumniSQL.ADD_ALUMNI);
			ps.setInt(1, alumniDTO.getUniversityId());
			ps.setString(2, alumniDTO.getFamousAlumni());
			ps.setString(3, alumniDTO.getImage());
			if(ps.executeUpdate() > 0) {
				return alumniDTO;
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
	public AlumniDTO read(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AlumniSQL.READ_ALUMNI);
			ps.setInt(1, alumniDTO.getUniversityId());
			rs = ps.executeQuery();
			rs.next();
			alumniDTO = new AlumniDTO(rs.getInt("university_id"), rs.getString("famous_alumni"), rs.getString("image"));
			return alumniDTO;
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
	public AlumniDTO update(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AlumniSQL.UPDATE_ALUMNI);
			ps.setString(1, alumniDTO.getFamousAlumni());
			ps.setString(2, alumniDTO.getImage());
			ps.setInt(3, alumniDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return alumniDTO;
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
	public AlumniDTO delete(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(AlumniSQL.DELETE_ALUMNI);
			ps.setInt(1, alumniDTO.getUniversityId());
			if(ps.executeUpdate() > 0) {
				return alumniDTO;
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
