package com.lc.demo.stockprices.client.controller;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.lc.demo.stockprices.client.events.StockPricesEventSource;
import com.lc.demo.stockprices.client.rest.StockInfoClient;
import com.lc.demo.stockprices.model.StockInfo;
import com.lc.demo.stockprices.model.Symbols;

public class DataManager extends StockPricesEventSource {

	private StockInfoClient stockInfoClient;
	private Symbols symbols;
	private ObservableList<StockInfo> data;
	
	public DataManager() {
		stockInfoClient = new StockInfoClient();  
        scheduleFutureBoardRefresh();
	}
	
	public Symbols getSymbols() {
		return new Symbols(stockInfoClient.getSymbols());		
	}

	public StockInfo getStockInfo(String symbol) {
		return stockInfoClient.getStockInfo(symbol);
	}
	
	public void loadData() {
		data = FXCollections.observableArrayList();
		symbols = getSymbols();
		StockInfo stockInfo;
		
		for(String symbol : symbols.getSymbols()) {
			stockInfo = getStockInfo(symbol);
			data.add(new StockInfo(stockInfo.getSymbol(),stockInfo.getBid(),stockInfo.getAsk()));
		}
	}
	
	public ObservableList<StockInfo> getData() {
		return data;
	}
		
	public void scheduleFutureBoardRefresh() { 
		ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(3);
		s.scheduleWithFixedDelay(new StockPricesRefreshTask(this), 0, 2, TimeUnit.SECONDS);			
	}

	public class StockPricesRefreshTask implements Runnable
	{
		private DataManager dataManager; 
		
		public StockPricesRefreshTask(DataManager dataManager) {
			this.dataManager = dataManager;
		}
		
	    public void run()
	    {
	    	dataManager.loadData();
	    	fireEvent();
	    }
	 }

	
	
}
