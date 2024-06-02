package com.TaskTracker.TaskTracker_backend.mapper;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TaskMapper {

    @Autowired
    private  ModelMapper modelMapper;


    public  TaskDto taskToTaskDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }


    public Task taskDtoToTask(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }

}
