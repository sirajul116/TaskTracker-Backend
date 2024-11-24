package com.tirzok.TaskTracker.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long task_id;
    @Column (name = "category")
    private String category;
    @Column (name = "details")
    private String details;
    @Column (name = "status")
    private Boolean status;
    @Column (name = "persistence")
    private Boolean persistence;
}
