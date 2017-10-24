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

import com.finessy.admin.DAO.BestMarketDAO;
import com.finessy.admin.DTO.BestMarketDTO;

/**
 * Servlet implementation class BestMarketController
 */
@WebServlet("/BestMarketController")
public class BestMarketController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BestMarketDAO bestmarketDAO = new BestMarketDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		ArrayList<BestMarketDTO> bestmarketList=null;
		try {
			bestmarketList = bestmarketDAO.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		json = mapper.writeValueAsString(bestmarketList);
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
		BestMarketDAO bestmarketDAO = new BestMarketDAO();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		BestMarketDTO bestmarketDTO;
		
		try{
			switch(methodName){
				case "readAll":
					ArrayList<BestMarketDTO> bestmarketList = bestmarketDAO.readAll();
					json = mapper.writeValueAsString(bestmarketList);
					response.getWriter().println(json);
					break;
				case "add":
					bestmarketDTO = mapper.readValue(dtoObj,new TypeReference<BestMarketDTO>(){});
					bestmarketDTO = bestmarketDAO.add(bestmarketDTO);
					json = mapper.writeValueAsString(bestmarketDTO);
					response.getWriter().println(json);
					break;
				case "read":
					bestmarketDTO = mapper.readValue(dtoObj,new TypeReference<BestMarketDTO>(){});
					bestmarketDTO = bestmarketDAO.read(bestmarketDTO);
					json = mapper.writeValueAsString(bestmarketDTO);
					response.getWriter().println(json);
					break;
				case "update":
					bestmarketDTO = mapper.readValue(dtoObj,new TypeReference<BestMarketDTO>(){});
					bestmarketDTO = bestmarketDAO.update(bestmarketDTO);
					json = mapper.writeValueAsString(bestmarketDTO);
					response.getWriter().println(json);
					break;
				case "delete":
					bestmarketDTO = mapper.readValue(dtoObj,new TypeReference<BestMarketDTO>(){});
					bestmarketDTO = bestmarketDAO.delete(bestmarketDTO);
					json = mapper.writeValueAsString(bestmarketDTO);
					response.getWriter().println(json);
					break;
			};
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}

}
