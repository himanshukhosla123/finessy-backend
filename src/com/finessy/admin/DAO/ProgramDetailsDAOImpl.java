package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.ProgramDetailsDTO;
import com.finessy.admin.Interfaces.IProgramDetailsDAO;
import com.finessy.admin.QueriesSQL.ProgramDetailsSQL;

public class ProgramDetailsDAOImpl implements IProgramDetailsDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<ProgramDetailsDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<ProgramDetailsDTO> programList = new ArrayList<ProgramDetailsDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ProgramDetailsSQL.READ_ALL_PROGRAM);
			rs = ps.executeQuery();
			while(rs.next()) {
				programList.add(new ProgramDetailsDTO(rs.getInt("university_id"), rs.getString("degree"), rs.getInt("field_id"), 
						rs.getInt("intake_available"), rs.getDate("program_application_deadline"), rs.getString("requirements")));
			}
			return programList;
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
	public ProgramDetailsDTO add(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ProgramDetailsSQL.ADD_PROGRAM);
			ps.setInt(1, programDTO.getUniversityId());
			ps.setString(2, programDTO.getDegree());
			ps.setInt(3, programDTO.getFieldId());
			ps.setInt(4, programDTO.getIntakeAvailable());
			ps.setDate(5, programDTO.getProgramApplicationDeadline());
			ps.setString(6, programDTO.getRequirements());
			if(ps.executeUpdate() > 0) {
				return programDTO;
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
	public ProgramDetailsDTO read(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ProgramDetailsSQL.READ_PROGRAM);
			ps.setInt(1, programDTO.getUniversityId());
			ps.setInt(2, programDTO.getFieldId());
			rs = ps.executeQuery();
			rs.next();
			programDTO = new ProgramDetailsDTO(rs.getInt("university_id"), rs.getString("degree"), rs.getInt("field_id"), 
					rs.getInt("intake_available"), rs.getDate("program_application_deadline"), rs.getString("requirements"));
			return programDTO;
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
	public ProgramDetailsDTO update(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ProgramDetailsSQL.UPDATE_PROGRAM);
			ps.setString(1, programDTO.getDegree());
			ps.setInt(2, programDTO.getIntakeAvailable());
			ps.setDate(3, programDTO.getProgramApplicationDeadline());
			ps.setString(4, programDTO.getRequirements());
			ps.setInt(5, programDTO.getUniversityId());
			ps.setInt(6, programDTO.getFieldId());
			if(ps.executeUpdate() > 0) {
				return programDTO;
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
	public ProgramDetailsDTO delete(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(ProgramDetailsSQL.DELETE_PROGRAM);
			ps.setInt(1, programDTO.getUniversityId());
			ps.setInt(2, programDTO.getFieldId());
			if(ps.executeUpdate() > 0) {
				return programDTO;
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
