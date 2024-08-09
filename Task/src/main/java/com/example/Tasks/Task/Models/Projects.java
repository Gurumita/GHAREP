package com.example.Tasks.Task.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int project_id;

    @Column(name = "project_name")
    private String project_name;

    @Column(name = "project_description")
    private String project_description;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private List<Tasks> tasks;

    public Projects(){}

    public Projects(int project_id, String project_name, String project_description, List<Tasks> tasks) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.tasks = tasks;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}