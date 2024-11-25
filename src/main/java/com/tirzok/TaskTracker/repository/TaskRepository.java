package com.tirzok.TaskTracker.repository;

import com.tirzok.TaskTracker.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCategory(String category);
}
