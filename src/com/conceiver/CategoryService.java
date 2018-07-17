package com.conceiver;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/categories")
public class CategoryService {
	
  // UserDao userDao = new UserDao();
   //private static final String SUCCESS_RESULT="<result>success</result>";
   //private static final String FAILURE_RESULT="<result>failure</result>";


   @GET
   @Path("/prices")
   //@Produces(MediaType.APPLICATION_XML)
   @Produces(MediaType.APPLICATION_JSON)
   public List<Category> getCategory(){
	   
	  ArrayList<Category> listCategories = new ArrayList<Category>();
	  listCategories.add(new Category("MLA1234", 10.5, 20.5, 15.25));
      return listCategories;
   }

   @GET
   @Path("/{ID}/prices")
   @Produces(MediaType.APPLICATION_JSON)
   public Category getCategory(@PathParam("ID") String id){
      return new Category(id, 10.5, 20.5, 15.25);
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public String root(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
   
   @OPTIONS
   @Path("/prices")
   @Produces(MediaType.APPLICATION_JSON)
   public String getOptions(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
    

}