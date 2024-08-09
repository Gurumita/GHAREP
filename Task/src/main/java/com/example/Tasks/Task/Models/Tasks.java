package com.example.Tasks.Task.Models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "task")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int task_id;

    @Column(name = "task_name")
    private String task_name;

    @Column(name = "task_desc")
    private String task_desc;

    @Column(name = "task_status")
    private String task_status;

    private int project;

    public Tasks() {
    }

    public Tasks(int task_id, String task_name, String task_desc, String task_status, int project) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_desc = task_desc;
        this.task_status = task_status;
        this.project = project;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }
}