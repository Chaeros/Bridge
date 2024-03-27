package com.ssafy.bridge.controller;

import java.io.IOException;

import com.ssafy.bridge.member.MemberService;
import com.ssafy.bridge.member.MemberServiceImpl;
import com.ssafy.bridge.member.dto.request.MemberAddRequest;
import com.ssafy.bridge.member.dto.request.MemberDeleteRequest;
import com.ssafy.bridge.member.dto.request.MemberLoginRequest;
import com.ssafy.bridge.member.dto.request.MemberModifyRequest;
import com.ssafy.bridge.member.dto.response.MemberLoginResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {

	private MemberService memberService = MemberServiceImpl.getInstance();;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "add":
				addMember(request, response);
				break;
			case "addForm":
				addFormMember(request, response);
				break;
			case "search":
				searchMember(request, response);
				break;
			case "login":
				loginMember(request, response);
				break;
			case "modify":
				modifyMember(request, response);
				break;
			case "modifyForm":
				modifyFormMember(request, response);
				break;
			case "remove":
				removeMember(request, response);
				break;
			case "removeForm":
				removeFormMember(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modifyFormMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberLoginResponse member = (MemberLoginResponse) session.getAttribute("member");
		request.setAttribute("id", member);

		request.getRequestDispatcher("/member/modify.jsp").forward(request, response);

	}

	private void removeFormMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/member/remove.jsp").forward(request, response);

	}

	private void addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		memberService.addMember(new MemberAddRequest(request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("nickName"), request.getParameter("region"),
				request.getParameter("email")));

		response.sendRedirect(request.getContextPath() + "/member/login.jsp");
	}

	private void addFormMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/member/signup.jsp").forward(request, response);
	}

	private void searchMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberLoginResponse member = (MemberLoginResponse) request.getSession().getAttribute("member");

		request.setAttribute("member", memberService.searchMember(member.getId()));
		request.getRequestDispatcher("/member/myPage.jsp").forward(request, response);
	}

	private void loginMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		session.setAttribute("member", memberService
				.loginMember(new MemberLoginRequest(request.getParameter("id"), request.getParameter("password"))));

		response.sendRedirect(request.getContextPath() + "/boardindex.jsp");

	}

	private void modifyMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberLoginResponse member = (MemberLoginResponse) session.getAttribute("member");

		memberService.modifyMember(new MemberModifyRequest(member.getId(), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("nickName"), request.getParameter("region"),
				request.getParameter("email")));
		response.sendRedirect(request.getContextPath() + "/member?action=search");
	}

	private void removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberLoginResponse member = (MemberLoginResponse) session.getAttribute("member");

		memberService.removeMember(new MemberDeleteRequest(member.getId(), request.getParameter("password")));
		response.sendRedirect(request.getContextPath() + "/boardindex.jsp");

	}
}