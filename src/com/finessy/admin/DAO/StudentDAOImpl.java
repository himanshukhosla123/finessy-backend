package com.finessy.admin.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.StudentDTO;
import com.finessy.admin.Interfaces.IStudentDAO;

public class StudentDAOImpl implements IStudentDAO{

	@Override
	public ArrayList<StudentDTO> readAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<StudentDTO> x=new ArrayList<StudentDTO>();
		x.add(new StudentDTO("hi"));
		return x;
	}

	@Override
	public StudentDTO add(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO read(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO update(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO delete(StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
