package com.myproject.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.myapp.dao.UserDAO;
import com.myproject.myapp.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userdb;
	
	@Override
	@Transactional
	public User create(User user) {
		// TODO Auto-generated method stub
		return userdb.save(user);
	}

	
}
