package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.UniversityDetailsDTO;

public interface IUniversityDetailsDAO {

	ArrayList<UniversityDetailsDTO> readAll() throws ClassNotFoundException ,SQLException;
	UniversityDetailsDTO add(UniversityDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	UniversityDetailsDTO read(UniversityDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	UniversityDetailsDTO update(UniversityDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	UniversityDetailsDTO delete(UniversityDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;

}
