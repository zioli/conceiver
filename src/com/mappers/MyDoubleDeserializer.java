package com.mappers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public  class MyDoubleDeserializer extends JsonSerializer<Double> {

	@Override
	public void serialize(Double arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
		
		
		DecimalFormat formater = new DecimalFormat("#0.##");
		
		BigDecimal d = new BigDecimal(arg0);
        arg1.writeNumber(formater.format(d).replaceAll(",", "."));
	}

}