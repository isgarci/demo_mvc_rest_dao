package com.lc.demo.stockprices.model;

/**
 * @author isa
 *
 */
public class StockInfo {

	protected String symbol;
	protected String ask;
	protected String bid;

	public StockInfo() {
	}

	public StockInfo(String symbol, String ask, String bid) {
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

}
