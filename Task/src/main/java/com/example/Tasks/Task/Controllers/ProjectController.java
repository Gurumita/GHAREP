package com.example.Tasks.Task.Controllers;

import com.example.Tasks.Task.Models.Projects;
import com.example.Tasks.Task.Models.Tasks;
import com.example.Tasks.Task.Services.ProjectService;
import com.example.Tasks.Task.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Projects> createProject(@RequestBody Projects projects) {
        return new ResponseEntity<>(projectService.createProject(projects), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Projects> updateProject(@RequestBody Projects projects){
        return new ResponseEntity<>(projectService.updateProject(projects),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Projects> deleteProject(@PathVariable int id){
        return new ResponseEntity<>(projectService.deleteProject(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Projects>> getallProjects(){
        return new ResponseEntity<>(projectService.getallProjects(),HttpStatus.OK);
    }


}