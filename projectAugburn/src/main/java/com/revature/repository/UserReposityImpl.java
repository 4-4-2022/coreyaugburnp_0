package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.revature.Util.ConnectionFactory;

import com.revature.model.User;

public class UserReposityImpl implements UserRepository{

	//static makes it happen only one time
	
	public static UserReposityImpl userRepository ;
	public static int counter;
	
	
	public UserReposityImpl() {
		super();

		counter++;
	}
	
	
	
	public Set<User> findAllUsers() {
		
		Set<User> users = new HashSet<>();
		
		Connection conn = null;
		Statement stmt =null;
		ResultSet set = null; 
		final String SQL = "select * from usertable";
		
		try {
			conn = ConnectionFactory.getConnetion();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while(set.next()){
				User user = new User(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getFloat(4),
						set.getBoolean(5),
						set.getBoolean(6),
						set.getBoolean(7)
						);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			stmt.close();
			set.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return users;
	}




	@Override
	public void save(User user) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into usertable values(?, ?, ?, ?, ?, ?,?)";
		
		try {
			conn = ConnectionFactory.getConnetion();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, user.getUserId());
			stmt.setString(2, user.getPrimaryName());
			stmt.setString(3, user.getPrimaryPassword());
			stmt.setFloat(4, user.getPrimaryBalance());
			stmt.setBoolean(5, user.isHasSecondaryUser());
			stmt.setBoolean(6, user.isAdmin());
			stmt.setBoolean(7, user.isEmployee());
			stmt.execute(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
		conn.close();
		stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	


	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void priceUpdate(User user) {
		
		
			
			Connection conn = null;
			PreparedStatement stmt = null;
			final String SQL = "update usertable set where primarybalance(?, ?, ?, ?, ?, ?,?)";
			
			try {
				conn = ConnectionFactory.getConnetion();
				stmt = conn.prepareStatement(SQL);
				stmt.setInt(1, user.getUserId());
				stmt.setString(2, user.getPrimaryName());
				stmt.setString(3, user.getPrimaryPassword());
				stmt.setFloat(4, user.getPrimaryBalance());
				stmt.setBoolean(5, user.isHasSecondaryUser());
				stmt.setBoolean(6, user.isAdmin());
				stmt.setBoolean(7, user.isEmployee());
				stmt.execute(); 
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
			conn.close();
			stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}


//	@Override
//	public void primaryTransferUpdate(User user) {
//		
//			
//			Connection conn = null;
//			PreparedStatement stmt = null;
//			final String SQL = "insert into usertable values(?, ?, ?, ?, ?, ?,?)";
//			
//			try {
//				conn = ConnectionFactory.getConnetion();
//				stmt = conn.prepareStatement(SQL);
//				stmt.setInt(1, user.getUserId());
//				stmt.setString(2, user.getPrimaryName());
//				stmt.setString(3, user.getPrimaryPassword());
//				stmt.setFloat(4, user.getPrimaryBalance());
//				stmt.setBoolean(5, user.isHasSecondaryUser());
//				stmt.setBoolean(6, user.isAdmin());
//				stmt.setBoolean(7, user.isEmployee());
//				stmt.execute(); 
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}finally {
//				try {
//			conn.close();
//			stmt.close();
//				}catch(SQLException e){
//					e.printStackTrace();
//				}
//		}
//		
//	}







	
}
