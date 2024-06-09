package com.TaskTracker.TaskTracker_backend.service;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.requestObject.TaskRequestObject;


import java.util.List;

public interface TaskService {

    TaskRequestObject createTask(TaskRequestObject request);

//    TaskDto createTask(TaskRequestObject request);
    TaskDto getTaskById(Long taskId);

      List<TaskDto> getAllTasks();

      TaskDto updateTask(Long taskId, TaskDto updatedTask);

      void deleteTask(Long taskId);




}
