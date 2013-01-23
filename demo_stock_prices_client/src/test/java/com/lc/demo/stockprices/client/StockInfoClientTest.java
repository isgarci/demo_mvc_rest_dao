/**
 * 
 */
package com.lc.demo.stockprices.client;

import com.lc.demo.stockprices.client.rest.StockInfoClient;

import junit.framework.TestCase;

/**
 * @author isa
 *
 */
public class StockInfoClientTest extends TestCase {

	private StockInfoClient stockInfoClient;
	
	/**
	 * @param name
	 */
	public StockInfoClientTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		stockInfoClient = new StockInfoClient();  
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.lc.demo.stockprices.client.rest.StockInfoClient#getSymbols()}.
	 */
	public void testGetSymbols() {
		System.out.println(stockInfoClient.getSymbols()+"\n");
		assertTrue( true );
	}

	/**
	 * Test method for {@link com.lc.demo.stockprices.client.rest.StockInfoClient#getStockInfo(java.lang.String)}.
	 */
	public void testGetStockInfo() {
		System.out.println(stockInfoClient.getStockInfo("Google")+"\n");
		assertTrue( true );
	}

}
