package com.revature.service;

import static org.hamcrest.CoreMatchers.anything;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Product;
import com.revature.model.SecondaryUser;
import com.revature.model.User;
import com.revature.repository.ProductRepository;
import com.revature.repository.ProductRepositoryImpl;
import com.revature.repository.SecondaryRepository;
import com.revature.repository.SecondaryRepositoryImpl;
import com.revature.repository.UserRepository;
import com.revature.repository.UserReposityImpl;

public class UserService {

	
	UserRepository userRepository = new UserReposityImpl();
	Set<User> users = userRepository.findAllUsers();
	
	SecondaryRepository secondRepo = new SecondaryRepositoryImpl();
	Set<SecondaryUser> secondUsers = secondRepo.findSecondaryUsers();
	
	ProductRepository productRepo = new ProductRepositoryImpl();
	Set<Product> products = productRepo.findAllProducts();
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	
	public String[] takeCupcakeInfo(Scanner scanner) {
		String userFlavor = scanner.nextLine();
		String[] flavors = userFlavor.split(",");
		return flavors;
	}
	

//	public Set<User> findCupcakesByFlavor(Scanner scanner){
//		Set<User> retrievedCupcakes = null;
//		String userFlavor = scanner.nextLine();
//		String[] flavors = userFlavor.split(",");
//		retrievedCupcakes = this.userRepository.findCupcakesByFlavor(flavors);
//		//Lets log the retrieved cupcakes
//		logger.info("The retrieved cupcakes are: " + retrievedCupcakes);
//		return retrievedCupcakes;
//	}
	
	public Set<User> findAllUsers(){
		return this.userRepository.findAllUsers();
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public void update(User user) {
		this.userRepository.priceUpdate(user);
	}
	

	public User findUser(String name){
		
		for(User user:users) {
			if(user.getPrimaryName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
		
	}
	
	public SecondaryUser findSecUser(String name){
		
		for(SecondaryUser user:secondUsers) {
			if(user.getSecondaryName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
		
	}
	
public User findUserPass(String name){
		
		for(User user:users) {
			if(user.getPrimaryPassword().equals(name)) {
				return user;
			}
		}
		return null;
		
	}
	
	public SecondaryUser findSecUserPass(String name){
		
		for(SecondaryUser user:secondUsers) {
			if(user.getSecondaryPassword().equals(name)) {
				return user;
			}
		}
		return null;
		
	}
	public SecondaryUser getSecondaryInformation(Scanner scanner) {
		
	SecondaryUser secuser = new SecondaryUser();
	
	
	secuser.setSecondaryId(7);
	System.out.println("Name please:");
	secuser.setSecondaryName(scanner.nextLine());
	System.out.println("Password please: ");
	secuser.setSecondaryPassword(scanner.nextLine());
	System.out.println("How much would you like to transfer:");
	float amount = scanner.nextFloat();
	secuser.setSecondaryBalance(amount);
	
	
	primaryTransfer(amount);
	System.out.println("Please Sign In");
	
	
	return secuser;
	
}
	
	
	public float orderProduct(int selectedProductNumber) {
		List<Product> productList = new ArrayList<>();
		
		float price = productList.get(selectedProductNumber).getPrices();
		
		return price;
	}
	
	public float primaryTransfer(float amount) {
		
		return amount;
	}
	
	public User updateTranfer(User currentUser) {
		float primeGive = currentUser.getPrimaryBalance();
//		float secRec = primaryTransfer(amount);
		
//		float newBalance = primeGive - secRec;
		

//		currentUser.setPrimaryBalance(newBalance);
		
		return currentUser;
	}
	
	public void save(SecondaryUser secuser) {
		this.secondRepo.save(secuser);
	}

	public User getPrimaryInfo(Scanner scanner) {
		
		User user = new User();
		System.out.println("Please Choose Account \n1) Primary Account");
		user.setUserId(8);
		scanner.nextLine();
		System.out.println("Name please:");
		user.setPrimaryName(scanner.nextLine().trim());
		System.out.println("Password please: ");
		user.setPrimaryPassword(scanner.nextLine().trim());
		System.out.println("How much would you like to transfer towards your balance: ");
		user.setPrimaryBalance(scanner.nextFloat());
		user.setHasSecondaryUser(true);
		user.setAdmin(false);
		user.setEmployee(false);
	
		return user;
	}
	
	public User userOrder(User currentUser, float order) {
		
		float price = currentUser.getPrimaryBalance();
		float amount = price - order;
		currentUser.setPrimaryBalance(amount);
		
		return currentUser;
		
	}
	
	
	
	
}
