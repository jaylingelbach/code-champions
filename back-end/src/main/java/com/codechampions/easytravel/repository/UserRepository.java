package com.codechampions.easytravel.repository;


import com.codechampions.easytravel.model.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    User findByUsername(String username);
}
