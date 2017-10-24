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

import com.finessy.admin.DAO.ScholarsDAO;
import com.finessy.admin.DTO.ScholarsDTO;

/**
 * Servlet implementation class ScholarsController
 */
@WebServlet("/ScholarsController")
public class ScholarsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ScholarsDAO scholarsDAO = new ScholarsDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<ScholarsDTO> scholarsList=null;
		try {
			scholarsList = scholarsDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(scholarsList);
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods","GET");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().println(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = (String)request.getParameter("method");
		String dtoObj = request.getParameter("dto_obj");
		ScholarsDAO scholarsDAO = new ScholarsDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ScholarsDTO scholarsDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<ScholarsDTO> scholarsList = scholarsDAO.readAll();
					json = mapper.writeValueAsString(scholarsList);
					response.getWriter().println(json);
					break;
				case "add":
					scholarsDTO = mapper.readValue(dtoObj,new TypeReference<ScholarsDTO>(){});
					scholarsDTO = scholarsDAO.add(scholarsDTO);
					json = mapper.writeValueAsString(scholarsDTO);
					response.getWriter().println(json);
					break;
				case "read":
					scholarsDTO = mapper.readValue(dtoObj,new TypeReference<ScholarsDTO>(){});
					scholarsDTO = scholarsDAO.read(scholarsDTO);
					json = mapper.writeValueAsString(scholarsDTO);
					response.getWriter().println(json);
					break;
				case "update":
					scholarsDTO = mapper.readValue(dtoObj,new TypeReference<ScholarsDTO>(){});
					scholarsDTO = scholarsDAO.update(scholarsDTO);
					json = mapper.writeValueAsString(scholarsDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					scholarsDTO = mapper.readValue(dtoObj,new TypeReference<ScholarsDTO>(){});
					scholarsDTO = scholarsDAO.delete(scholarsDTO);
					json = mapper.writeValueAsString(scholarsDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}

}
