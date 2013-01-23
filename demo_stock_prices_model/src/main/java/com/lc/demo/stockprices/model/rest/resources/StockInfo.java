package com.lc.demo.stockprices.model.rest.resources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "stock-info")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StockInfo", propOrder = { "symbol", "ask", "bid" })
public class StockInfo extends com.lc.demo.stockprices.model.StockInfo {

	public StockInfo() {
	}


	/*public StockInfo(com.lc.demo.stockprices.model.StockInfo stockInfo) {
		super(stockInfo.getSymbol(),stockInfo.getAsk(),stockInfo.getBid());
	}*/

	public StockInfo(String symbol, String ask, String bid) {
		super(symbol,ask,bid);
	}
	
	@Override
	@XmlElement(name = "symbol")
	public String getSymbol() {
		return symbol;
	}
		
	@Override
	@XmlElement(name = "ask")
	public String getAsk() {
		return ask;
	}

	@Override
	@XmlElement(name = "bid")
	public String getBid() {
		return bid;
	}

	@Override
	public String toString() {
		return "StockInfo [symbol=" + symbol + ", ask=" + ask + ", bid=" + bid + "]";
	}
	
}
