package com.finessy.admin.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.finessy.admin.DTO.AdminInterfaceDTO;

public interface IAdminInterfaceDAO {
	
	ArrayList<AdminInterfaceDTO> readAll() throws ClassNotFoundException ,SQLException;
	AdminInterfaceDTO add(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException;
	AdminInterfaceDTO read(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException;
	AdminInterfaceDTO update(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException;
	AdminInterfaceDTO delete(AdminInterfaceDTO userDTO) throws ClassNotFoundException, SQLException;

}
