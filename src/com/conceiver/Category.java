package com.conceiver;  

import java.io.Serializable;  

import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
 

@XmlRootElement(name = "category") 
public class Category implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private String id; 
   private double min; 
   private double max;
   private double suggested;
 
   public Category(){} 
    
   public Category(String category, double min, double max, double suggested){  
      this.id = category; 
      this.min = min;
      this.max = max;
      this.suggested = suggested;
   }  
   

   @XmlTransient
   public String  getId() { 
      return id; 
   }  
   
   public void setId(String id) { 
      this.id = id; 
   } 
   
   public double getMax() { 
      return this.max; 
   } 
   
   @XmlElement
   public void setMax(double max) { 
      this.max = max; 
   } 
   public double getMin() { 
      return this.min; 
   } 
   @XmlElement 
   public void setMin(double min) { 
      this.min = min; 
   }   
   
   public double getSuggested() { 
      return this.suggested; 
   } 
   
   @XmlElement 
   public void setSuggested(double suggested) { 
      this.suggested = suggested; 
   }   
	   
   @Override
   public boolean equals(Object object){
      if(object == null){
         return false;
      }else if(!(object instanceof Category)){
         return false;
      }else {
         Category user = (Category)object;
         
         if(id.equals(user.getId()))
        	 return true;
		
      }
      return false;
   }	
} 