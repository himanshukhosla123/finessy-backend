package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.LanguagesDTO;

public interface ILanguagesDAO {
	
	ArrayList<LanguagesDTO> readAll() throws ClassNotFoundException ,SQLException;
	LanguagesDTO add(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException;
	LanguagesDTO read(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException;
	LanguagesDTO update(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException;
	LanguagesDTO delete(LanguagesDTO languagesDTO) throws ClassNotFoundException, SQLException;

}
