<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%

%>
<!DOCTYPE html>
<head>
	<link rel="stylesheet" href="./css/common/frame.css" />
</head>
<header class="header">
 	<div class="header-position">
		<div class="header-content">
			<h1 class="title"><a href="">Bridge</a></h1>
			<div class="nav">	
				<a href="${pageContext.request.contextPath}/attractionInfo?action=main">관광지 찾기</a>
				<a href="${pageContext.request.contextPath}/freeboard?action=list">게시판</a>
				<a href="${pageContext.request.contextPath}/member?action=search">내 정보</a>
				<a href="${pageContext.request.contextPath}/member?action=logout">로그아웃</a>
			</div>
    	</div>
	</div>
</header>