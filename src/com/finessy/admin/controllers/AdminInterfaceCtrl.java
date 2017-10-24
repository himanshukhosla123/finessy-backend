package com.finessy.admin.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.finessy.admin.DAO.AdminInterfaceDAOImpl;
import com.finessy.admin.DTO.AdminInterfaceDTO;

@WebServlet(urlPatterns="/admin")
public class AdminInterfaceCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminInterfaceDAOImpl adminDAO = new AdminInterfaceDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<AdminInterfaceDTO> adminList = null;
		try {
			adminList = adminDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(adminList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		AdminInterfaceDAOImpl adminDAO = new AdminInterfaceDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		AdminInterfaceDTO adminDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<AdminInterfaceDTO> adminList = adminDAO.readAll();
					json = mapper.writeValueAsString(adminList);
					response.getWriter().println(json);
					break;
				case "add":
					adminDTO = mapper.readValue(dtoObj, new TypeReference<AdminInterfaceDTO>(){});
					adminDTO = adminDAO.add(adminDTO);
					json = mapper.writeValueAsString(adminDTO);
					response.getWriter().println(json);
					break;
				case "read":
					adminDTO = mapper.readValue(dtoObj, new TypeReference<AdminInterfaceDTO>(){});
					adminDTO = adminDAO.read(adminDTO);
					json = mapper.writeValueAsString(adminDTO);
					response.getWriter().println(json);
					break;
				case "update":
					adminDTO = mapper.readValue(dtoObj, new TypeReference<AdminInterfaceDTO>(){});
					adminDTO = adminDAO.update(adminDTO);
					json = mapper.writeValueAsString(adminDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					adminDTO = mapper.readValue(dtoObj, new TypeReference<AdminInterfaceDTO>(){});
					adminDTO = adminDAO.delete(adminDTO);
					json = mapper.writeValueAsString(adminDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
