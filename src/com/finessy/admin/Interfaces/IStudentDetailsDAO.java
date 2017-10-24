package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.StudentDetailsDTO;

public interface IStudentDetailsDAO {

	ArrayList<StudentDetailsDTO> readAll() throws ClassNotFoundException ,SQLException;
	StudentDetailsDTO add(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentDetailsDTO read(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentDetailsDTO update(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentDetailsDTO delete(StudentDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;

}
