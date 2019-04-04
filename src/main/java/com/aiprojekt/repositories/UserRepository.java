package com.aiprojekt.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.aiprojekt.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

	public Optional<User> findByUserId(long userId);
	
	public Optional<User> findByLoginName(String loginName);
	
	
}
