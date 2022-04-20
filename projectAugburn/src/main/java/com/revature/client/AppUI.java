package com.revature.client;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import org.hamcrest.core.IsNull;
import org.postgresql.xml.NullErrorHandler;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserReposityImpl;

public class AppUI {
	
	UserRepository userRepository = new UserReposityImpl();//.getCupcakeRepository();
	Set<User> users = userRepository.findAllUsers();
	
	public static void printWelcomeMenu() {
		System.out.println("Hello! How may I be of service \n"
				+ "1) Register  \n2) Sign In"
				+ " \n3) View Our Menu"
				+ "\n4) Exit");
				
	}
	
	public static void printWouldYouLike() {
		System.out.println("What would you like to do \n1) Create a Secondary User"
				+ " \n2) View our Menu/ Order \n3) Exit" );
	}
		
	public static int handleUserSelection(int userSelection, Scanner scanner) {
		
		try {
			userSelection = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Sorry, that is not a valid number.");
		}
		scanner.nextLine(); // Leaving this here as there is a newline character in the stream
		return userSelection;
	}
	
	
	public static void deleteOrLeave() {
		System.out.println("What would you like to do:"
				+ "\n1) Delete \n2) Exit");
		
	}
	
	public static User printGetName(Scanner scanner) {
		User user = new User();
		System.out.println("");
		user.setPrimaryName(scanner.nextLine().trim());
		System.out.println("Please enter your password");
		user.setPrimaryPassword(scanner.nextLine().trim());
//		user.setPrimaryName();
		return user;
	}
	
	public static String userValidation(String name, Scanner scanner) {
		try {
			name = scanner.nextLine();
		}catch(InputMismatchException e) {
			System.out.println("Sorry, that is not a valid User Name.");
		}
		
		scanner.nextLine(); // Leaving this here as there is a newline character in the stream
		return name;
	}
	
	
	public static void printSignIn() {
		System.out.println("May I have you name please?");
	}
	
	public static void printSignInPass() {
	System.out.println("May I have you password please?");
	}

}


