package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.UniversityDTO;

public interface IUniversityDAO {

	ArrayList<UniversityDTO> readAll() throws ClassNotFoundException ,SQLException;
	UniversityDTO add(UniversityDTO studentDTO) throws ClassNotFoundException, SQLException;
	UniversityDTO read(UniversityDTO studentDTO) throws ClassNotFoundException, SQLException;
	UniversityDTO update(UniversityDTO studentDTO) throws ClassNotFoundException, SQLException;
	UniversityDTO delete(UniversityDTO studentDTO) throws ClassNotFoundException, SQLException;

}
