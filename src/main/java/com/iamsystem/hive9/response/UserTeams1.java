package com.iamsystem.hive9.response;

import java.util.List;

public class UserTeams1 {
	private String userId;
	List<String> teamIds;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getTeamIds() {
		return teamIds;
	}
	public void setTeamIds(List<String> teamIds) {
		this.teamIds = teamIds;
	}
}
