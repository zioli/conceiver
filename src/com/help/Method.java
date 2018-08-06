package com.help;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "method")
@XmlType(propOrder={"method", "uri", "description", "example", "answer"})
public class Method {

	String method;
	String uri;
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
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUri() {
		return uri;
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
