package com.TaskTracker.TaskTracker_backend.service;

import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.entity.Task;
import com.TaskTracker.TaskTracker_backend.exception.ResourceNotFoundException;
import com.TaskTracker.TaskTracker_backend.mapper.TaskMapper;
import com.TaskTracker.TaskTracker_backend.repository.TaskRepository;
import com.TaskTracker.TaskTracker_backend.requestObject.TaskRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.stream.Collectors;




@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;


    public Task findThisId(Long taskId){

        Task task =  taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task with "+ taskId + " "  + "Id is not there"  ));
        return task;
    }
    @Override
    public Task createTask(TaskDto taskDto) {
//        TaskDto taskDto = taskMapper.requestToTaskDto(request);
        Task task = taskMapper.taskDtoToTask(taskDto);
        Task savedTask = taskRepository.save(task);
//        TaskDto t =  taskMapper.taskToTaskDto(savedTask);

//        return  t;

        return savedTask;
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
            Task task = findThisId(taskId);
        return taskMapper.taskToTaskDto(task);
    }


    @GetMapping("tasks")
    @Override
    public List<Task> getAllTasks() {
        List<Task> list = taskRepository.findAll(Sort.by("date").ascending());

//        return list.stream().map((task) -> taskMapper.taskToTaskDto(task))
//                .collect(Collectors.toList());

        return list;

    }


    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
        Task task = findThisId(taskId);
       task.setTaskName(updatedTask.getTaskName());
       task.setStatus(updatedTask.getStatus());
        task.setDate(updatedTask.getDate());

       Task updatedTaskObj = taskRepository.save(task);
        return taskMapper.taskToTaskDto(updatedTaskObj);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = findThisId(taskId);
       taskRepository.deleteById((taskId));
    }

}
