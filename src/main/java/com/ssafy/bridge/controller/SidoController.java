package com.ssafy.bridge.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.bridge.sido.service.SidoService;
import com.ssafy.bridge.sido.service.SidoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sido")
public class SidoController extends HttpServlet{
	
	private static SidoController sidoController;
	private SidoService sidoService;
	private SidoController() {
		sidoService = SidoServiceImpl.getInstance();
	}
	public static SidoController getInstance() {
		if ( sidoController == null ) {
			sidoController = new SidoController();
		}
		return sidoController;
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "list":
				displaySido(request,response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void displaySido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("sidos", sidoService.displaySidoList());
		request.getRequestDispatcher("").forward(request, response);
	}
	
	
}
