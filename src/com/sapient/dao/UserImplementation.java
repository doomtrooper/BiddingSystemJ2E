package com.sapient.dao;

import com.sapient.exceptions.InsertUserException;
import com.sapient.exceptions.UserAlreadyExistsException;
import com.sapient.exceptions.UserNotFoundException;
import com.sapient.vo.User;


public interface UserImplementation {
	public void insertUser(User u) throws InsertUserException;
	public String getPassword(String uname) throws UserNotFoundException;
	public User getUser(String uname) throws UserNotFoundException;
	public void checkExistingUser(String uname) throws UserAlreadyExistsException;
}
