package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.StudentFormDTO;

public interface IStudentFormDAO {
	
	ArrayList<StudentFormDTO> readAll() throws ClassNotFoundException ,SQLException;
	StudentFormDTO add(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentFormDTO read(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentFormDTO update(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException;
	StudentFormDTO delete(StudentFormDTO studentDTO) throws ClassNotFoundException, SQLException;

}
