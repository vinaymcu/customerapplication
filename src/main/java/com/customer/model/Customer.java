package com.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Customer {

	public Customer(){

	}
	public Customer(long id, String firstName, String lastName, String email, String gender, String dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
	}

	@JsonProperty("id")
	private long id;

	@NotNull(message = "First Name cannot be null")
	@JsonProperty("first_name")
	private String firstName;
	@NotNull(message = "Last Name cannot be null")
	@JsonProperty("last_name")
	private String lastName;
	@NotNull(message = "Email cannot be null")
	@JsonProperty("email")
	private String email;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("dob")
	private String dob;
}