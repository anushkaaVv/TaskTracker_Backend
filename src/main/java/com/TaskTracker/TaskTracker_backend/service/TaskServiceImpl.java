package com.TaskTracker.TaskTracker_backend.service;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.entity.Task;
import com.TaskTracker.TaskTracker_backend.exception.ResourceNotFoundException;
import com.TaskTracker.TaskTracker_backend.mapper.TaskMapper;
import com.TaskTracker.TaskTracker_backend.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    @Override
    public TaskDto createTask(TaskDto taskDto) {

        Task task = TaskMapper.mapToTask(taskDto);

        Task savedTask = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {

       Task task =  taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task with this Id is not there"  +taskId));
        return TaskMapper.mapToTaskDto(task);
    }


    @GetMapping("tasks")
    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> list = taskRepository.findAll();

        return list.stream().map((task) -> TaskMapper.mapToTaskDto(task))
                .collect(Collectors.toList());

    }



    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
       Task task = taskRepository.findById(taskId).orElseThrow(() ->
                new ResourceNotFoundException("No matching taskId" + taskId));

       task.setTaskName(updatedTask.getTaskName());
       task.setStatus(updatedTask.getStatus());

       Task updatedTaskObj = taskRepository.save(task);


        return TaskMapper.mapToTaskDto(updatedTaskObj);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task =  taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(" this Id is not there"  +taskId));

       taskRepository.deleteById((taskId));
    }

}
