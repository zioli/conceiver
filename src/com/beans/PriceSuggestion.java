package com.beans;

import java.io.Serializable;
//import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.mappers.MyDoubleDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@XmlRootElement(name = "category")
@XmlType(propOrder={"min", "max", "suggested"})
@JsonIgnoreProperties(value = { "id" })
public class PriceSuggestion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlTransient
	private String id;
	
	@JsonProperty
	@JsonSerialize( using=MyDoubleDeserializer.class)
	private Double min;
	
	@JsonProperty
    @JsonSerialize(using=MyDoubleDeserializer.class)
	private Double max;
	
	@JsonProperty
    @JsonSerialize(using=MyDoubleDeserializer.class)
	private Double suggested;

	public PriceSuggestion() {
	}

	public PriceSuggestion(String category, double min, double max, double suggested) {
		this.id = category;
		this.min = min;
		this.max = max;
		this.suggested = suggested;
	}

	@XmlTransient
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}


	public Double getMax() {
//		DecimalFormat df2 = new DecimalFormat(".##");
		return this.max;
	}

	@XmlElement
	public void setMax(Double max) {
		this.max = max;
	}

	public Double getMin() {
		// return this.min;
//		DecimalFormat df2 = new DecimalFormat(".##");

		return this.min;
	}

	@XmlElement
	public void setMin(Double min) {
		this.min = min;
	}

	public Double getSuggested() {
//		DecimalFormat df2 = new DecimalFormat(".##");

//		return df2.format(this.suggested);
		return this.suggested;
	}

	@XmlElement
	public void setSuggested(Double suggested) {
		this.suggested = suggested;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof PriceSuggestion)) {
			return false;
		} else {
			PriceSuggestion user = (PriceSuggestion) object;

			if (id.equals(user.getId()))
				return true;

		}
		return false;
	}
}