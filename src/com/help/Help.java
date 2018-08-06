package com.help;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.errorhandling.ErrorMessage;

@XmlRootElement(name = "resource")
@XmlType(propOrder={"name", "description", "methods","references", "answer_in_case_of_error"})
public class Help {
	String name;
	String description;
	ArrayList <Method> methods;
	ArrayList<String> references;
	ErrorMessage answer_in_case_of_error;
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setReferences(ArrayList<String> references) {
		this.references = references;
	}
	public ArrayList<String> getReferences() {
		return references;
	}
	
	
	@XmlElement
	public void setAnswer_in_case_of_error(ErrorMessage answer_in_case_of_error) {
		this.answer_in_case_of_error = answer_in_case_of_error;
	}
	public ErrorMessage getAnswer_in_case_of_error() {
		return answer_in_case_of_error;
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
