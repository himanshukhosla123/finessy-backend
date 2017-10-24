package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.SubfieldDetailsDTO;
import com.finessy.admin.Interfaces.ISubfieldDetailsDAO;
import com.finessy.admin.QueriesSQL.SubfieldDetailsSQL;
import com.mysql.jdbc.Statement;

public class SubfieldDetailsDAOImpl implements ISubfieldDetailsDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<SubfieldDetailsDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<SubfieldDetailsDTO> subfieldsList = new ArrayList<SubfieldDetailsDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SubfieldDetailsSQL.READ_ALL_SUBFIELD);
			rs = ps.executeQuery();
			while(rs.next()) {
				subfieldsList.add(new SubfieldDetailsDTO(rs.getInt("field_id"), rs.getString("discipline"),
						rs.getString("program"), rs.getString("jobs")));
			}
			return subfieldsList;
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
	public SubfieldDetailsDTO add(SubfieldDetailsDTO subfieldDetailsDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SubfieldDetailsSQL.ADD_SUBFIELD, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, subfieldDetailsDTO.getDiscipline());
			ps.setString(2, subfieldDetailsDTO.getProgram());
			ps.setString(3, subfieldDetailsDTO.getJobs());
			if(ps.executeUpdate() > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next() && rs != null){
				   subfieldDetailsDTO.setFieldId(rs.getInt(1));
				   System.out.println(subfieldDetailsDTO.toString());
				} 
				return subfieldDetailsDTO;
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
	public SubfieldDetailsDTO read(SubfieldDetailsDTO subfieldDetailsDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SubfieldDetailsSQL.READ_SUBFIELD);
			ps.setInt(1, subfieldDetailsDTO.getFieldId());
			rs = ps.executeQuery();
			rs.next();
			subfieldDetailsDTO = new SubfieldDetailsDTO(rs.getInt("field_id"), rs.getString("discipline"),
					rs.getString("program"), rs.getString("jobs"));
			return subfieldDetailsDTO;
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
	public SubfieldDetailsDTO update(SubfieldDetailsDTO subfieldDetailsDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SubfieldDetailsSQL.UPDATE_SUBFIELD);
			ps.setString(1, subfieldDetailsDTO.getDiscipline());
			ps.setString(2, subfieldDetailsDTO.getProgram());
			ps.setString(3, subfieldDetailsDTO.getJobs());
			ps.setInt(4, subfieldDetailsDTO.getFieldId());
			if(ps.executeUpdate() > 0) {
				return subfieldDetailsDTO;
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
	public SubfieldDetailsDTO delete(SubfieldDetailsDTO subfieldDetailsDTO)	throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SubfieldDetailsSQL.DELETE_SUBFIELD);
			ps.setInt(1, subfieldDetailsDTO.getFieldId());
			if(ps.executeUpdate() > 0) {
				return subfieldDetailsDTO;
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
