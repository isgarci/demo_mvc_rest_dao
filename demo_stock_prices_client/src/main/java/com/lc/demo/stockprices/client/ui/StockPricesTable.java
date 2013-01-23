package com.lc.demo.stockprices.client.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.EventObject;
import java.util.ResourceBundle;

import com.lc.demo.stockprices.client.constants.ConstantLabelsKeys;
import com.lc.demo.stockprices.client.constants.ConstantStylesDef;
import com.lc.demo.stockprices.client.controller.DataManager;
import com.lc.demo.stockprices.client.events.StockPricesEventListener;
import com.lc.demo.stockprices.model.StockInfo;

/**
 * User: isa
 * Date: 26/11/12
 * Time: 02:08 PM
 * GUI Class to organize the layout and visualize contents of the stock prices.
 */
public class StockPricesTable extends Scene implements StockPricesEventListener {
//implements ListChangeListener<StockInfo>, StockPricesEventListener {

	private TableView<StockInfo> table;
	private DataManager dataManager; 
	
    public StockPricesTable(Parent parent, ResourceBundle resourceBundle) {

        super(parent);
        dataManager = new DataManager();
        dataManager.addEventListener(this);
        //dataManager.loadData();
        // TODO: activate this: getStylesheets().add("styles.css");        
        ((StackPane)parent).getChildren().add(configLayout(parent, resourceBundle));
    }
    
    public StackPane configLayout(Parent parent, ResourceBundle rb) {
    	StackPane paneLayout = new StackPane();
        table = new TableView<StockInfo>();

        final Label label = new Label(rb.getString(ConstantLabelsKeys.TITLE));
        label.setFont(new Font(ConstantStylesDef.DEFAULT_FONT_STYLE, ConstantStylesDef.DEFAULT_FONT_SIZE));

        TableColumn symbolCol = new TableColumn(rb.getString(ConstantLabelsKeys.SYMBOL_HEADER));
        symbolCol.setCellValueFactory(new PropertyValueFactory<StockInfo, String>("symbol"));
        
        TableColumn bidCol = new TableColumn(rb.getString(ConstantLabelsKeys.BID_HEADER));
        bidCol.setCellValueFactory(new PropertyValueFactory<StockInfo, String>("bid"));

        TableColumn askCol = new TableColumn(rb.getString(ConstantLabelsKeys.ASK_HEADER));
        askCol.setCellValueFactory(new PropertyValueFactory<StockInfo, String>("ask"));

        table.setItems(dataManager.getData());
        table.getColumns().addAll(symbolCol, bidCol, askCol);

        final VBox vbox = new VBox();

        vbox.setSpacing(ConstantStylesDef.CELL_SPACING);
        vbox.setPadding(new Insets(ConstantStylesDef.PADDING_TOP, ConstantStylesDef.PADDING_LEFT,
                                   ConstantStylesDef.PADDING_RIGHT, ConstantStylesDef.PADDING_BOTTOM));
        
        vbox.getChildren().addAll(label, table);
                
        paneLayout.getChildren().addAll(vbox);
        
        //dataManager.getData().addListener(this);
        return paneLayout;
        
    }

    /*
	public void onChanged(ListChangeListener.Change<? extends StockInfo> arg0) {	
		System.out.println("************** - onChanged Table 1");
		table.setItems(dataManager.getData());
	}*/

	public void handleStockPricesEvent(EventObject e) {
		table.setItems(dataManager.getData());
	}
}
