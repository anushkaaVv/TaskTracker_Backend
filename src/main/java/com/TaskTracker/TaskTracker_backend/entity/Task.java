package com.TaskTracker.TaskTracker_backend.entity;

import jakarta.persistence.*;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name ="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "task_name")
    private String taskName;

//    @Enumerated(EnumType.STRING)
    @Column(name  = "status")
    private String status;

    @Column(name="end_date")
    private LocalDate date;




}
