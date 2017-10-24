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

import com.finessy.admin.DAO.UniversityDetailsDAOImpl;
import com.finessy.admin.DTO.UniversityDetailsDTO;

@WebServlet(urlPatterns="/universityCtrl")
public class UniversityDetailsCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UniversityDetailsDAOImpl universityDAO = new UniversityDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<UniversityDetailsDTO> universityList = null;
		try {
			universityList = universityDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(universityList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		UniversityDetailsDAOImpl universityDAO = new UniversityDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		UniversityDetailsDTO universityDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<UniversityDetailsDTO> universityList = universityDAO.readAll();
					json = mapper.writeValueAsString(universityList);
					response.getWriter().println(json);
					break;
				case "add":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDetailsDTO>(){});
					universityDTO = universityDAO.add(universityDTO);
					json = mapper.writeValueAsString(universityDTO);
					response.getWriter().println(json);
					break;
				case "read":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDetailsDTO>(){});
					universityDTO = universityDAO.read(universityDTO);
					json = mapper.writeValueAsString(universityDTO);
					response.getWriter().println(json);
					break;
				case "update":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDetailsDTO>(){});
					universityDTO = universityDAO.update(universityDTO);
					json = mapper.writeValueAsString(universityDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDetailsDTO>(){});
					universityDTO = universityDAO.delete(universityDTO);
					json = mapper.writeValueAsString(universityDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
	}

}
