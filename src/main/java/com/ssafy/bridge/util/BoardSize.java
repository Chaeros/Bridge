package com.ssafy.bridge.util;

public enum BoardSize {

	LIST(10), NAVIGATION(6);

	private int boardSize;

	private BoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public int getBoardSize() {
		return boardSize;
	}
}
