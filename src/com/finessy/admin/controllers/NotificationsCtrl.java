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

import com.finessy.admin.DAO.NotificationsDAOImpl;
import com.finessy.admin.DTO.NotificationsDTO;

@WebServlet(urlPatterns="/notification")
public class NotificationsCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NotificationsDAOImpl notificationDAO = new NotificationsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<NotificationsDTO> notificationList = null;
		try {
			notificationList = notificationDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(notificationList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		NotificationsDAOImpl notificationDAO = new NotificationsDAOImpl();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		NotificationsDTO notificationDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<NotificationsDTO> notificationList = notificationDAO.readAll();
					json = mapper.writeValueAsString(notificationList);
					response.getWriter().println(json);
					break;
				case "add":
					notificationDTO = mapper.readValue(dtoObj, new TypeReference<NotificationsDTO>(){});
					notificationDTO = notificationDAO.add(notificationDTO);
					json = mapper.writeValueAsString(notificationDTO);
					response.getWriter().println(json);
					break;
				case "read":
					notificationDTO = mapper.readValue(dtoObj, new TypeReference<NotificationsDTO>(){});
					notificationDTO = notificationDAO.read(notificationDTO);
					json = mapper.writeValueAsString(notificationDTO);
					response.getWriter().println(json);
					break;
				case "update":
					notificationDTO = mapper.readValue(dtoObj, new TypeReference<NotificationsDTO>(){});
					notificationDTO = notificationDAO.update(notificationDTO);
					json = mapper.writeValueAsString(notificationDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					notificationDTO = mapper.readValue(dtoObj, new TypeReference<NotificationsDTO>(){});
					notificationDTO = notificationDAO.delete(notificationDTO);
					json = mapper.writeValueAsString(notificationDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
