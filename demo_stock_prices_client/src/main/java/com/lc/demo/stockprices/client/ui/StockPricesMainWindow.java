package com.lc.demo.stockprices.client.ui;

/**
 * User: isa
 * Date: 26/11/12
 * Time: 02:04 PM
 * GUI Class representing the Main Window to show info on stock prices.
 */

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ResourceBundle;

import com.lc.demo.stockprices.client.constants.ConstantLabelsKeys;


public class StockPricesMainWindow extends Application {

	private static final ResourceBundle rb = ResourceBundle.getBundle(ConstantLabelsKeys.RESOURCE_BUNDLE_NAME); 	
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(rb.getString(ConstantLabelsKeys.TITLE));
        StackPane root = new StackPane();
        primaryStage.setScene(new StockPricesTable(root,rb));
        primaryStage.show();

    }
}
