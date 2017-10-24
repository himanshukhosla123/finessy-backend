package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.CountryDetailsDTO;

public interface ICountryDetailsDAO {

	ArrayList<CountryDetailsDTO> readAll() throws ClassNotFoundException ,SQLException;
	CountryDetailsDTO add(CountryDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	CountryDetailsDTO read(CountryDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	CountryDetailsDTO update(CountryDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;
	CountryDetailsDTO delete(CountryDetailsDTO studentDTO) throws ClassNotFoundException, SQLException;

}
