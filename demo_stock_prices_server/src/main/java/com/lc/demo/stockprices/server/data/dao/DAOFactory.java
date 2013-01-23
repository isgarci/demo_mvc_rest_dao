package com.lc.demo.stockprices.server.data.dao;

import java.util.ResourceBundle;
import org.apache.log4j.Logger;

import com.lc.demo.stockprices.server.data.constants.ConfigKeys;


/**
 * @author isa
 *
 * Stock Info Service Data Object. 
 * Loads the Service Data Object configured in the properties file
 */
public class DAOFactory {

	private static final Logger logger = Logger.getLogger("DAOFactory");
	private static final ResourceBundle rb = ResourceBundle.getBundle(ConfigKeys.RESOURCE_BUNDLE_NAME); 	
	private static String DAO_LOCATION;
	private static String DAO_SUFFIX;
	
	public DAOFactory(){
		setupConfig();
	}

	private  void setupConfig() {
		DAO_LOCATION = rb.getString(ConfigKeys.DAO_LOCATION);
		DAO_SUFFIX = rb.getString(ConfigKeys.DAO_SUFFIX);
	}
		
	@SuppressWarnings("unchecked")
	public <K,T> GenericDAO<K,T> getDAO(String pojoName) {
		
		try {
			return (GenericDAO<K,T>) Class.forName(DAO_LOCATION+"."+pojoName+DAO_SUFFIX).newInstance();
		} catch (Exception e) {
			logger.error("Error getting DAO for :"+ pojoName);
			e.printStackTrace();
			return null;
		} 
	}
}
