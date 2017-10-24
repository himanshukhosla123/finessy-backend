package sanuj.finessy.admin.controllers;

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

import com.finessy.admin.DAO.StudentAbroadDAO;
import com.finessy.admin.DTO.StudentAbroadDTO;

/**
 * Servlet implementation class StudentAbroadController
 */
@WebServlet("/StudentAbroadController")
public class StudentAbroadController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentAbroadDAO studentabroadDAO = new StudentAbroadDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<StudentAbroadDTO> studentabroadList=null;
		try {
			studentabroadList = studentabroadDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(studentabroadList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods","GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		StudentAbroadDAO studentabroadDAO = new StudentAbroadDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		StudentAbroadDTO studentabroadDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<StudentAbroadDTO> studentabroadList = studentabroadDAO.readAll();
					json = mapper.writeValueAsString(studentabroadList);
					response.getWriter().println(json);
					break;
				case "add":
					studentabroadDTO = mapper.readValue(dtoObj,new TypeReference<StudentAbroadDTO>(){});
					studentabroadDTO = studentabroadDAO.add(studentabroadDTO);
					json = mapper.writeValueAsString(studentabroadDTO);
					response.getWriter().println(json);
					break;
				case "read":
					studentabroadDTO = mapper.readValue(dtoObj,new TypeReference<StudentAbroadDTO>(){});
					studentabroadDTO = studentabroadDAO.read(studentabroadDTO);
					json = mapper.writeValueAsString(studentabroadDTO);
					response.getWriter().println(json);
					break;
				case "update":
					studentabroadDTO = mapper.readValue(dtoObj,new TypeReference<StudentAbroadDTO>(){});
					studentabroadDTO = studentabroadDAO.update(studentabroadDTO);
					json = mapper.writeValueAsString(studentabroadDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					studentabroadDTO = mapper.readValue(dtoObj,new TypeReference<StudentAbroadDTO>(){});
					studentabroadDTO = studentabroadDAO.delete(studentabroadDTO);
					json = mapper.writeValueAsString(studentabroadDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}

}
