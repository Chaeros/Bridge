package com.ssafy.bridge.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.bridge.gugun.service.GugunService;
import com.ssafy.bridge.gugun.service.GugunServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugun")
public class GugunController extends HttpServlet {
	private static GugunController gugunController;
	private GugunService gugunService;
	private GugunController() {
		gugunService = GugunServiceImpl.getInstance();
	}
	public static GugunController getInstance() {
		if ( gugunController == null ) {
			gugunController = new GugunController();
		}
		return gugunController;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "list":
				displayGugun(request,response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void displayGugun(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("guguns", gugunService.displayGugunList());
		request.getRequestDispatcher("").forward(request, response);
	}
	
	
}
