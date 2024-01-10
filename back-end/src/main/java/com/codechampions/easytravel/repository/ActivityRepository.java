package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    List<Activity> findByGroupId(Long groupId);
}
