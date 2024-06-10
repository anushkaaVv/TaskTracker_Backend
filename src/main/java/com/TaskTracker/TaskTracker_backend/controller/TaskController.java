package com.TaskTracker.TaskTracker_backend.controller;
import com.TaskTracker.TaskTracker_backend.dto.TaskDto;
import com.TaskTracker.TaskTracker_backend.entity.Task;
import com.TaskTracker.TaskTracker_backend.requestObject.TaskRequestObject;
import com.TaskTracker.TaskTracker_backend.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController

public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("taskId") Long taskId){
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }


    @GetMapping("/tasks")
    public  ResponseEntity<List<Task>> getAllTasks(){
        List<Task> list = taskService.getAllTasks();
        return ResponseEntity.ok(list);

    }

    @PostMapping("/task")
    public ResponseEntity<?> createTask( @Valid @RequestBody TaskDto request){
        Task savedTask = taskService.createTask(request);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
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
