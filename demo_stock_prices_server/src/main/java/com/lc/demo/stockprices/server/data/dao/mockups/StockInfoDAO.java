package com.lc.demo.stockprices.server.data.dao.mockups;

import com.lc.demo.stockprices.model.StockInfo;
import com.lc.demo.stockprices.server.data.dao.GenericDAO;

import java.util.List;

public class StockInfoDAO implements GenericDAO<String,StockInfo> {
		
	@Override
    public StockInfo find(String symbol) {
		if(new SymbolsDAO().findAll().contains(symbol))  {
			return new StockInfo(symbol, generateRandomValueForSymbol(symbol), generateRandomValueForSymbol(symbol));
		}
		else { 
			return null;
		}
    }

	@Override
    public List<StockInfo> findAll() {
    	return null;
    }
    

	/**
	 * Generate a random value for a symbol
	 * @param symbol
	 * @return
	 */
	private String generateRandomValueForSymbol(String symbol) {	
		int symbolSeed = Math.abs(symbol.hashCode()) % 1000;
		double value = Math.random() * (0.1 * symbolSeed) + symbolSeed;
		return String.format("%.5g%n", value);
	}

	@Override
	public String create(StockInfo value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(StockInfo value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String value) {
		// TODO Auto-generated method stub
		
	}
	    
	
    

}
