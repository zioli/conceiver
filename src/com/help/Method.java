package com.help;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "method")
public class Method {

	String method;
	String example;
	String description;
	String answer;
	
	public String getMethod() {
		return method;
	}
	
	@XmlElement
	public void setMethod(String method) {
		this.method = method;
	}
	public String getExample() {
		return example;
	}
	
	@XmlElement
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswer() {
		return answer;
	}
	
	@XmlElement
	public void setExample(String example) {
		this.example = example;
	}
	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
