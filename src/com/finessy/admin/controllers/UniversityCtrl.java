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

import com.finessy.admin.DAO.UniversityDAOImpl;
import com.finessy.admin.DTO.UniversityDTO;

@WebServlet(urlPatterns="/universityCtrl")
public class UniversityCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UniversityDAOImpl universityDAO=new UniversityDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<UniversityDTO> universityList=null;
		try {
			universityList = universityDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(universityList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods","GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		UniversityDAOImpl universityDAO = new UniversityDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		UniversityDTO universityDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<UniversityDTO> universityList = universityDAO.readAll();
					json = mapper.writeValueAsString(universityList);
					response.getWriter().println(json);
					break;
				case "add":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDTO>(){});
					universityDTO = universityDAO.add(universityDTO);
					json = mapper.writeValueAsString(universityDTO);
					response.getWriter().println(json);
					break;
				case "read":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDTO>(){});
					universityDTO = universityDAO.read(universityDTO);
					json = mapper.writeValueAsString(universityDTO);
					response.getWriter().println(json);
					break;
				case "update":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDTO>(){});
					universityDTO = universityDAO.update(universityDTO);
					json = mapper.writeValueAsString(universityDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					universityDTO = mapper.readValue(dtoObj, new TypeReference<UniversityDTO>(){});
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
