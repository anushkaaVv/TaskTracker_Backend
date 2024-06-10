package com.TaskTracker.TaskTracker_backend.service;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.entity.Task;
import com.TaskTracker.TaskTracker_backend.requestObject.TaskRequestObject;


import java.util.List;

public interface TaskService {

    Task createTask(TaskDto request);

//    TaskDto createTask(TaskRequestObject request);
    TaskDto getTaskById(Long taskId);

      List<Task> getAllTasks();

      TaskDto updateTask(Long taskId, TaskDto updatedTask);

      void deleteTask(Long taskId);




}
