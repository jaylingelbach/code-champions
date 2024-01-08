package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
