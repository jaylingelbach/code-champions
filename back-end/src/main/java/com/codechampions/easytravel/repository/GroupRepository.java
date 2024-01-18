package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

}
