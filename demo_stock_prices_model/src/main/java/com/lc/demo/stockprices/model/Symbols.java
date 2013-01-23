package com.lc.demo.stockprices.model;

import java.util.ArrayList;
import java.util.List;

public class Symbols {

	protected List<String> symbols = new ArrayList<String>();
	
	public Symbols() {
	}

	public Symbols(List<String> symbols) {
		this.symbols = symbols;
	}

	public List<String> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<String> symbols) {
		this.symbols = symbols;
	}

}
