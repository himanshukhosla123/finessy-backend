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

import com.finessy.admin.DAO.AlumniDAOImpl;
import com.finessy.admin.DTO.AlumniDTO;

@WebServlet(urlPatterns="/alumni")
public class AlumniCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlumniDAOImpl alumniDAO = new AlumniDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<AlumniDTO> alumniList = null;
		try {
			alumniList = alumniDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(alumniList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		AlumniDAOImpl alumniDAO = new AlumniDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		AlumniDTO alumniDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<AlumniDTO> alumniList = alumniDAO.readAll();
					json = mapper.writeValueAsString(alumniList);
					response.getWriter().println(json);
					break;
				case "add":
					alumniDTO = mapper.readValue(dtoObj, new TypeReference<AlumniDTO>(){});
					alumniDTO = alumniDAO.add(alumniDTO);
					json = mapper.writeValueAsString(alumniDTO);
					response.getWriter().println(json);
					break;
				case "read":
					alumniDTO = mapper.readValue(dtoObj, new TypeReference<AlumniDTO>(){});
					alumniDTO = alumniDAO.read(alumniDTO);
					json = mapper.writeValueAsString(alumniDTO);
					response.getWriter().println(json);
					break;
				case "update":
					alumniDTO = mapper.readValue(dtoObj, new TypeReference<AlumniDTO>(){});
					alumniDTO = alumniDAO.update(alumniDTO);
					json = mapper.writeValueAsString(alumniDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					alumniDTO = mapper.readValue(dtoObj, new TypeReference<AlumniDTO>(){});
					alumniDTO = alumniDAO.delete(alumniDTO);
					json = mapper.writeValueAsString(alumniDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
