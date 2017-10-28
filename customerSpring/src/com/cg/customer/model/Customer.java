package com.cg.customer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
@NamedQueries(@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"))

@NamedQuery(name = "getCustomerIds", query = "SELECT custId FROM Customer cust") 
public class Customer {

	@Id
	@NotNull//used for int values
	@Min(value=0, message="Can not be negative")
	private int custId;
	
	@NotEmpty
	@Pattern(regexp="[A-Z].*",message="Should start with capital letter")
	private String custName;
	
	@NotEmpty(message="cant be null")//used for string values
	@Length(min=10,max=10,message="enter a valid number")
	//@Min(value=3,message="Please enter mobile number")
	private String mobile;
	
	@NotEmpty(message="plz enter email id")
	private String email;
	
	@NotNull(message="plz enter Birthdate")
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date birthDate;
	
	
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
