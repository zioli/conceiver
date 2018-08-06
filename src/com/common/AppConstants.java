package com.common;

import javax.ws.rs.core.Response;


public class AppConstants {
	
	public static final String API_BASEPATH_MERCADOLIBRE = "https://api.mercadolibre.com";
	public static final String APP_HELP_LINK = "https://github.com/zioli/conceiver/blob/master/README.md";
	
	public static final int GENERIC_APP_ERROR_CODE = 5001;		
	public static final int ERROR_CODE_WHEN_GET_PRICE = 9001;
	public static final int ERROR_CODE_INVALID_URI = 9100;
	public static final int ERROR_CODE_INVALID_CATEGORY = 9101;
	public static final int ERROR_CODE_NOT_FOUND = Response.Status.NOT_FOUND.getStatusCode();
	public static final int ERROR_CODE_ITEMS_NOT_FOUND_FOR_CATEGORY = 9103;
	

	
	public static final String ERROR_GENERIC_ERROR = "Something wrong!";
	public static final String ERROR_ITEMS_NOT_FOUND_FOR_CATEGORY = "It was not found any item for the category";
	public static final String ERROR_EMPTY_JSON = "It was not returned any json for the request.";
	public static final String ERROR_INVALID_URI = "Invalid URI, please check this out!";
	public static final String ERROR_INVALID_CATEGORY = "Invalid Category, please check this out!";
	public static final String NOT_FOUND_ERROR = "Not Found";
	public static final String ERROR_ON_CALL_URI = "Error on call uri";
	
}