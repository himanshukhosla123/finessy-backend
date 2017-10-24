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

import com.finessy.admin.DAO.SubfieldDetailsDAOImpl;
import com.finessy.admin.DTO.SubfieldDetailsDTO;

@WebServlet(urlPatterns="/subfield")
public class SubfieldDetailsCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SubfieldDetailsDAOImpl subfieldsDAO = new SubfieldDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<SubfieldDetailsDTO> subfieldsList = null;
		try {
			subfieldsList = subfieldsDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(subfieldsList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		SubfieldDetailsDAOImpl subfieldsDAO = new SubfieldDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		SubfieldDetailsDTO subfieldsDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<SubfieldDetailsDTO> subfieldsList = subfieldsDAO.readAll();
					json = mapper.writeValueAsString(subfieldsList);
					response.getWriter().println(json);
					break;
				case "add":
					subfieldsDTO = mapper.readValue(dtoObj, new TypeReference<SubfieldDetailsDTO>(){});
					subfieldsDTO = subfieldsDAO.add(subfieldsDTO);
					json = mapper.writeValueAsString(subfieldsDTO);
					response.getWriter().println(json);
					break;
				case "read":
					subfieldsDTO = mapper.readValue(dtoObj, new TypeReference<SubfieldDetailsDTO>(){});
					subfieldsDTO = subfieldsDAO.read(subfieldsDTO);
					json = mapper.writeValueAsString(subfieldsDTO);
					response.getWriter().println(json);
					break;
				case "update":
					subfieldsDTO = mapper.readValue(dtoObj, new TypeReference<SubfieldDetailsDTO>(){});
					subfieldsDTO = subfieldsDAO.update(subfieldsDTO);
					json = mapper.writeValueAsString(subfieldsDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					subfieldsDTO = mapper.readValue(dtoObj, new TypeReference<SubfieldDetailsDTO>(){});
					subfieldsDTO = subfieldsDAO.delete(subfieldsDTO);
					json = mapper.writeValueAsString(subfieldsDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
