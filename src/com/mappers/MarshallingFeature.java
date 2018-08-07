package com.mappers;

//import com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper;
//import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;

import org.glassfish.jersey.internal.InternalProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper;
import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

public class MarshallingFeature implements Feature {

    private final static String JSON_FEATURE = MarshallingFeature.class.getSimpleName();

    @Override
    public boolean configure(FeatureContext context) {

      context.register(JsonParseExceptionMapper.class);
      context.register(JsonMappingExceptionMapper.class);
      context.register(JacksonJsonProviderCustom.class, MessageBodyReader.class, MessageBodyWriter.class);

      final Configuration config = context.getConfiguration();
      // Disables discoverability of org.glassfish.jersey.jackson.JacksonFeature
      context.property(
          PropertiesHelper.getPropertyNameForRuntime(InternalProperties.JSON_FEATURE,
                                                     config.getRuntimeType()), JSON_FEATURE);

      return true;
    }
}