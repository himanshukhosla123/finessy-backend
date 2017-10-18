package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.SubfieldDetailsDTO;

public interface ISubfieldDetailsDAO {
	
	ArrayList<SubfieldDetailsDTO> readAll() throws ClassNotFoundException ,SQLException;
	SubfieldDetailsDTO add(SubfieldDetailsDTO subfieldDetailsDTO) throws ClassNotFoundException, SQLException;
	SubfieldDetailsDTO read(SubfieldDetailsDTO subfieldDetailsDTO) throws ClassNotFoundException, SQLException;
	SubfieldDetailsDTO update(SubfieldDetailsDTO subfieldDetailsDTO) throws ClassNotFoundException, SQLException;
	SubfieldDetailsDTO delete(SubfieldDetailsDTO subfieldDetailsDTO) throws ClassNotFoundException, SQLException;

}
