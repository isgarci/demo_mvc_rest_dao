package com.lc.demo.stockprices.client.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockPricesEventSource {
	
  private List<StockPricesEventListener> listeners = new ArrayList<StockPricesEventListener>();
  public synchronized void addEventListener(StockPricesEventListener listener)  {
    listeners.add(listener);
  }
  public synchronized void removeEventListener(StockPricesEventListener listener)   {
    listeners.remove(listener);
  }

  protected synchronized void fireEvent() {
    StockPricesEvent event = new StockPricesEvent(this);
    Iterator<StockPricesEventListener> i = listeners.iterator();
    while(i.hasNext())  {
      ((StockPricesEventListener) i.next()).handleStockPricesEvent(event);
    }
  }
}
