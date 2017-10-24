package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.ProgramDetailsDTO;

public interface IProgramDetailsDAO {
	
	ArrayList<ProgramDetailsDTO> readAll() throws ClassNotFoundException ,SQLException;
	ProgramDetailsDTO add(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException;
	ProgramDetailsDTO read(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException;
	ProgramDetailsDTO update(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException;
	ProgramDetailsDTO delete(ProgramDetailsDTO programDTO) throws ClassNotFoundException, SQLException;

}
