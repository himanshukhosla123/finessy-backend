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

import com.finessy.admin.DAO.FamousProgramsDAO;
import com.finessy.admin.DTO.FamousProgramsDTO;

/**
 * Servlet implementation class FamousProgramsController
 */
@WebServlet("/FamousProgramsController")
public class FamousProgramsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FamousProgramsDAO famousprogramsDAO = new FamousProgramsDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<FamousProgramsDTO> famousprogramsList=null;
		try {
			famousprogramsList = famousprogramsDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(famousprogramsList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods","GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		FamousProgramsDAO famousprogramsDAO = new FamousProgramsDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		FamousProgramsDTO famousprogramsDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<FamousProgramsDTO> famousprogramsList = famousprogramsDAO.readAll();
					json = mapper.writeValueAsString(famousprogramsList);
					response.getWriter().println(json);
					break;
				case "add":
					famousprogramsDTO = mapper.readValue(dtoObj,new TypeReference<FamousProgramsDTO>(){});
					famousprogramsDTO = famousprogramsDAO.add(famousprogramsDTO);
					json = mapper.writeValueAsString(famousprogramsDTO);
					response.getWriter().println(json);
					break;
				case "read":
					famousprogramsDTO = mapper.readValue(dtoObj,new TypeReference<FamousProgramsDTO>(){});
					famousprogramsDTO = famousprogramsDAO.read(famousprogramsDTO);
					json = mapper.writeValueAsString(famousprogramsDTO);
					response.getWriter().println(json);
					break;
				case "update":
					famousprogramsDTO = mapper.readValue(dtoObj,new TypeReference<FamousProgramsDTO>(){});
					famousprogramsDTO = famousprogramsDAO.update(famousprogramsDTO);
					json = mapper.writeValueAsString(famousprogramsDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					famousprogramsDTO = mapper.readValue(dtoObj,new TypeReference<FamousProgramsDTO>(){});
					famousprogramsDTO = famousprogramsDAO.delete(famousprogramsDTO);
					json = mapper.writeValueAsString(famousprogramsDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}

}
