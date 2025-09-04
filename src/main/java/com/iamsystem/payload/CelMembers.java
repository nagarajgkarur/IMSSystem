package com.iamsystem.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CelMembers {
	
	private String display;
	private String type;
	private String value;
	@JsonProperty("$ref")
	private String ref;
	
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getref() {
		return ref;
	}
	public void set$ref(String ref) {
		this.ref = ref;
	}
	@Override
	public String toString() {
		return "CelMembers [display=" + display + ", type=" + type + ", value=" + value + ", ref=" + ref + "]";
	}
	
}
