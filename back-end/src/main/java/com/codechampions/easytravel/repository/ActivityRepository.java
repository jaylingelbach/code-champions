package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long> {

}
