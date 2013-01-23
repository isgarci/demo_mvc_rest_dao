package com.lc.demo.stockprices.model;

import java.util.HashMap;


public class StockPricesBoard {

	private HashMap<String,StockInfo> board;
	
	public StockPricesBoard() {
		setBoard(new HashMap<String,StockInfo>());
	}

	/**
	 * @return the board
	 */
	public HashMap<String,StockInfo> getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(HashMap<String,StockInfo> board) {
		this.board = board;
	}
	
}
