package com.TaskTracker.TaskTracker_backend.service;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.entity.Task;
import com.TaskTracker.TaskTracker_backend.exception.ResourceNotFoundException;
import com.TaskTracker.TaskTracker_backend.mapper.TaskMapper;
import com.TaskTracker.TaskTracker_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;
    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.taskDtoToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return taskMapper.taskToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
       Task task =  taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task with this Id is not there"  +taskId));
        return taskMapper.taskToTaskDto(task);
    }


    @GetMapping("tasks")
    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> list = taskRepository.findAll();

        return list.stream().map((task) -> taskMapper.taskToTaskDto(task))
                .collect(Collectors.toList());

    }



    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
       Task task = taskRepository.findById(taskId).orElseThrow(() ->
                new ResourceNotFoundException("No matching taskId" + taskId));

       task.setTaskName(updatedTask.getTaskName());
       task.setStatus(updatedTask.getStatus());
       Task updatedTaskObj = taskRepository.save(task);
        return taskMapper.taskToTaskDto(updatedTaskObj);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task =  taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(" This Id is not there"  +taskId));

       taskRepository.deleteById((taskId));
    }

}
