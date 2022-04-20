package com.revature.model;

import java.util.Objects;

public class SecondaryUser {

	private int secondaryId;
	private String secondaryName;
	private String secondaryPassword;
	private float secondaryBalance;
	
	
	public SecondaryUser() {
		
	}
	

	
	//if secondary id exist
	public SecondaryUser(int secondaryId, String secondaryName, String secondaryPassword, float secondaryBalance) {
		super();
		this.secondaryId = secondaryId;
		this.secondaryName = secondaryName;
		this.secondaryPassword = secondaryPassword;
		this.secondaryBalance = secondaryBalance;
	}

	public int getSecondaryId() {
		return secondaryId;
	}

	public void setSecondaryId(int secondaryId) {
		this.secondaryId = secondaryId;
	}

	public String getSecondaryName() {
		return secondaryName;
	}

	public void setSecondaryName(String secondaryName) {
		this.secondaryName = secondaryName;
	}

	public String getSecondaryPassword() {
		return secondaryPassword;
	}

	public void setSecondaryPassword(String secondaryPassword) {
		this.secondaryPassword = secondaryPassword;
	}

	public float getSecondaryBalance() {
		return secondaryBalance;
	}

	public void setSecondaryBalance(float secondaryBalance) {
		this.secondaryBalance = secondaryBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(secondaryBalance, secondaryId, secondaryName, secondaryPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecondaryUser other = (SecondaryUser) obj;
		return Float.floatToIntBits(secondaryBalance) == Float.floatToIntBits(other.secondaryBalance)
				&& secondaryId == other.secondaryId && Objects.equals(secondaryName, other.secondaryName)
				&& Objects.equals(secondaryPassword, other.secondaryPassword);
	}

	@Override
	public String toString() {
		return "SecondaryUser [secondaryId=" + secondaryId + ", secondaryName=" + secondaryName + ", secondaryPassword="
				+ secondaryPassword + ", secondaryBalance=" + secondaryBalance + "]";
	}
	
	
	
	
	
}
