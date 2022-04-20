package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.Util.ConnectionFactory;
import com.revature.model.SecondaryUser;
import com.revature.model.User;

public class SecondaryRepositoryImpl implements SecondaryRepository{

	public static SecondaryRepositoryImpl secondaryRepository ;
	
	public SecondaryRepositoryImpl(){
		super();
	}

	
	
	@Override
	public Set<SecondaryUser> findSecondaryUsers() {
		
		Set<SecondaryUser> secondaryUsers = new HashSet<>();
		
		Connection conn = null;
		Statement stmt =null;
		ResultSet set = null; 
		final String SQL = "select * from secondaryuser";
		
		try {
			conn = ConnectionFactory.getConnetion();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while(set.next()){
				SecondaryUser secondaryUser = new SecondaryUser(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getFloat(4)
						);
				secondaryUsers.add(secondaryUser);
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
		
		return secondaryUsers;
	}
	

public void save(SecondaryUser secuser) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into secondaryuser values(?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnetion();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, secuser.getSecondaryId());
			stmt.setString(2, secuser.getSecondaryName());
			stmt.setString(3, secuser.getSecondaryPassword());
			stmt.setFloat(4, secuser.getSecondaryBalance());
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




}
	
	
	
	
	

