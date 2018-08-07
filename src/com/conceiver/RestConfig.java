package com.conceiver;
import org.glassfish.jersey.server.ResourceConfig;

//import com.beans.JacksonJsonProviderAtRest;
import com.mappers.MarshallingFeature;
import com.errorhandling.AppExceptionMapper;
import com.errorhandling.GenericExceptionMapper;
import com.errorhandling.NotFoundExceptionMapper;

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

		register(CategoryService.class);
		register(AppExceptionMapper.class);
		register(NotFoundExceptionMapper.class);
		register(GenericExceptionMapper.class);
		register(MarshallingFeature.class);
	}
}