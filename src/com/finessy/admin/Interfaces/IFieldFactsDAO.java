package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.FieldFactsDTO;

public interface IFieldFactsDAO {
	
	ArrayList<FieldFactsDTO> readAll() throws ClassNotFoundException ,SQLException;
	FieldFactsDTO add(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException;
	FieldFactsDTO read(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException;
	FieldFactsDTO update(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException;
	FieldFactsDTO delete(FieldFactsDTO fieldFactsDTO) throws ClassNotFoundException, SQLException;

}
