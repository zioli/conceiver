package com.conceiver;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "category")
@XmlType(propOrder={"min", "max", "suggested"})
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private int min;
	private int max;
	private int suggested;

	public Category() {
	}

	public Category(String category, int min, int max, int suggested) {
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


	public int getMax() {
//		DecimalFormat df2 = new DecimalFormat(".##");
		return this.max;
	}

	@XmlElement
	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		// return this.min;
//		DecimalFormat df2 = new DecimalFormat(".##");

		return this.min;
	}

	@XmlElement
	public void setMin(int min) {
		this.min = min;
	}

	public int getSuggested() {
//		DecimalFormat df2 = new DecimalFormat(".##");

//		return df2.format(this.suggested);
		return this.suggested;
	}

	@XmlElement
	public void setSuggested(int suggested) {
		this.suggested = suggested;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof Category)) {
			return false;
		} else {
			Category user = (Category) object;

			if (id.equals(user.getId()))
				return true;

		}
		return false;
	}
}