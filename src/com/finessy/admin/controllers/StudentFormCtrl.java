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

import com.finessy.admin.DAO.StudentFormDAOImpl;
import com.finessy.admin.DTO.StudentFormDTO;

@WebServlet(urlPatterns="/form")
public class StudentFormCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentFormDAOImpl studentDAO = new StudentFormDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<StudentFormDTO> studentList = null;
		try {
			studentList = studentDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(studentList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		StudentFormDAOImpl studentDAO = new StudentFormDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		StudentFormDTO studentDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<StudentFormDTO> studentList = studentDAO.readAll();
					json = mapper.writeValueAsString(studentList);
					response.getWriter().println(json);
					break;
				case "add":
					studentDTO = mapper.readValue(dtoObj, new TypeReference<StudentFormDTO>(){});
					studentDTO = studentDAO.add(studentDTO);
					json = mapper.writeValueAsString(studentDTO);
					response.getWriter().println(json);
					break;
				case "read":
					studentDTO = mapper.readValue(dtoObj, new TypeReference<StudentFormDTO>(){});
					studentDTO = studentDAO.read(studentDTO);
					json = mapper.writeValueAsString(studentDTO);
					response.getWriter().println(json);
					break;
				case "update":
					studentDTO = mapper.readValue(dtoObj, new TypeReference<StudentFormDTO>(){});
					studentDTO = studentDAO.update(studentDTO);
					json = mapper.writeValueAsString(studentDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					studentDTO = mapper.readValue(dtoObj, new TypeReference<StudentFormDTO>(){});
					studentDTO = studentDAO.delete(studentDTO);
					json = mapper.writeValueAsString(studentDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
