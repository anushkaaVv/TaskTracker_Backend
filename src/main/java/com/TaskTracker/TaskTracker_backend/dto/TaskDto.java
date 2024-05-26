package com.TaskTracker.TaskTracker_backend.dto;


import com.TaskTracker.TaskTracker_backend.entity.Task;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDto {


    private  Long id;
    private  String taskName;
    private  String status;
}