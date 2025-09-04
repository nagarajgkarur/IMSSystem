package com.iamsystem.hive9.response;

import java.util.List;

public class UserTeams {

	private String userId;
	List<Long> teamIds;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Long> getTeamIds() {
		return teamIds;
	}
	public void setTeamIds(List<Long> teamIds) {
		this.teamIds = teamIds;
	}


}
