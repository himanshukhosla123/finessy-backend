package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.AlumniDTO;

public interface IAlumniDAO {
	
	ArrayList<AlumniDTO> readAll() throws ClassNotFoundException ,SQLException;
	AlumniDTO add(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException;
	AlumniDTO read(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException;
	AlumniDTO update(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException;
	AlumniDTO delete(AlumniDTO alumniDTO) throws ClassNotFoundException, SQLException;

}
