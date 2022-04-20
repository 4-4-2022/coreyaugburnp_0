package com.revature;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

import com.revature.client.AppUI;

import com.revature.model.Product;
import com.revature.model.SecondaryUser;
import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserReposityImpl;
import com.revature.repository.ProductRepository;
import com.revature.repository.ProductRepositoryImpl;
import com.revature.repository.SecondaryRepository;
import com.revature.repository.SecondaryRepositoryImpl;
import com.revature.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		
		
		
		
		UserRepository userRepository = new UserReposityImpl();
		UserService userService = new UserService();
		Set<User> users = userRepository.findAllUsers();
		
		ProductRepository productRepository = new ProductRepositoryImpl();//.getProductRepository();
		Set<Product> products = productRepository.findAllProducts();
		
		SecondaryRepository secondRepo = new SecondaryRepositoryImpl();
		Set<SecondaryUser> secondUsers = secondRepo.findSecondaryUsers();
		

		Scanner scanner = new Scanner(System.in);

		
		boolean isUserInterested = true;
		AppUI.printWelcomeMenu();
		while (isUserInterested) {
			
			
			int userSelection = 0; 
			userSelection = AppUI.handleUserSelection(userSelection, scanner);
			
			switch (userSelection) {
			case 1:
				

				User newUser = userService.getPrimaryInfo(scanner);
				userService.save(newUser);
				scanner.nextLine();
			case 2:
				AppUI.printSignIn();
				String name = scanner.nextLine();
				User currentUser = userService.findUser(name);
				AppUI.printSignInPass();
				String password = scanner.nextLine();
				userService.findSecUserPass(password);
				userService.findUserPass(password);
				
				
				
				if(currentUser.isEmployee() == true) {
					
					int n = 0;
					n = AppUI.handleUserSelection(userSelection, scanner);
					
					boolean admin = true;
					
					System.out.println("What would you like"
							+ " to do \n1) View Record "
							+ "\n2)Cancel Records \n3)Modify Records");
					
					while(admin) {
						
						
						
					switch (n)
					{
					
					    case 1: 
					    	scanner.nextLine();
					    	for(User user:users) {
					    		System.out.println(user);
					    	}
					    	
					    	int ui = 0;
							n = AppUI.handleUserSelection(userSelection, scanner);
							
							boolean admin2 = true;
							
							System.out.println("What would you like"
									+ " to do \n1)  "
									+ "\n2)Cancel Records \n3)Modify Records");
							
							while(admin2)
					    	
					    	
					  break;
					    case 2: 
					  break;
					    default: 
					      admin = false;
					}
				}
				}
				AppUI.printWouldYouLike();
				
				
				int admin = 0;
				admin = AppUI.handleUserSelection(userSelection, scanner);
				
				boolean creating = true;
				
				while(creating) {
					
				switch (admin){
				    case 1: 
				    	SecondaryUser newSec = userService.getSecondaryInformation(scanner);
				    	userService.save(newSec);
				    	
				    case 2: 
				    	for(Product product:products) {
				    		System.out.println(product);
				    	}
				    	scanner.nextLine();
				    	
				    	System.out.println(" \n1) Twix \n2) Bottled Water \n3) Juice \n4) Snickers \n5) Exit");
				    	int admin3 = 0;
						admin = AppUI.handleUserSelection(userSelection, scanner);
						
						int selectedProductNumber = admin3 + 1;
						
						boolean creating2 = true;
						
						while(creating2) {
							
						switch (admin3){
						    case 1: 
						    		float order = (float) userService.orderProduct(admin3);
						    		User orderUser = userService.userOrder(currentUser, order);
						    		userService.update(orderUser);
						    		System.out.println(orderUser);
						    case 2: 
						    	for(Product product:products) {
						    		System.out.println(product);
						    	}
						    	scanner.nextLine();
						    break;
						    case 3:
						    	
						    break;
						}
						}
				  break;
				    case 3:
				    	System.out.println("modify records");
				    	scanner.nextLine();
				  break;
				    default: 
				    	creating =false;
				}
				}
				break;
			case 3:
				System.out.println("Which flavor would you like to view: ");
//				System.out.println(userService.findCupcakesByFlavor(scanner));

				break;
			case 4:
				for(Product product: products) {
				System.out.println(product);
				}
				break;
			case 5:
				System.out.println("Bye bye!");
				isUserInterested = false;
				break;
			default:
				break;
			}
		}

		scanner.close();
		
	}
}
