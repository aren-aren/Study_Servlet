package com.studyservlet.app.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println("uri = " + uri);

		String[] names = uri.split("/");

		String v = "/WEB-INF/views/index.jsp";
		
		try {
			if (names[1].equals("regions")) {
				// regionDAO 사용
				RegionDAO dao = new RegionDAO();
				
				if (names[2].equals("list")) {
					List<RegionDTO> list = dao.getList();
					request.setAttribute("list", list);
					v = "/WEB-INF/views/regions/list.jsp";
					
				} else if(names[2].equals("detail")) {
					String id = request.getParameter("region_id");
					
					RegionDTO dto = new RegionDTO();
					dto.setRegion_id(Integer.parseInt(id));
					dto = dao.getDetail(dto);
					
					request.setAttribute("detail", dto);
					v = "/WEB-INF/views/regions/detail.jsp";
					
				}
			} else if (names[1].equals("departments")) {
				// departmentDAO사용
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		RequestDispatcher view = request.getRequestDispatcher(v);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
