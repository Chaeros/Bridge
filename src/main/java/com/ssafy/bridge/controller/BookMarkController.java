package com.ssafy.bridge.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ssafy.bridge.bookmark.dto.response.BookMarkResponse;
import com.ssafy.bridge.bookmark.service.BookMarkService;
import com.ssafy.bridge.bookmark.service.BookMarkServiceImpl;
import com.ssafy.bridge.member.dto.response.MemberLoginResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bookmark")
public class BookMarkController extends HttpServlet {
	private static BookMarkController bookMarkController;
	private BookMarkService bookMarkService;
	public BookMarkController() {
		bookMarkService = BookMarkServiceImpl.getInstance();
	}
	public static BookMarkController getInstance() {
		if ( bookMarkController == null ) {
			bookMarkController = new BookMarkController();
		}
		return bookMarkController;
	}
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch(action) {
			case "add":
				addBookMark(request,response);
				break;
			case "list":
				listBookMark(request,response);
				break;
			case "remove":
				removeBookMark(request,response);
				break;
			case "removeByContentId":
				removeByContentIdBookMark(request,response);
				break;
			case "isIn":
				isInBookMark(request,response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void removeByContentIdBookMark(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
		int contentId = jsonBody.get("contentId").getAsInt();
		
        bookMarkService.removeByContentIdBookMark(contentId);
        System.out.println(contentId +" , remove");
	}
	
	private void isInBookMark(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
		int contentId = jsonBody.get("contentId").getAsInt();
		
		boolean isInBookMark = bookMarkService.searchBookMark(contentId);
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    String attractionInfoJson = objectMapper.writeValueAsString(isInBookMark);
	    response.getWriter().write(attractionInfoJson);
	}
	
	private void removeBookMark(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
		int myAttractionId = jsonBody.get("myAttractionId").getAsInt();
		
        bookMarkService.removeBookMark(myAttractionId);
	}
	
	private void listBookMark(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		MemberLoginResponse member = (MemberLoginResponse) session.getAttribute("member");
		List<BookMarkResponse> bookMarks = bookMarkService.displayBookMarkList(member.getId());
        System.out.println(bookMarks.size());
		
        response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    String attractionInfoJson = objectMapper.writeValueAsString(bookMarks);
	    response.getWriter().write(attractionInfoJson);
	}
	
	private void addBookMark(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
        
		HttpSession session = request.getSession();
		MemberLoginResponse member = (MemberLoginResponse) session.getAttribute("member");
        int contentId = jsonBody.get("contentId").getAsInt();
        bookMarkService.addBookMark(contentId, member.getId());
	}
	
}
