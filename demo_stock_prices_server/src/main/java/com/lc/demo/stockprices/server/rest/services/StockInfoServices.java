package com.lc.demo.stockprices.server.rest.services;

//import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.Status;

import com.lc.demo.stockprices.model.rest.resources.StockInfo;
import com.lc.demo.stockprices.model.rest.resources.Symbols;
//import com.lc.demo.stockprices.server.data.dao.DAOFactory;
import com.lc.demo.stockprices.server.publisher.StockInfoPublisher;
import com.sun.jersey.api.JResponse;
import com.sun.jersey.api.JResponse.JResponseBuilder;

@Produces({ "application/xml", "application/json" })
@Path("stockinfo")
public class StockInfoServices {
	
	//private static List<String> symbols;
	private static StockInfoPublisher publisher;
//	private static DAOFactory daoFactory;
	
	@SuppressWarnings("unchecked")
	public StockInfoServices(){
//		daoFactory = new DAOFactory();
//		symbols = (List<String>)fetchSymbols();
		publisher = new StockInfoPublisher();
	}

	/*
	private List<?> fetchSymbols() {
		return daoFactory.getDAO(Symbols.class.getSimpleName()).findAll();
	}*/
	
	@GET
	@Path("symbols")
	public JResponse<Symbols> getSymbols() {
		return buildResponse(new ResultProvider<Symbols>() {

			@Override
			Symbols getResult() {
				// Wraps the object from the model in a rest object
				return new Symbols(publisher.getSymbols().getSymbols());
			}
		});
	}

	@GET
	@Path("symbols/{symbol}")
	public JResponse<StockInfo> getStockInfo(@PathParam("symbol") final String symbol) {
		return buildResponse(new ResultProvider<StockInfo>() {

			@Override
			StockInfo getResult() {
				if(publisher.getSymbols().getSymbols().contains(symbol)) {
//					com.lc.demo.stockprices.model.StockInfo data = (com.lc.demo.stockprices.model.StockInfo)
//																			daoFactory.getDAO(StockInfo.class.getSimpleName()).find(symbol);
					com.lc.demo.stockprices.model.StockInfo data = publisher.getBoard().getBoard().get(symbol);
					// Wraps the object from the model in a rest object
					StockInfo stockInfo = new StockInfo(data.getSymbol(),data.getAsk(),data.getBid());
					return stockInfo;
				}
				else {
					return null;	
				}
				
			}
		});
	}

	private <T> JResponse<T> buildResponse(ResultProvider<T> resultProvider) {
		JResponseBuilder<T> builder;
		try {
			T result = resultProvider.getResult();
			if(result == null) {
				builder = JResponse.status(Status.NOT_FOUND);
				return builder.build();
			}
			builder = JResponse.ok();
			return builder.entity(result).build();
		} catch (RuntimeException e) {
			// TODO: Log the error
			builder = JResponse.status(Status.INTERNAL_SERVER_ERROR);
			return builder.build();
		}
	}
	
	private static abstract class ResultProvider<T> {
		abstract T getResult();
	}
	
}
