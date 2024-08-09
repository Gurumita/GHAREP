package com.example.Tasks.Task.DAO;
import com.example.Tasks.Task.Models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository <Projects, Integer> {
}
