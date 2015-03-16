package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sapient.exceptions.InsertUserException;
import com.sapient.exceptions.UserAlreadyExistsException;
import com.sapient.exceptions.UserNotFoundException;
import com.sapient.vo.User;

public class UserDao extends AbsDao implements UserImplementation{
	public Connection conn; 
	
	public void insertUser(User u) throws InsertUserException {
		conn=getConnection();
		PreparedStatement insertUser;
		try {
			insertUser = conn.prepareStatement(Queries.insertUser);
			insertUser.setString(1, u.getUserName());
			insertUser.setString(2, u.getUserCompany());
			insertUser.setString(3, u.getUserContact());
			insertUser.setString(4, u.getUserNationality());
			insertUser.setString(5, u.getUserPassword());
			int rs=insertUser.executeUpdate();
			if(rs==0) throw new InsertUserException("User Not Inserted :/");
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}

	public String getPassword(String uname) throws UserNotFoundException {
				conn=getConnection();
				String password = null;
				try {
					PreparedStatement getPass=conn.prepareStatement(Queries.loginValidation);
					getPass.setString(1, uname);
					ResultSet rs=getPass.executeQuery();
					if(!rs.next()) throw new UserNotFoundException("User Not found :(");
					password=rs.getString("password");
					return password;
				} catch (SQLException e) {
					e.getMessage();
					e.printStackTrace();
				}
				
				return password;
		
	}
	
	public User getUser(String uname) throws UserNotFoundException{
		conn=getConnection();
		User newUser=new User();
		try {
			PreparedStatement getUserInfo=conn.prepareStatement(Queries.getUserInfo);
			getUserInfo.setString(1, uname);
			ResultSet rs=getUserInfo.executeQuery();
			if(!rs.next()) throw new UserNotFoundException("Can't FInd the User");
			newUser.setUserId(rs.getInt("id"));
			newUser.setUserName(rs.getString("name"));
			newUser.setUserCompany(rs.getString("company"));
			newUser.setUserContact(rs.getString("contact"));
			newUser.setUserNationality(rs.getString("nationality"));
			newUser.setUserPassword(rs.getString("password"));
			return newUser;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return newUser;
	}

	public void checkExistingUser(String uname) throws UserAlreadyExistsException {
		try {
			PreparedStatement checkUser=conn.prepareStatement(Queries.getUserInfo);
			checkUser.setString(1, uname);
			ResultSet rs=checkUser.executeQuery();
			if (!rs.next()) throw new UserAlreadyExistsException("User already exists. Try again.");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
}
