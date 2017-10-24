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

import com.finessy.admin.DAO.ProgramDetailsDAOImpl;
import com.finessy.admin.DTO.ProgramDetailsDTO;

@WebServlet(urlPatterns="/program")
public class ProgramDetailsCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProgramDetailsDAOImpl programDAO = new ProgramDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<ProgramDetailsDTO> programList = null;
		try {
			programList = programDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(programList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		ProgramDetailsDAOImpl programDAO = new ProgramDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ProgramDetailsDTO programDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<ProgramDetailsDTO> programList = programDAO.readAll();
					json = mapper.writeValueAsString(programList);
					response.getWriter().println(json);
					break;
				case "add":
					programDTO = mapper.readValue(dtoObj, new TypeReference<ProgramDetailsDTO>(){});
					programDTO = programDAO.add(programDTO);
					json = mapper.writeValueAsString(programDTO);
					response.getWriter().println(json);
					break;
				case "read":
					programDTO = mapper.readValue(dtoObj, new TypeReference<ProgramDetailsDTO>(){});
					programDTO = programDAO.read(programDTO);
					json = mapper.writeValueAsString(programDTO);
					response.getWriter().println(json);
					break;
				case "update":
					programDTO = mapper.readValue(dtoObj, new TypeReference<ProgramDetailsDTO>(){});
					programDTO = programDAO.update(programDTO);
					json = mapper.writeValueAsString(programDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					programDTO = mapper.readValue(dtoObj, new TypeReference<ProgramDetailsDTO>(){});
					programDTO = programDAO.delete(programDTO);
					json = mapper.writeValueAsString(programDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
