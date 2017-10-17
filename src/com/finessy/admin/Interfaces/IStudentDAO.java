package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.StudentDTO;

public interface IStudentDAO {

	ArrayList<StudentDTO> readAll() throws ClassNotFoundException ,SQLException;
	StudentDTO add(StudentDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentDTO read(StudentDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentDTO update(StudentDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentDTO delete(StudentDTO studentDTO) throws ClassNotFoundException, SQLException;

}
