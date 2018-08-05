package com.conceiver;
import org.glassfish.jersey.server.ResourceConfig;

import com.errorhandling.AppExceptionMapper;
import com.errorhandling.GenericExceptionMapper;
import com.errorhandling.NotFoundExceptionMapper;
//import org.codingpedia.demo.rest.errorhandling.GenericExceptionMapper;
//import org.codingpedia.demo.rest.errorhandling.NotFoundExceptionMapper;
//import org.codingpedia.demo.rest.filters.CORSResponseFilter;
//import org.codingpedia.demo.rest.filters.LoggingResponseFilter;
//import org.codingpedia.demo.rest.resource.PodcastLegacyResource;
//import org.codingpedia.demo.rest.resource.PodcastResource;
//import org.glassfish.jersey.jackson.JacksonFeature;
//import org.glassfish.jersey.media.multipart.MultiPartFeature;
//import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Registers the components to be used by the JAX-RS application  
 * 
 * @author ama
 *
 */
public class RestConfig extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/	
	public RestConfig(){
		//register(RequestContextFilter.class);
		//register(PodcastResource.class);
		//register(PodcastLegacyResource.class);
		register(CategoryService.class);
		register(AppExceptionMapper.class);
		register(NotFoundExceptionMapper.class);
		register(GenericExceptionMapper.class);
		//register(LoggingResponseFilter.class);
		//register(CORSResponseFilter.class);
		
		//register features
		//register(JacksonFeature.class);	
		//register(MultiPartFeature.class);
	}
}