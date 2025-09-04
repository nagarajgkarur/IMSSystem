package com.iamsystem.payload;

import java.util.List;

public class CelPayload {
	
	private String displayName;
	private List<CelMembers> members;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public List<CelMembers> getMembers() {
		return members;
	}
	public void setMembers(List<CelMembers> members) {
		this.members = members;
	}
	@Override
	public String toString() {
		return "CelPayload [displayName=" + displayName + ", members=" + members + "]";
	}

}
