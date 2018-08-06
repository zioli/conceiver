package com.errorhandling;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.NotFoundException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.beanutils.BeanUtils;

import com.common.AppConstants;


@XmlRootElement
@XmlType(propOrder={"status", "code", "message","details","link"})
public class ErrorMessage {
	
	@XmlElement(name = "status")
	int status;
	
	@XmlElement(name = "code")
	int code;
	
	@XmlElement(name = "message")
	String message;
		
	@XmlElement(name = "link")
	String link;

	@XmlElement(name = "details")
	String details;	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails (String details) {
		this.details = details;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public ErrorMessage( AppException ex){
		try {
			BeanUtils.copyProperties(this, ex);
		} catch (IllegalAccessException e) {
			this.code = AppConstants.ERROR_CODE_NOT_FOUND;
			this.status = AppConstants.GENERIC_APP_ERROR_CODE;
			this.message = "IllegalAccessException";
			this.details = e.getMessage();
			this.link = AppConstants.APP_HELP_LINK;
			
		} catch (InvocationTargetException e) {
			
			this.code = AppConstants.ERROR_CODE_NOT_FOUND;
			this.status = AppConstants.GENERIC_APP_ERROR_CODE;
			this.message = "InvocationTargetException";
			this.details = e.getMessage();
			this.link = AppConstants.APP_HELP_LINK;
		}
	}
	
	public ErrorMessage(NotFoundException ex){
		
		this.status = AppConstants.ERROR_CODE_NOT_FOUND;
		this.message = ex.getMessage();
		this.details = "Resource not found.";
		this.link = AppConstants.APP_HELP_LINK;		
	}

	public ErrorMessage() {}
}