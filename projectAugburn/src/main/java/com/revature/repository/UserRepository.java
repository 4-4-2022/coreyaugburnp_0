package com.revature.repository;

import java.util.Set;

import com.revature.model.User;

public interface UserRepository {

	public Set<User> findAllUsers();
	public void save(User user);
	public void update(User user);
	public void delete(User user);
//	public void primaryTransferUpdate(User user);
	public void priceUpdate(User user);
}
