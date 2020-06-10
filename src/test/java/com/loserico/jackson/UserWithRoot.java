package com.loserico.jackson;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class UserWithRoot {
	public int id;
	public String name;

	public UserWithRoot(int id, String name) {
		this.id = id;
		this.name = name;
	}

}