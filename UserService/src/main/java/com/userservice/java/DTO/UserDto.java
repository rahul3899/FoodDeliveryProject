package com.userservice.java.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserDto {
	@NotNull
	private String name;
	@NotNull
	private String mail;
	@NotNull()
	@Length(min = 10)
	private String contactNumber;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	@Min(1000)
	private Long balance;
	@NotNull
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserDto(String name, String mail, String contactNumber, String username,
			String password, Long balance,String address) {
		
		this.name = name;
		this.mail = mail;
		this.contactNumber = contactNumber;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.address = address;
	}
	
	public UserDto() {
		
	}

}
