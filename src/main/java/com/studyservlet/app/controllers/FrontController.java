package com.studyservlet.app.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyservlet.app.regions.RegionDAO;
import com.studyservlet.app.regions.RegionDTO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegionDAO regionDAO = new RegionDAO();
		try {
			List<RegionDTO> list = regionDAO.getList();
			PrintWriter out = response.getWriter();
			out.print("<h1>MyHome</h1>");
			
			out.println("<table>");
			for(RegionDTO dto : list) {
				out.println("<tr>");
				
				out.println("<td>" + dto.getRegion_id() + "</td>");
				out.println("<td>" + dto.getRegion_name() + "</td>");
				
				
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
