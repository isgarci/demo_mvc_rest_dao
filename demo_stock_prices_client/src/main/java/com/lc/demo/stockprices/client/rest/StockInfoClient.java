package com.lc.demo.stockprices.client.rest;

import java.util.List;
import java.util.ResourceBundle;

import com.lc.demo.stockprices.client.constants.ConfigKeys;
import com.lc.demo.stockprices.model.rest.resources.StockInfo;
import com.lc.demo.stockprices.model.rest.resources.Symbols;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class StockInfoClient {
	
	private static final ResourceBundle rb = ResourceBundle.getBundle(ConfigKeys.RESOURCE_BUNDLE_NAME);
	private static String ENDPOINT;
	private static String DEFAULT_CONTENT_ACCEPT;

	private Client client = Client.create();
	
	public StockInfoClient() {
		setupConfig();
	}
	
	private void setupConfig() {
		ENDPOINT = rb.getString(ConfigKeys.ENDPOINT);
		DEFAULT_CONTENT_ACCEPT = rb.getString(ConfigKeys.DEFAULT_CONTENT_ACCEPT);
	}
	
	public List<String> getSymbols() {
		try {
			WebResource webResource = client.resource(ENDPOINT).path("symbols");
			return webResource.accept(DEFAULT_CONTENT_ACCEPT).get(Symbols.class).getSymbols();
		} catch (UniformInterfaceException e) {
			// TODO: Better error handling. The http response code should be examined
			throw new RuntimeException("An exception was thrown by the API", e);
		}
	}

	public StockInfo getStockInfo(String symbol) {
		try {
			WebResource webResource = client.resource(ENDPOINT).path("symbols");
			webResource = webResource.path(symbol);
			return webResource.accept(DEFAULT_CONTENT_ACCEPT).get(StockInfo.class);
		} catch (UniformInterfaceException e) {
			// TODO: Better error handling. The http response code should be examined
			throw new RuntimeException("An exception was thrown by the API", e);
		}
	}

}