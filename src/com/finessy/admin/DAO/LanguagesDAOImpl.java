package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.LanguagesDTO;
import com.finessy.admin.Interfaces.ILanguagesDAO;
import com.finessy.admin.QueriesSQL.LanguagesSQL;

public class LanguagesDAOImpl implements ILanguagesDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<LanguagesDTO> readAll() throws ClassNotFoundException, SQLException {
		ArrayList<LanguagesDTO> languageList = new ArrayList<LanguagesDTO>();
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(LanguagesSQL.READ_ALL_LANGUAGE);
			rs = ps.executeQuery();
			while(rs.next()) {
				languageList.add(new LanguagesDTO(rs.getInt("country_id"), rs.getString("languages_spoken")));
			}
			return languageList;
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
	public LanguagesDTO add(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(LanguagesSQL.ADD_LANGUAGE);
			ps.setInt(1, languagesDTO.getCountryId());
			ps.setString(2, languagesDTO.getLanguagesSpoken());
			if(ps.executeUpdate() > 0) {
				return languagesDTO;
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
	public LanguagesDTO read(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(LanguagesSQL.READ_LANGUAGE);
			ps.setInt(1, languagesDTO.getCountryId());
			rs = ps.executeQuery();
			rs.next();
			languagesDTO = new LanguagesDTO(rs.getInt("country_id"), rs.getString("languages_spoken"));
			return languagesDTO;
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
	public LanguagesDTO update(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(LanguagesSQL.UPDATE_LANGUAGE);
			ps.setInt(1, languagesDTO.getCountryId());
			ps.setString(2, languagesDTO.getLanguagesSpoken());
			if(ps.executeUpdate() > 0) {
				return languagesDTO;
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
	public LanguagesDTO delete(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException {
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(LanguagesSQL.DELETE_LANGUAGE);
			ps.setInt(1, languagesDTO.getCountryId());
			if(ps.executeUpdate() > 0) {
				return languagesDTO;
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
