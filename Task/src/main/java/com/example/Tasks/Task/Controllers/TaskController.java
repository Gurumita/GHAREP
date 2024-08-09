package com.example.Tasks.Task.Controllers;

import com.example.Tasks.Task.Models.Tasks;
import com.example.Tasks.Task.Services.TaskService;
import org.openapitools.client.api.QuestionControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("api/Tasks")
public class TaskController {
    @Autowired
    private TaskService Taskservice;

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks tasks){
        return new ResponseEntity<>(Taskservice.createTask(tasks), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getallTasks(){
        return new ResponseEntity<>(Taskservice.getallTasks(),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Tasks> updateTask(@RequestBody Tasks tasks){
        return new ResponseEntity<>(Taskservice.updateTask(tasks),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Tasks> deleteTask(@PathVariable int id){
        return new ResponseEntity<>(Taskservice.deleteTask(id),HttpStatus.OK);
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Tasks>> getTasksByProjectId(@PathVariable int projectId) {
        List<Tasks> tasks = Taskservice.getTasksByProjectId(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
