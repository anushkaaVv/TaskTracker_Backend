package com.TaskTracker.TaskTracker_backend.service;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto taskDto);
    TaskDto getTaskById(Long taskId);

      List<TaskDto> getAllTasks();

      TaskDto updateTask(Long taskId, TaskDto updatedTask);

      void deleteTask(Long taskId);




}
