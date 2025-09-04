package com.iamsystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {

	private String token;

   // private long expiresIn;

    public String getToken() {
        return token;
    }

	public void setToken(String token) {
		this.token = token;
	}
}
