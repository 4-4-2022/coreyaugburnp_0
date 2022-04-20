package com.revature.repository;

import java.util.Set;

import com.revature.model.SecondaryUser;

public interface SecondaryRepository {

	public Set<SecondaryUser>findSecondaryUsers();
	public void save(SecondaryUser secuser);
	
}
