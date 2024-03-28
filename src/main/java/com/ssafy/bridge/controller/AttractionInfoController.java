	package com.ssafy.bridge.controller;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ssafy.bridge.attraction.info.dto.request.AttractionInfoListRequest;
import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;
import com.ssafy.bridge.attraction.info.service.AttractionInfoService;
import com.ssafy.bridge.attraction.info.service.AttractionInfoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/attractionInfo")
public class AttractionInfoController extends HttpServlet {
	
	private static AttractionInfoController attractionInfoController;
	private AttractionInfoService attractionInfoService;
	public AttractionInfoController() {
		attractionInfoService = AttractionInfoServiceImpl.getInstance();
	}
	public static AttractionInfoController getInstance() {
		if ( attractionInfoController == null ) {
			attractionInfoController = new AttractionInfoController();
		}
		return attractionInfoController;
	}
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		try {
			switch(action) {
			case "list":
				System.out.println("list");
				displayAttractionInfoList(request,response);
				break;
			case "search":
				searchAttractionInfo(request,response);
				break;
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	private void searchAttractionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
        
        int contentId = jsonBody.get("contentId").getAsInt();
        
		AttractionInfoResponse attractionInfo = attractionInfoService.searchAttractionInfo(contentId);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    String attractionInfoJson = objectMapper.writeValueAsString(attractionInfo);
	    response.getWriter().write(attractionInfoJson);
	}
	
	private void displayAttractionInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
        
        AttractionInfoListRequest attractionInfoListRequest =
        		new AttractionInfoListRequest(
        				jsonBody.get("sidoCode").getAsInt(),
        				jsonBody.get("gugunCode").getAsInt(),
        				jsonBody.get("contentTypeId").getAsInt(),
        				jsonBody.get("title").getAsString()
        				);
		
        List<AttractionInfoResponse> attractionInfoList = attractionInfoService.displayFreeBoardList(attractionInfoListRequest);
        response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    String attractionInfoJson = objectMapper.writeValueAsString(attractionInfoList);
	    response.getWriter().write(attractionInfoJson);
	}
	
}
