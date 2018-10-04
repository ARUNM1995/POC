package com.jspider.poc.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PROJECT_REGISTER")
public class RegisterDto implements Serializable {

	@Id
	@GenericGenerator(name = "any", strategy = "increment")
	@GeneratedValue(generator="any")
	private Long id;
	private String userName;
	private String password;
	private Long mobileNumber;
	private String country;
	public RegisterDto() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "RegisterDto [id=" + id + ", userName=" + userName + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", country=" + country + "]";
	}
}
