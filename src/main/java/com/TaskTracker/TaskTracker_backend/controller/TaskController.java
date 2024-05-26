package com.TaskTracker.TaskTracker_backend.controller;


import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        TaskDto savedTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("taskId") Long taskId){
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }


    @GetMapping("/tasks")
    public  ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> list = taskService.getAllTasks();
        return ResponseEntity.ok(list);

    }


    @PutMapping("/tasks/{taskId}")
    public  ResponseEntity<TaskDto> updateTask(@PathVariable("taskId") Long taskId, @RequestBody TaskDto updatedTask){
        TaskDto taskDto = taskService.updateTask(taskId, updatedTask);

        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping("tasks/{taskId}")

    public ResponseEntity<String> deleteTask(@PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task Deleted");
    }
}
