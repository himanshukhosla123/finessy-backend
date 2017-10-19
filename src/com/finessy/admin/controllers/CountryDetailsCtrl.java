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

import com.finessy.admin.DAO.CountryDetailsDAOImpl;
import com.finessy.admin.DTO.CountryDetailsDTO;

@WebServlet(urlPatterns="/countryCtrl")
public class CountryDetailsCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CountryDetailsDAOImpl countryDAO = new CountryDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<CountryDetailsDTO> countryList = null;
		try {
			countryList = countryDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(countryList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods","GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		CountryDetailsDAOImpl countryDAO = new CountryDetailsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		CountryDetailsDTO countryDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<CountryDetailsDTO> countryList = countryDAO.readAll();
					json = mapper.writeValueAsString(countryList);
					response.getWriter().println(json);
					break;
				case "add":
					countryDTO = mapper.readValue(dtoObj,new TypeReference<CountryDetailsDTO>(){});
					countryDTO = countryDAO.add(countryDTO);
					json = mapper.writeValueAsString(countryDTO);
					response.getWriter().println(json);
					break;
				case "read":
					countryDTO = mapper.readValue(dtoObj,new TypeReference<CountryDetailsDTO>(){});
					countryDTO = countryDAO.read(countryDTO);
					json = mapper.writeValueAsString(countryDTO);
					response.getWriter().println(json);
					break;
				case "update":
					countryDTO = mapper.readValue(dtoObj,new TypeReference<CountryDetailsDTO>(){});
					countryDTO = countryDAO.update(countryDTO);
					json = mapper.writeValueAsString(countryDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					countryDTO = mapper.readValue(dtoObj,new TypeReference<CountryDetailsDTO>(){});
					countryDTO = countryDAO.delete(countryDTO);
					json = mapper.writeValueAsString(countryDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
