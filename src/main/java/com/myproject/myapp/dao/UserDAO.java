package com.myproject.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.myapp.domain.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	

}
