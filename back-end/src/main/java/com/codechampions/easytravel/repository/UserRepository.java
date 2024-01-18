package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.User;
import com.codechampions.easytravel.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Activity,Integer> {
}

