package com.revature.model;

import java.util.Objects;
import java.util.Scanner;

public class User{

	private int userId;
	private String primaryName;
	private String primaryPassword;
	private float primaryBalance;
	private boolean hasSecondaryUser;
	private boolean isAdmin;
	private boolean isEmployee;
	
	public User() {
		
	}
				//change and threw secUser in 
	public User(int userId, String primaryName, String primaryPassword, float primaryBalance, boolean hasSecondaryUser,  boolean isAdmin, boolean isEmployee) {
		super();
		this.userId = userId;
		this.primaryName = primaryName;
		this.primaryPassword = primaryPassword;
		this.primaryBalance = primaryBalance;
		this.hasSecondaryUser = hasSecondaryUser;
		this.isAdmin = isAdmin;
		this.isEmployee = isEmployee;
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPrimaryName() {
		return primaryName;
	}
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	public String getPrimaryPassword() {
		return primaryPassword;
	}
	public void setPrimaryPassword(String primaryPassword) {
		this.primaryPassword = primaryPassword;
	}
	public float getPrimaryBalance() {
		return primaryBalance;
	}
	public void setPrimaryBalance(float primaryBalance) {
		this.primaryBalance = primaryBalance;
	}
	public boolean isHasSecondaryUser() {
		return hasSecondaryUser;
	}
	public void setHasSecondaryUser(boolean hasSecondaryUser) {
		this.hasSecondaryUser = hasSecondaryUser;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isEmployee() {
		return isEmployee;
	}
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hasSecondaryUser, isAdmin, isEmployee, primaryBalance, primaryName, primaryPassword,
				userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return hasSecondaryUser == other.hasSecondaryUser && isAdmin == other.isAdmin && isEmployee == other.isEmployee
				&& Float.floatToIntBits(primaryBalance) == Float.floatToIntBits(other.primaryBalance)
				&& Objects.equals(primaryName, other.primaryName)
				&& Objects.equals(primaryPassword, other.primaryPassword) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", primaryName=" + primaryName + ", primaryPassword=" + primaryPassword
				+ ", primaryBalance=" + primaryBalance + ", hasSecondaryUser=" + hasSecondaryUser + ", isAdmin="
				+ isAdmin + ", isEmployee=" + isEmployee + "]";
	}
	
	
	
	
}
