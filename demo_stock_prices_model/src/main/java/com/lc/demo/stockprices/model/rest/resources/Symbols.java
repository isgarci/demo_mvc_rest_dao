package com.lc.demo.stockprices.model.rest.resources;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "symbols")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Symbols")
public class Symbols extends com.lc.demo.stockprices.model.Symbols {

	public Symbols() {
		super();
	}
	
	public Symbols(List<String> symbols) {
		super(symbols);
	}	
	
	@Override
	@XmlElement(name = "symbol")
	public List<String> getSymbols() {
		return symbols;
	}
	
	@Override
	public String toString() {
		return "Symbols [symbols=" + symbols + "]";
	}
	
}
