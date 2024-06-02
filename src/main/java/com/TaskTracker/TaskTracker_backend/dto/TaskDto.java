package com.TaskTracker.TaskTracker_backend.dto;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDto {


    private  Long id;
    private  String taskName;
    private  String status;
    private LocalDate date;
}
