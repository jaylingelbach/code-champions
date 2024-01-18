package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
