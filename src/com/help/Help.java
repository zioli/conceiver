package com.help;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resource")
public class Help {
	String name;
	String description;
	ArrayList <Method> methods;
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Method> getMethods() {
		return methods;
	}
	
	@XmlElement
	public void setMethods(ArrayList<Method> methods) {
		this.methods = methods;
	}
	

	
	
}
