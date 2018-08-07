package com.conceiver;

import java.text.DecimalFormat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import org.json.JSONArray;
import org.json.JSONObject;

import com.beans.PriceSuggestion;
import com.common.AppConstants;
import com.errorhandling.AppException;

public class CategoryDAO {
	
	/**
	 * TODO Documentation
	 * @param category
	 * @return
	 * @throws AppException
	 */
	public PriceSuggestion getPrices(String category) throws AppException{
		
		String site = category.substring(0, 3).toUpperCase();

		

		String lower_price = getPrice(site, category, true);
		String higher_price = getPrice(site, category, false);
		//double suggested = Math.round(((lower_price+higher_price)/2));
		
		
		if (lower_price.equals("") || higher_price.equals(""))
			throw new AppException(AppConstants.ERROR_CODE_NOT_FOUND, 
					AppConstants.ERROR_CODE_WHEN_GET_PRICE,
					AppConstants.NOT_FOUND_ERROR, 
					AppConstants.ERROR_CODE_WHEN_GET_PRICE + " category ["+category+"] lower ["+lower_price +"] higher : [" + higher_price+ "]", 
					AppConstants.APP_HELP_LINK);
	
		
		
		double l_p = Double.parseDouble(lower_price);
		double h_p = Double.parseDouble(higher_price);
		
		DecimalFormat formater = new DecimalFormat("##.00");
		
		//PriceSuggestion cat = new PriceSuggestion(category, l_p, h_p, formater.format((l_p+h_p)/2).replace(",",".") );
		PriceSuggestion cat = new PriceSuggestion(category, l_p, h_p, ((l_p+h_p)/2) );
		
		return cat;
	}

//	public static boolean isNumeric(String numero)
//	{
//		if (numero.trim().isEmpty())
//			return false;
//		return numero.trim().matches("^-?\\d*\\.?\\d*$");  
//	}
	
	/**
	 * TODO documentation
	 * @param site
	 * @param category
	 * @param lower
	 * @return
	 * @throws AppException
	 */
	public String getPrice(String site, String category, boolean lower) throws AppException {
	
		if (category == null || category.trim().isEmpty())
			throw new AppException(AppConstants.ERROR_CODE_NOT_FOUND, 
					AppConstants.ERROR_CODE_INVALID_CATEGORY,
					AppConstants.NOT_FOUND_ERROR, 
					AppConstants.ERROR_INVALID_CATEGORY, 
					AppConstants.APP_HELP_LINK);
		
		String sort="price_desc";
		
		if (lower)
			sort="price_asc";
			
		String uri = AppConstants.API_BASEPATH_MERCADOLIBRE + "/sites/" + site + "/search?category=" + category.toUpperCase().trim() 
				+ "&power_seller=yes&buying_mode=buy_it_now&sort="+sort+"&limit=1";

		JSONObject json = get(uri);
		
		if (json == null)
			throw new AppException(AppConstants.ERROR_CODE_NOT_FOUND, 
					               AppConstants.ERROR_CODE_WHEN_GET_PRICE, 
					               AppConstants.ERROR_EMPTY_JSON,
					               "uri [" +uri+"]" ,
					               AppConstants.APP_HELP_LINK);
		
		JSONArray result = json.getJSONArray("results");
		
		if (result == null || result.length() == 0)
			throw new AppException(AppConstants.ERROR_CODE_NOT_FOUND, 
					               AppConstants.ERROR_CODE_ITEMS_NOT_FOUND_FOR_CATEGORY,
					               AppConstants.ERROR_ITEMS_NOT_FOUND_FOR_CATEGORY,
					               AppConstants.ERROR_ITEMS_NOT_FOUND_FOR_CATEGORY + "[" + category + "]",
					               AppConstants.APP_HELP_LINK);
		
		JSONObject item = (JSONObject) result.get(0);
		
		String price = item.get("price").toString();
		
		if (price == null)
			price = "";
		
		return price.trim().toUpperCase().replace(",",".").replace("[A-Z]", "");
	}



	
	
	private JSONObject get(String uri) throws AppException {
		if (uri == null || uri.trim().isEmpty())
			throw new AppException(AppConstants.ERROR_CODE_NOT_FOUND, 
					               AppConstants.ERROR_CODE_INVALID_URI,
					               AppConstants.NOT_FOUND_ERROR, 
					               AppConstants.ERROR_INVALID_URI, 
					               AppConstants.APP_HELP_LINK);

		Client client = ClientBuilder.newClient();
		WebTarget resource = client.target(uri);
		Builder request = resource.request();
		request.accept(MediaType.APPLICATION_JSON);
		Response response = request.get();

		if (response.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
			JSONObject json = new JSONObject(response.readEntity(String.class));
			return json;

		} else {

			throw new AppException(response.getStatus(), 
					               AppConstants.GENERIC_APP_ERROR_CODE,
					               response.readEntity(String.class), 
					               AppConstants.ERROR_ON_CALL_URI + " [" + uri + "]",
					               AppConstants.APP_HELP_LINK);
		}
	}

}
