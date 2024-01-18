package com.codechampions.easytravel.repository;
import com.codechampions.easytravel.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
