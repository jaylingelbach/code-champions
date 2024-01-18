package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Integer> {

}
