package com.TaskTracker.TaskTracker_backend.mapper;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task){
        return new TaskDto(
            task.getId(),
            task.getTaskName(),
            task.getStatus(),
                task.getDate()

        );
    }


    public static Task mapToTask(TaskDto taskDto){
        return new Task(
               taskDto.getId(),
               taskDto.getTaskName(),
                taskDto.getStatus(),
                taskDto.getDate()
        );
    }
}
