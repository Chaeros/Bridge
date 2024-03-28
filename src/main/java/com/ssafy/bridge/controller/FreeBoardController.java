package com.ssafy.bridge.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jakartaee.commons.lang3.math.NumberUtils;

import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.service.FreeBoardService;
import com.ssafy.bridge.freeboard.service.FreeBoardServiceImpl;
import com.ssafy.bridge.util.PageNavigation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/freeboard")
public class FreeBoardController extends HttpServlet {

	FreeBoardService freeBoardService = FreeBoardServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "add":
				addFreeBoard(request, response);
				break;
			case "addForm":
				addFormFreeBoard(request, response);
				break;
			case "modify":
				modifyFreeBoard(request, response);
				break;
			case "modifyForm":
				modifyFormFreeBoard(request, response);
				break;
			case "remove":
				removeFreeBoard(request, response);
				break;
			case "search":
				searchFreeBoard(request, response);
				break;
			case "list":
				listFreeBoard(request, response);
				break;
			case "detail":
				detailFreeBoard(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void detailFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("board",
				freeBoardService.searchByNoFreeBoard(Integer.parseInt(request.getParameter("no"))));
		request.getRequestDispatcher("/freeboard/detail.jsp").forward(request, response);
	}

	private void listFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pgno", NumberUtils.toInt(request.getParameter("pgno"), 1));
		request.setAttribute("boards", freeBoardService.displayFreeBoardList(map));

		PageNavigation pageNavigation = freeBoardService.makePageNavigation(map);
		request.setAttribute("navigation", pageNavigation);
		
		request.getRequestDispatcher("/freeboard/list.jsp").forward(request, response);
	}

	private void searchFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("board",
				freeBoardService.searchByNoFreeBoard(Integer.parseInt(request.getParameter("no"))));
		response.sendRedirect("/bridge/freeboard?action=list");
	}

	private void removeFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		freeBoardService.removeFreeBoard(Integer.parseInt(request.getParameter("no")));
		response.sendRedirect("/bridge/freeboard?action=list");
	}

	private void modifyFormFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("board",
				freeBoardService.searchByNoFreeBoard(Integer.parseInt(request.getParameter("no"))));
		request.getRequestDispatcher("/freeboard/modify.jsp").forward(request, response);
	}

	private void modifyFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		freeBoardService.modifyFreeBoard(new FreeBoardModifyRequest(Integer.parseInt(request.getParameter("no")),
				request.getParameter("title"), request.getParameter("content")));
		response.sendRedirect("/bridge/freeboard?action=list");
	}

	private void addFormFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/freeboard/add.jsp").forward(request, response);
	}

	private void addFreeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		freeBoardService.addFreeBoard(new FreeBoardAddRequest(request.getParameter("title"),
				request.getParameter("content"), request.getParameter("writer")));
		response.sendRedirect("/bridge/freeboard?action=list");
	}

}
