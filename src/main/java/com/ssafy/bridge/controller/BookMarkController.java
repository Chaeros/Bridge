package com.ssafy.bridge.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ssafy.bridge.bookmark.service.BookMarkService;
import com.ssafy.bridge.bookmark.service.BookMarkServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("bookmark");
		try {
			switch(action) {
			case "add":
				addBookMark(request,response);
				break;
			case "list":
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addBookMark(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
		JsonObject jsonBody = JsonParser.parseString(sb.toString()).getAsJsonObject();
        
        int contentId = jsonBody.get("contentId").getAsInt();
        bookMarkService.addBookMark(contentId, "ssafy");
        System.out.println("confirm");
	}
	
}
