package com.lc.demo.stockprices.server.publisher;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.lc.demo.stockprices.model.StockPricesBoard;
import com.lc.demo.stockprices.model.StockInfo;
import com.lc.demo.stockprices.model.Symbols;
import com.lc.demo.stockprices.server.data.dao.DAOFactory;

/**
 * @author isa
 * TODO: Consider implementing this class if a push mechanism is preferred instead of pulling
 */
public class StockInfoPublisher {

	private static StockPricesBoard board;
	private static DAOFactory daoFactory;
	private static Symbols symbols;
	
	public StockInfoPublisher()  {
		if (daoFactory == null ) {
			daoFactory = new DAOFactory();
		}
		if (board == null) {			
			loadBoard();
			scheduleFutureBoardUpdates();
		}
	}

	@SuppressWarnings("unchecked")
	public void loadBoard() {
		board = new StockPricesBoard();
		symbols = new Symbols((List<String>)fetchSymbols());
		updateBoard();		
	}
	
	private List<?> fetchSymbols() {
		return daoFactory.getDAO(Symbols.class.getSimpleName()).findAll();
	}
	
	private StockInfo getStockInfoUpdated(String symbol) {
		return (StockInfo)daoFactory.getDAO(StockInfo.class.getSimpleName()).find(symbol);
	}
	
	
	public void updateBoard() {		
		for(String symbol: getSymbols().getSymbols()) {
		  board.getBoard().put(symbol, getStockInfoUpdated(symbol));
		  System.out.println("######################## - updateBoard "+symbol+" "+board.getBoard().get(symbol).getBid()+" "+board.getBoard().get(symbol).getAsk());
		}
	}

	public void scheduleFutureBoardUpdates() {
		ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(5);
		s.scheduleWithFixedDelay(new StockPricesBoardUpdateTask(this), 500, 500, TimeUnit.MILLISECONDS);	
	}
	
	
	/**
	 * @return the board
	 */
	public StockPricesBoard getBoard() {
		return board;
	}

	/**
	 * @return the symbols
	 */
	public Symbols getSymbols() {
		return symbols;
	}
	
	
	public class StockPricesBoardUpdateTask implements Runnable
	{
		StockInfoPublisher publisher;
		
		public StockPricesBoardUpdateTask(StockInfoPublisher publisher) {
			this.publisher = publisher;
		}
		
	    public void run()
	    {
	    	publisher.updateBoard();
	    }
	 }

}
