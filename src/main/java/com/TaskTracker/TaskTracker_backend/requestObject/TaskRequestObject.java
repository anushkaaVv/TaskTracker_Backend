
//For Future REference extra layer added for  abstraction of authencation


package com.TaskTracker.TaskTracker_backend.requestObject;

import com.TaskTracker.TaskTracker_backend.entity.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestObject {


    @Length(min = 3, max = 30, message = "Task name must be between 3-15 characters")
    private  String taskName;


    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @NotNull(message = "Date cannot be null")
    private LocalDate date;

}
