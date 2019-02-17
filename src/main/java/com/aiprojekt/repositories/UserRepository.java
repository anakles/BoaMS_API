package com.aiprojekt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.aiprojekt.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
