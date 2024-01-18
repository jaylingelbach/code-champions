package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {

}
