package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.CountryDTO;

public interface ICountryDAO {

	ArrayList<CountryDTO> readAll() throws ClassNotFoundException ,SQLException;
	CountryDTO add(CountryDTO studentDTO) throws ClassNotFoundException, SQLException;
	CountryDTO read(CountryDTO studentDTO) throws ClassNotFoundException, SQLException;
	CountryDTO update(CountryDTO studentDTO) throws ClassNotFoundException, SQLException;
	CountryDTO delete(CountryDTO studentDTO) throws ClassNotFoundException, SQLException;

}
