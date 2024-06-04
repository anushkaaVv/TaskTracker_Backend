package com.TaskTracker.TaskTracker_backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDto {


    private  Long id;
    @NotEmpty
    private  String taskName;
    @NotEmpty
    private String status;

    @NotNull
    private LocalDate date;

}
