package com.codechampions.easytravel.repository;


import com.codechampions.easytravel.model.User;
import com.codechampions.easytravel.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    UserProfile findByUsername(String username);
}