package com.iamsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_to_role")
public class UserToRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String roleName;
    private String isSubscribed;
    private String roleDisplayName;
    private String loginId;

    // Constructor
    public UserToRoles(String roleName, String isSubscribed, String roleDisplayName, String loginId) {
        this.roleName = roleName;
        this.isSubscribed = isSubscribed;
        this.roleDisplayName = roleDisplayName;
        this.loginId = loginId;
    }

    public UserToRoles() {
       
    }

    // Getters and Setters
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(String isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public String getRoleDisplayName() {
        return roleDisplayName;
    }

    public void setRoleDisplayName(String roleDisplayName) {
        this.roleDisplayName = roleDisplayName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    // Override toString() for easier representation
    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", isSubscribed='" + isSubscribed + '\'' +
                ", roleDisplayName='" + roleDisplayName + '\'' +
                ", loginId='" + loginId + '\'' +
                '}';
    }
}
