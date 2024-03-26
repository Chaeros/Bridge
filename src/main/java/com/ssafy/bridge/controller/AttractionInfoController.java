package com.ssafy.bridge.controller;

import java.io.IOException;
import java.sql.SQLException;

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
	private AttractionInfoController() {
		attractionInfoService = AttractionInfoServiceImpl.getInstance();
	}
	public static AttractionInfoController getInstance() {
		if ( attractionInfoController == null ) {
			attractionInfoController = new AttractionInfoController();
		}
		return attractionInfoController;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "list":
				displayAttractionInfoList(request,response);
				break;
			case "search":
				searchAttractionInfo(request,response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	private void searchAttractionInfo(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException {
		attractionInfoService.searchAttractionInfo(Integer.parseInt(request.getParameter("contentId")));
	}
	
	private void displayAttractionInfoList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		attractionInfoService.displayFreeBoardList();
		
	}
	
}
