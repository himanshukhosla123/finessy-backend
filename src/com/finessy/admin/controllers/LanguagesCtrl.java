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

import com.finessy.admin.DAO.LanguagesDAOImpl;
import com.finessy.admin.DTO.LanguagesDTO;

@WebServlet(urlPatterns="/language")
public class LanguagesCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LanguagesDAOImpl languageDAO = new LanguagesDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<LanguagesDTO> languageList = null;
		try {
			languageList = languageDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(languageList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		LanguagesDAOImpl languageDAO = new LanguagesDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		LanguagesDTO languageDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<LanguagesDTO> languageList = languageDAO.readAll();
					json = mapper.writeValueAsString(languageList);
					response.getWriter().println(json);
					break;
				case "add":
					languageDTO = mapper.readValue(dtoObj, new TypeReference<LanguagesDTO>(){});
					languageDTO = languageDAO.add(languageDTO);
					json = mapper.writeValueAsString(languageDTO);
					response.getWriter().println(json);
					break;
				case "read":
					languageDTO = mapper.readValue(dtoObj, new TypeReference<LanguagesDTO>(){});
					languageDTO = languageDAO.read(languageDTO);
					json = mapper.writeValueAsString(languageDTO);
					response.getWriter().println(json);
					break;
				case "update":
					languageDTO = mapper.readValue(dtoObj, new TypeReference<LanguagesDTO>(){});
					languageDTO = languageDAO.update(languageDTO);
					json = mapper.writeValueAsString(languageDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					languageDTO = mapper.readValue(dtoObj, new TypeReference<LanguagesDTO>(){});
					languageDTO = languageDAO.delete(languageDTO);
					json = mapper.writeValueAsString(languageDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
