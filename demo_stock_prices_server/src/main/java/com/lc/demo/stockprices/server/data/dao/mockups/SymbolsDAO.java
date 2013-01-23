package com.lc.demo.stockprices.server.data.dao.mockups;

import java.util.Arrays;
import java.util.List;

import com.lc.demo.stockprices.server.data.dao.GenericDAO;

public class SymbolsDAO implements GenericDAO<String,String>{

	private static final List<String> SYMBOLS = Arrays.asList("IBM", "Google", "Microsoft", "Samsung", "Sony");
	
	@Override
	public String find(String symbol) {
		if(SYMBOLS.contains(symbol))  {
			return symbol;
		}
		return null;
	}

	@Override
	public List<String> findAll() {
		return SYMBOLS;
	}

	@Override
	public String create(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
