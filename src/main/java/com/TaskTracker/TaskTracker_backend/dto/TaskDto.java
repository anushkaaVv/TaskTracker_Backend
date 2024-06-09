package com.TaskTracker.TaskTracker_backend.dto;

import com.TaskTracker.TaskTracker_backend.entity.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDto {
    private  String id;
    private  String taskName;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private LocalDate date;





}
