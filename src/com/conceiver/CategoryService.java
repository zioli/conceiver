package com.conceiver;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.errorhandling.AppException;
import com.help.Help;
import com.help.Method;


@Path("/categories")
public class CategoryService {
	

//   @GET
//   @Path("/prices")
//   //@Produces(MediaType.APPLICATION_XML)
//   @Produces(MediaType.APPLICATION_JSON)
//   public List<Category> getCategory() throws AppException{
//	 
//	   throw new AppException(1000, 1000, "Something wrong here", "just trying", "www.google.com");
//   }
   
   
//   @GET
//   @Path("/prueba")
//   //@Produces(MediaType.APPLICATION_XML)
//   @Produces(MediaType.APPLICATION_JSON)
//   public String getTested() throws AppException{
//	   Client client = ClientBuilder.newClient();
//	   
//	   WebTarget resource = client.target("https://api.mercadolibre.com/sites/MLA/search?category=MLA5726&sort=price_asc&limit=1");
//	   
//	   Builder request = resource.request();
//	   
//	   request.accept(MediaType.APPLICATION_JSON);
//	   
//	   Response response = request.get();
//	   
//	   JSONObject json = new JSONObject(response.readEntity(String.class));
//			   
//	   JSONArray result =  json.getJSONArray("results");
//	   
//	   String ret = "";
//	   
//	   JSONObject item = (JSONObject) result.get(0);
//	   ret += "[" + item.get("price") + "]";
//	   ret += "[" + item.get("title") + "]";
//	   
//	   return ret;
////	   ArrayList<Category> listCategories = new ArrayList<Category>();
////	   listCategories.add(new Category("MLA1234", 10.5, 20.5, 15.25));
////	   return listCategories;
//   }

   @GET
   @Path("/{ID}/prices")
   @Produces(MediaType.APPLICATION_JSON)
   public Category getCategory(@PathParam("ID") String id) throws AppException{
	   CategoryDAO dao = new CategoryDAO();
	   return dao.getPrices(id);
   }


   @OPTIONS
   @Path("/{ID}/prices")
   @Produces(MediaType.APPLICATION_JSON)
   public Help getHelp(){
	   
	   Help help = new Help();
	   
	   Method get = new Method();
	   get.setMethod("GET");
	   get.setDescription("It gonna get the lower price, higher price and suggested price for a category.");
	   get.setExample("/MLA5726:/prices");
	   get.setAnswer("{\"lower\" : 1, \"higher\" : 5, \"suggeste\" : 4 }");
	   
	   
	   Method option = new Method();
	   option.setMethod("OPTION");
	   option.setDescription("A little help about the resource");
	   option.setExample("/MLA5726:/prices");
	   option.setAnswer("json with methods descriptions");
	   
	   
	   ArrayList <Method> methods = new ArrayList<Method>();
	   methods.add(get);
	   methods.add(option);
	   
	   
	   help.setName("/:CATEGORY:/prices");
	   help.setDescription("It returns a price sugestion for the :CATEGORY:. It is based on its lower and higher price.");
	   help.setMethods(methods);
	   

	   return help;
   }
    

}