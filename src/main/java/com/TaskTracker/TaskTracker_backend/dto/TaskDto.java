package com.TaskTracker.TaskTracker_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDto {


    private  Long id;

    @NotBlank(message = "Task name cannot be blank")
    @Length(min = 3, max = 30, message = "Task name must be between 3-15 characters")
    private  String taskName;


    @NotBlank(message = "Status cannot be blank")
    private String status;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;


}
