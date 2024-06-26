package com.TaskTracker.TaskTracker_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;



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


    @Column(name  = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;



    @Column(name="end_date")
    private LocalDate date;









}
