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

import com.finessy.admin.DAO.FieldFactsDAOImpl;
import com.finessy.admin.DTO.FieldFactsDTO;

@WebServlet("/field")
public class FieldFactsCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FieldFactsDAOImpl fieldDAO = new FieldFactsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<FieldFactsDTO> fieldList = null;
		try {
			fieldList = fieldDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(fieldList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		FieldFactsDAOImpl fieldDAO = new FieldFactsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		FieldFactsDTO fieldDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<FieldFactsDTO> fieldList = fieldDAO.readAll();
					json = mapper.writeValueAsString(fieldList);
					response.getWriter().println(json);
					break;
				case "add":
					fieldDTO = mapper.readValue(dtoObj, new TypeReference<FieldFactsDTO>(){});
					fieldDTO = fieldDAO.add(fieldDTO);
					json = mapper.writeValueAsString(fieldDTO);
					response.getWriter().println(json);
					break;
				case "read":
					fieldDTO = mapper.readValue(dtoObj, new TypeReference<FieldFactsDTO>(){});
					fieldDTO = fieldDAO.read(fieldDTO);
					json = mapper.writeValueAsString(fieldDTO);
					response.getWriter().println(json);
					break;
				case "update":
					fieldDTO = mapper.readValue(dtoObj, new TypeReference<FieldFactsDTO>(){});
					fieldDTO = fieldDAO.update(fieldDTO);
					json = mapper.writeValueAsString(fieldDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					fieldDTO = mapper.readValue(dtoObj, new TypeReference<FieldFactsDTO>(){});
					fieldDTO = fieldDAO.delete(fieldDTO);
					json = mapper.writeValueAsString(fieldDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
