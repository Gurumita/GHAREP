package com.example.Tasks.Task.Services;


import com.example.Tasks.Task.DAO.TaskRepository;
import com.example.Tasks.Task.Models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Tasks createTask(Tasks tasks) {
        taskRepository.save(tasks);
        return tasks;

    }
    public Tasks updateTask(Tasks tasks){
        taskRepository.save(tasks);
        return tasks;
    }

    public Optional<Tasks> getTasksbyId(int id){
        return taskRepository.findById(id);
    }
    public Tasks deleteTask(int id){
        Optional<Tasks> tasks= getTasksbyId(id);
        taskRepository.deleteById(id);
        return tasks.get();
    }

    public List<Tasks> getallTasks(){
        return taskRepository.findAll();
    }

    public List<Tasks> getTasksByProjectId(int projectId) {
        return taskRepository.findByProject(projectId);
    }


}


