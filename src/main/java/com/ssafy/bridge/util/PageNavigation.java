package com.ssafy.bridge.util;

public class PageNavigation {

	private boolean startRange;
	private boolean endRange;
	private int totalCount;
	private int totalPageCount;
	private int currentPage;
	private int navSize;
	private String navigator;

	public boolean isStartRange() {
		return startRange;
	}

	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}

	public boolean isEndRange() {
		return endRange;
	}

	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNavSize() {
		return navSize;
	}

	public void setNavSize(int navSize) {
		this.navSize = navSize;
	}

	public String getNavigator() {
		return navigator;
	}

	public void setNavigator(String navigator) {
		this.navigator = navigator;
	}

	public void makeNavigator() {
		int startPage = (currentPage - 1) / navSize * navSize + 1;
		int endPage = startPage + navSize - 1;
		if (totalPageCount < endPage) {
			endPage = totalPageCount;
		}

		StringBuilder nav = new StringBuilder();
		nav.append(" <div class=\"pagination\"> \n");
		nav.append(" 	<a href=\"freeboard?action=list&pgno="
				+ (startRange ? 1 : startPage - 1) + "\">&laquo;</a> \n");
		for (int i = startPage; i <= endPage; i++) {
			nav.append("	<a href=\"freeboard?action=list&pgno=" + i + "\">" + i
					+ "</a> \n");
		}
		nav.append(" 	<a href=\"freeboard?action=list&pgno="
				+ (endRange ? endPage : endPage + 1) + "\">&raquo;</a> \n");
		nav.append(" </div> \n");

		navigator = nav.toString();
	}
}
