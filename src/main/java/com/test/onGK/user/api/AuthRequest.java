package com.test.onGK.user.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
 
import org.hibernate.validator.constraints.Length;
 
public class AuthRequest {
    @NotNull @Email @Length(min = 5, max = 50)
    private String email;
     
    @NotNull @Length(min = 5, max = 10)
    private String password;

	public AuthRequest(@NotNull @Email @Length(min = 5, max = 50) String email,
			@NotNull @Length(min = 5, max = 10) String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public AuthRequest() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
   
}