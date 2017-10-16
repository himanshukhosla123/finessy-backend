package com.finessy.admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.CommonDAO;
import com.finessy.admin.DTO.StudentDTO;
import com.finessy.admin.Interfaces.IStudentDAO;

public class StudentDAOImpl implements IStudentDAO{

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<StudentDTO> readAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();
		try {
			con = CommonDAO.getConnection();
//			ps = con.prepareStatement(IFee.READ_ALL_FEE);
			rs = ps.executeQuery();
			while(rs.next()) {
				studentList.add(new StudentDTO());
			}
			return studentList;
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
	public StudentDTO add(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			con = CommonDAO.getConnection();
//			ps = con.prepareStatement(IFee.CREATE_FEE);
//			ps.setString(1, "101");
//			ps.setString(2, studentDTO.getSID());
//			ps.setString(3, studentDTO.getBID());
//			ps.setString(4, "101");
//			ps.setDouble(5, studentDTO.getCourseAmount());
//			ps.setDouble(6, 101);
//			ps.setString(7, studentDTO.getPaymentMode());
//			ps.setString(8, "101");
//			ps.setDate(9, new java.sql.Date(CustomDateFormat.getDate(studentDTO.getPaymentDate()).getTime()));
//			ps.setDate(10, new java.sql.Date(CustomDateFormat.getDate(studentDTO.getInstallmentDate()).getTime()));
//			ps.setDouble(11, studentDTO.getPayment());
//			ps.setDouble(12, studentDTO.getBalance());
//			ps.setString(13, "101");
			if(ps.executeUpdate() > 0) {
				return studentDTO;
			}
			else {
				return null;
			}
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
	public StudentDTO read(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			con = CommonDAO.getConnection();
//			ps = con.prepareStatement(IFee.READ_FEE);
			ps.setString(1, "101");
			rs = ps.executeQuery();
			rs.next();
			studentDTO = new StudentDTO();
			return studentDTO;
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
	public StudentDTO update(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			con = CommonDAO.getConnection();
//			ps = con.prepareStatement(IFee.UPDATE_FEE);
//			ps.setString(1, studentDTO.getTID());
//			ps.setString(2, studentDTO.getSID());
//			ps.setString(3, studentDTO.getBID());
//			ps.setString(4, studentDTO.getCID());
//			ps.setDouble(5, studentDTO.getCourseAmount());
//			ps.setDouble(6, studentDTO.getPayableAmount());
//			ps.setString(7, studentDTO.getPaymentMode());
//			ps.setString(8, studentDTO.getChequeId());
//			ps.setDate(9, new java.sql.Date(CustomDateFormat.getDate(studentDTO.getPaymentDate()).getTime()));
//			ps.setDate(10, new java.sql.Date(CustomDateFormat.getDate(studentDTO.getInstallmentDate()).getTime()));
//			ps.setDouble(11, studentDTO.getPayment());
//			ps.setDouble(12, studentDTO.getBalance());
//			ps.setString(13, studentDTO.getStatus());
//			ps.setString(14, studentDTO.getTID());
			if(ps.executeUpdate() > 0) {
				return studentDTO;
			}
			else {
				return null;
			}
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
	public StudentDTO delete(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			con = CommonDAO.getConnection();
//			ps = con.prepareStatement(IFee.DELETE_FEE);
//			ps.setString(1, studentDTO.getTID());
			if(ps.executeUpdate() > 0) {
				return studentDTO;
			}
			else {
				return null;
			}
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
