package com.ssafy.bridge.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;
import com.ssafy.bridge.gugun.dto.response.GugunResponse;
import com.ssafy.bridge.gugun.service.GugunService;
import com.ssafy.bridge.gugun.service.GugunServiceImpl;
import com.ssafy.bridge.sido.dto.response.SidoResponse;

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
	private ObjectMapper objectMapper = new ObjectMapper();
	
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
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
        
        int sidoCode = jsonBody.get("sidoCode").getAsInt();
        
		List<GugunResponse> guguns = gugunService.displayGugunList(sidoCode);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    String attractionInfoJson = objectMapper.writeValueAsString(guguns);
	    response.getWriter().write(attractionInfoJson);
	}
	
}
