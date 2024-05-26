package com.TaskTracker.TaskTracker_backend.repository;

import com.TaskTracker.TaskTracker_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
